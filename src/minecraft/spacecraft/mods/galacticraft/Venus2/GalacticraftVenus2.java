package spacecraft.mods.galacticraft.Venus2;

import java.io.File;

import spacecraft.mods.galacticraft.Venus2.blocks.GCVenus2Blocks;
import spacecraft.mods.galacticraft.Venus2.dimension.GCVenus2TeleportType;
import spacecraft.mods.galacticraft.Venus2.dimension.GCVenus2WorldProvider;
import spacecraft.mods.galacticraft.Venus2.entities.GCVenus2EntityRocketT3;
import spacecraft.mods.galacticraft.Venus2.items.GCVenus2Items;
import spacecraft.mods.galacticraft.Venus2.network.GCVenus2PacketHandlerServer;
import spacecraft.mods.galacticraft.Venus2.recipe.GCVenus2RecipeManager;
import spacecraft.mods.galacticraft.Venus2.schematic.GCVenus2SchematicRocketT3;
import spacecraft.mods.galacticraft.Venus2.tile.GCVenus2TileEntityTreasureChest;
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

@Mod(name = GalacticraftVenus2.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GalacticraftVenus2.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GalacticraftVenus2.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GalacticraftVenus2
{
    public static final String NAME = "Galacticraft Venus2";
    public static final String MODID = "GalacticraftVenus2";
    public static final String CHANNEL = "GalacticraftVenus2";
    public static final String CHANNELENTITIES = "GCVenus2Entities";

    public static final String LANGUAGE_PATH = "/assets/galacticraftmars/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "fi_FI", "ru_RU" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.Venus2.client.ClientProxyVenus2", serverSide = "spacecraft.mods.galacticraft.Venus2.CommonProxyVenus2")
    public static CommonProxyVenus2 proxy;

    @Instance(GalacticraftVenus2.MODID)
    public static GalacticraftVenus2 instance;

    public static GCCoreCreativeTab galacticraftVenus2Tab;

    public static final String TEXTURE_DOMAIN = "galacticraftvenus2";
    public static final String TEXTURE_PREFIX = GalacticraftVenus2.TEXTURE_DOMAIN + ":";

    public static Fluid SLUDGE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new GCVenus2Events());
        new GCVenus2ConfigManager(new File(event.getModConfigurationDirectory(), "Spacecraft/venus2.conf"));

//        GalacticraftMars.SLUDGE = new Fluid("bacterialsludge").setBlockID(GCMarsConfigManager.idBlockBacterialSludge).setViscosity(3000);
//        if (!FluidRegistry.registerFluid(GalacticraftMars.SLUDGE))
        {
//            GCLog.info("\"bacterialsludge\" has already been registered as a fluid, ignoring...");
        }

        GCVenus2Blocks.initBlocks();
//        GCMarsBlocks.registerBlocks();
        GCVenus2Blocks.setHarvestLevels();

        GCVenus2Items.initItems();

        GalacticraftVenus2.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GalacticraftVenus2.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GalacticraftVenus2.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GalacticraftVenus2.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Galacticraft Venus2 Loaded: " + languages + " Languages.");

        SchematicRegistry.registerSchematicRecipe(new GCVenus2SchematicRocketT3());
//        SchematicRegistry.registerSchematicRecipe(new GCMarsSchematicCargoRocket());

        GalacticraftVenus2.galacticraftVenus2Tab = new GCCoreCreativeTab(CreativeTabs.getNextID(), GalacticraftVenus2.MODID, GCVenus2Items.spaceship.itemID, 5);
        NetworkRegistry.instance().registerGuiHandler(GalacticraftVenus2.instance, GalacticraftVenus2.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GalacticraftVenus2.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCVenus2WorldProvider.class, new GCVenus2TeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVenus2Planet());
        GalacticraftRegistry.registerRocketGui(GCVenus2WorldProvider.class, new ResourceLocation(GalacticraftVenus2.TEXTURE_DOMAIN, "textures/gui/marsRocketGui.png"));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCVenus2Items.schematic, 1, 0));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCVenus2Items.schematic, 1, 1));

        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenus2Items.marsItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenus2Items.marsItemBasic, 1, 5), new ItemStack(GCVenus2Items.marsItemBasic, 1, 2));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCVenus2PacketHandlerServer(), GalacticraftVenus2.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
//        GameRegistry.registerTileEntity(GCMarsTileEntitySlimelingEgg.class, "Slimeling Egg");
        GameRegistry.registerTileEntity(GCVenus2TileEntityTreasureChest.class, "Tier 3 Treasure Chest");
//        GameRegistry.registerTileEntity(GCMarsTileEntityTerraformer.class, "Planet Terraformer");
//        GameRegistry.registerTileEntity(GCMarsTileEntityCryogenicChamber.class, "Cryogenic Chamber");
//        GameRegistry.registerTileEntity(GCMarsTileEntityDungeonSpawner.class, "Mars Dungeon Spawner");
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
        this.registerGalacticraftNonMobEntity(GCVenus2EntityRocketT3.class, "SpaceshipT3", GCVenus2ConfigManager.idEntitySpaceshipTier3, 150, 1, true);
        this.registerGalacticraftNonMobEntity(GCVenus2EntityRocketT3.class, "SpaceshipT3", GCVenus2ConfigManager.idEntitySpaceshipTier3, 150, 1, true);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityTerraformBubble.class, "TerraformBubble", GCMarsConfigManager.idEntityTerraformBubble, 150, 20, false);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityProjectileTNT.class, "ProjectileTNT", GCMarsConfigManager.idEntityProjectileTNT, 150, 1, true);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityLandingBalloons.class, "LandingBalloons", GCMarsConfigManager.idEntityLandingBalloons, 150, 5, true);
//        this.registerGalacticraftNonMobEntity(GCMarsEntityCargoRocket.class, "CargoRocket", GCMarsConfigManager.idEntityCargoRocket, 150, 1, false);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GalacticraftVenus2.proxy.postInit(event);
        GalacticraftVenus2.proxy.registerRenderInformation();
        GCVenus2RecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GalacticraftVenus2.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
