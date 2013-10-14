package spacecraft.mods.galacticraft.devVenus;

import java.io.File;

import spacecraft.mods.galacticraft.devVenus.blocks.GCMarsBlocks;
import spacecraft.mods.galacticraft.devVenus.dimension.GCMarsTeleportType;
import spacecraft.mods.galacticraft.devVenus.dimension.GCMarsWorldProvider;
import spacecraft.mods.galacticraft.devVenus.entities.GCMarsEntityLandingBalloons;
import spacecraft.mods.galacticraft.devVenus.entities.GCMarsEntityRocketT2;
import spacecraft.mods.galacticraft.devVenus.items.GCMarsItems;
import spacecraft.mods.galacticraft.devVenus.network.GCMarsPacketHandlerServer;
import spacecraft.mods.galacticraft.devVenus.recipe.GCMarsRecipeManager;
import spacecraft.mods.galacticraft.devVenus.schematic.GCMarsSchematicRocketT2;
import spacecraft.mods.galacticraft.devVenus.tile.GCMarsTileEntityDungeonSpawner;
import spacecraft.mods.galacticraft.devVenus.tile.GCMarsTileEntityTreasureChest;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCCoreCreativeTab;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = GalacticraftMars.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GalacticraftMars.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GalacticraftMars.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GalacticraftMars
{
    public static final String NAME = "Galacticraft Mars";
    public static final String MODID = "GalacticraftMars";
    public static final String CHANNEL = "GalacticraftMars";
    public static final String CHANNELENTITIES = "GCMarsEntities";

    public static final String LANGUAGE_PATH = "/assets/galacticraftmars/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "fi_FI", "ru_RU" };

    @SidedProxy(clientSide = "micdoodle8.mods.galacticraft.mars.client.ClientProxyMars", serverSide = "micdoodle8.mods.galacticraft.mars.CommonProxyMars")
    public static CommonProxyMars proxy;

    @Instance(GalacticraftMars.MODID)
    public static GalacticraftMars instance;

    public static GCCoreCreativeTab galacticraftMarsTab;

    public static final String TEXTURE_DOMAIN = "galacticraftmars";
    public static final String TEXTURE_PREFIX = GalacticraftMars.TEXTURE_DOMAIN + ":";

    public static Fluid SLUDGE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new GCMarsEvents());
        new GCMarsConfigManager(new File(event.getModConfigurationDirectory(), "Galacticraft/mars.conf"));

//        GalacticraftMars.SLUDGE = new Fluid("bacterialsludge").setBlockID(GCMarsConfigManager.idBlockBacterialSludge).setViscosity(3000);
//        if (!FluidRegistry.registerFluid(GalacticraftMars.SLUDGE))
        {
//            GCLog.info("\"bacterialsludge\" has already been registered as a fluid, ignoring...");
        }

        GCMarsBlocks.initBlocks();
//        GCMarsBlocks.registerBlocks();
        GCMarsBlocks.setHarvestLevels();

        GCMarsItems.initItems();

        GalacticraftMars.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GalacticraftMars.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GalacticraftMars.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GalacticraftMars.LANGUAGE_PATH + language + ".lang", child, false);
                            languages++;
                        }
                    }
                }
                catch (Exception e)
                {
                    FMLLog.severe("Failed to load a child language file.");
                    e.printStackTrace();
                }
            }

            languages++;
        }

        GCLog.info("Galacticraft Mars Loaded: " + languages + " Languages.");

        SchematicRegistry.registerSchematicRecipe(new GCMarsSchematicRocketT2());
//        SchematicRegistry.registerSchematicRecipe(new GCMarsSchematicCargoRocket());

        GalacticraftMars.galacticraftMarsTab = new GCCoreCreativeTab(CreativeTabs.getNextID(), GalacticraftMars.MODID, GCMarsItems.spaceship.itemID, 5);
        NetworkRegistry.instance().registerGuiHandler(GalacticraftMars.instance, GalacticraftMars.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GalacticraftMars.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCMarsWorldProvider.class, new GCMarsTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCMarsPlanet());
        GalacticraftRegistry.registerRocketGui(GCMarsWorldProvider.class, new ResourceLocation(GalacticraftMars.TEXTURE_DOMAIN, "textures/gui/marsRocketGui.png"));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCMarsItems.schematic, 1, 0));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCMarsItems.schematic, 1, 1));

        CompressorRecipes.addShapelessRecipe(new ItemStack(GCMarsItems.marsItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
        CompressorRecipes.addShapelessRecipe(new ItemStack(GCMarsItems.marsItemBasic, 1, 5), new ItemStack(GCMarsItems.marsItemBasic, 1, 2));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCMarsPacketHandlerServer(), GalacticraftMars.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
//        GameRegistry.registerTileEntity(GCMarsTileEntitySlimelingEgg.class, "Slimeling Egg");
        GameRegistry.registerTileEntity(GCMarsTileEntityTreasureChest.class, "Tier 2 Treasure Chest");
//        GameRegistry.registerTileEntity(GCMarsTileEntityTerraformer.class, "Planet Terraformer");
//        GameRegistry.registerTileEntity(GCMarsTileEntityCryogenicChamber.class, "Cryogenic Chamber");
        GameRegistry.registerTileEntity(GCMarsTileEntityDungeonSpawner.class, "Mars Dungeon Spawner");
//        GameRegistry.registerTileEntity(GCMarsTileEntityLaunchController.class, "Launch Controller");
    }

    public void registerCreatures()
    {
//        this.registerGalacticraftCreature(GCMarsEntitySludgeling.class, "Sludgeling", GCMarsConfigManager.idEntitySludgeling, GCCoreUtil.convertTo32BitColor(255, 0, 0, 50), GCCoreUtil.convertTo32BitColor(255, 0, 0, 150));
//        this.registerGalacticraftCreature(GCMarsEntitySlimeling.class, "Slimeling", GCMarsConfigManager.idEntitySlimeling, GCCoreUtil.convertTo32BitColor(255, 0, 0, 50), GCCoreUtil.convertTo32BitColor(255, 0, 0, 150));
//        this.registerGalacticraftCreature(GCMarsEntityCreeperBoss.class, "CreeperBoss", GCMarsConfigManager.idEntityCreeperBoss, GCCoreUtil.convertTo32BitColor(255, 0, 0, 50), GCCoreUtil.convertTo32BitColor(255, 0, 0, 150));
    }

    public void registerOtherEntities()
    {
        this.registerGalacticraftNonMobEntity(GCMarsEntityRocketT2.class, "SpaceshipT2", GCMarsConfigManager.idEntitySpaceshipTier2, 150, 1, true);
        this.registerGalacticraftNonMobEntity(GCMarsEntityRocketT2.class, "SpaceshipT2", GCMarsConfigManager.idEntitySpaceshipTier2, 150, 1, true);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityTerraformBubble.class, "TerraformBubble", GCMarsConfigManager.idEntityTerraformBubble, 150, 20, false);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityProjectileTNT.class, "ProjectileTNT", GCMarsConfigManager.idEntityProjectileTNT, 150, 1, true);
        this.registerGalacticraftNonMobEntity(GCMarsEntityLandingBalloons.class, "LandingBalloons", GCMarsConfigManager.idEntityLandingBalloons, 150, 5, true);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityCargoRocket.class, "CargoRocket", GCMarsConfigManager.idEntityCargoRocket, 150, 1, false);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GalacticraftMars.proxy.postInit(event);
        GalacticraftMars.proxy.registerRenderInformation();
        GCMarsRecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GalacticraftMars.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
