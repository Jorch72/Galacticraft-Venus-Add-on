package spacecraft.mods.galacticraft.venus2;

import java.io.File;

import spacecraft.mods.galacticraft.venus2.blocks.GCVenus2Blocks;
import spacecraft.mods.galacticraft.venus2.dimension.GCVenus2TeleportType;
import spacecraft.mods.galacticraft.venus2.dimension.GCVenus2WorldProvider;
import spacecraft.mods.galacticraft.venus2.entities.GCVenus2EntityRocketT3;
import spacecraft.mods.galacticraft.venus2.items.GCVenus2Items;
import spacecraft.mods.galacticraft.venus2.network.GCVenus2PacketHandlerServer;
import spacecraft.mods.galacticraft.venus2.recipe.GCVenus2RecipeManager;
import spacecraft.mods.galacticraft.venus2.schematic.GCVenus2SchematicRocketT3;
import spacecraft.mods.galacticraft.venus2.tile.GCVenus2TileEntityTreasureChest;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
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

@Mod(name = GCVenus2.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus2.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCVenus2.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus2
{
    public static final String NAME = "Galacticraft Venus 2";
    public static final String MODID = "GCVenus2";
    public static final String CHANNEL = "GCVenus2";
    public static final String CHANNELENTITIES = "GCVenus2Entities";

    public static final String LANGUAGE_PATH = "/assets/galacticraftvenus2/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.venus2.client.ClientProxyVenus2", serverSide = "spacecraft.mods.galacticraft.venus2.CommonProxyVenus2")
    public static CommonProxyVenus2 proxy;

    @Instance(GCVenus2.MODID)
    public static GCVenus2 instance;

    public static GCVenus2CreativeTab galacticraftVenus2Tab;

    public static final String TEXTURE_DOMAIN = "galacticraftvenus2";
    public static final String TEXTURE_PREFIX = GCVenus2.TEXTURE_DOMAIN + ":";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCVenus2ConfigManager(new File(event.getModConfigurationDirectory(), "Spacecraft/venus2.conf"));

        GCVenus2Blocks.initBlocks();
        GCVenus2Blocks.setHarvestLevels();

        GCVenus2Items.initItems();

        GCVenus2.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCVenus2.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCVenus2.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCVenus2.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCVenus2.galacticraftVenus2Tab = new GCVenus2CreativeTab(CreativeTabs.getNextID(), GCVenus2.MODID, GCVenus2Items.spaceship.itemID, 5);
        NetworkRegistry.instance().registerGuiHandler(GCVenus2.instance, GCVenus2.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCVenus2.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCVenus2WorldProvider.class, new GCVenus2TeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVenus2Planet());
        GalacticraftRegistry.registerRocketGui(GCVenus2WorldProvider.class, new ResourceLocation(GCVenus2.TEXTURE_DOMAIN, "textures/gui/venusRocketGui.png"));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCVenus2Items.schematic, 1, 0));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCVenus2Items.schematic, 1, 1));

        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenus2Items.venus2ItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenus2Items.venus2ItemBasic, 1, 5), new ItemStack(GCVenus2Items.venus2ItemBasic, 1, 2));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCVenus2PacketHandlerServer(), GCVenus2.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(GCVenus2TileEntityTreasureChest.class, "Tier 3 Treasure Chest");
    }

    public void registerCreatures()
    {
    }

    public void registerOtherEntities()
    {
        this.registerGalacticraftNonMobEntity(GCVenus2EntityRocketT3.class, "SpaceshipT3", GCVenus2ConfigManager.idEntitySpaceshipTier3, 150, 1, true);
        this.registerGalacticraftNonMobEntity(GCVenus2EntityRocketT3.class, "SpaceshipT3", GCVenus2ConfigManager.idEntitySpaceshipTier3, 150, 1, true);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCVenus2.proxy.postInit(event);
        GCVenus2.proxy.registerRenderInformation();
        GCVenus2RecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCVenus2.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
