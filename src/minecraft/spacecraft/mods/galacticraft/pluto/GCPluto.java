package spacecraft.mods.galacticraft.pluto;

import java.io.File;
import java.util.HashMap;

import spacecraft.mods.galacticraft.pluto.blocks.*;
import spacecraft.mods.galacticraft.pluto.dimension.GCPlutoTeleportType;
import spacecraft.mods.galacticraft.pluto.dimension.GCPlutoWorldProvider;
import spacecraft.mods.galacticraft.pluto.items.GCPlutoItems;
import spacecraft.mods.galacticraft.pluto.network.GCPlutoPacketHandlerServer;
import spacecraft.mods.galacticraft.pluto.recipe.GCPlutoRecipeManager;
import spacecraft.mods.galacticraft.plutoBlocks.PlutoBlocks;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreOverworldGenerator;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

@Mod(name = GCPluto.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCPluto.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCPluto.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCPluto
{
    public static final String NAME = "Spacecraft Pluto";
    public static final String MODID = "GCPluto";
    public static final String CHANNEL = "GCPluto";
    public static final String CHANNELENTITIES = "GCPlutoEntities";

    public static final String LANGUAGE_PATH = "/assets/spacecraftpluto/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.pluto.client.ClientProxyPluto", serverSide = "spacecraft.mods.galacticraft.pluto.CommonProxyPluto")
    public static CommonProxyPluto proxy;

    @Instance(GCPluto.MODID)
    public static GCPluto instance;

    public static final String TEXTURE_DOMAIN = "spacecraftpluto";
    public static final String TEXTURE_PREFIX = GCPluto.TEXTURE_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCPlutoConfigManager(new File(event.getModConfigurationDirectory(), "spacecraft/pluto.conf"));

//        GCVenusBlocks.initBlocks();
//        GCVenusBlocks.setHarvestLevels();

        GCPlutoItems.initItems();

        GCPluto.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCPluto.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCPluto.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCPluto.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Spacecraft Mercury Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCPluto.instance, GCPluto.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCPluto.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCPlutoWorldProvider.class, new GCPlutoTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCPlutoPlanet());
        GalacticraftRegistry.registerRocketGui(GCPlutoWorldProvider.class, new ResourceLocation(GCPluto.TEXTURE_DOMAIN, "textures/gui/mercuryRocketGui.png"));

//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryRedGemOre, 5, 24, 0, 75, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(MercuryBlocks.MercuryDirt, 5, 24, 0, 75, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryCoalOre, 7, 18, 0, 45, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryTinOre, 8, 3, 0, 25, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryCopperOre, 8, 3, 0, 25, 7));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCPlutoPacketHandlerServer(), GCPluto.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    }

    public void registerCreatures()
    {
    }

    public void registerOtherEntities()
    {
    }
    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCPluto.proxy.postInit(event);
        GCPluto.proxy.registerRenderInformation();
        GCPlutoRecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCPluto.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
