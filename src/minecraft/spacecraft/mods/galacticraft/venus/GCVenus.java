package spacecraft.mods.galacticraft.venus;

import java.io.File;
import java.util.HashMap;

import spacecraft.mods.galacticraft.venus.blocks.GCVenusBlocks;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusTeleportType;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityAlienVillager;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityEvolvedBlaze;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityFlameling;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityRocketT3;
import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import spacecraft.mods.galacticraft.venus.network.GCVenusPacketHandlerServer;
import spacecraft.mods.galacticraft.venus.recipe.GCVenusRecipeManager;
import spacecraft.mods.galacticraft.venus.schematic.GCVenusSchematicRocketT3;
import spacecraft.mods.galacticraft.venus.blocks.*;
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

@Mod(name = GCVenus.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus
{
    public static final String NAME = "Galacticraft Venus";
    public static final String MODID = "GCVenus";
    public static final String CHANNEL = "GCVenus";
    public static final String CHANNELENTITIES = "GCVenusEntities";

    public static final String LANGUAGE_PATH = "/assets/galacticraftvenus/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.venus.client.ClientProxyVenus", serverSide = "spacecraft.mods.galacticraft.venus.CommonProxyVenus")
    public static CommonProxyVenus proxy;

    @Instance(GCVenus.MODID)
    public static GCVenus instance;

    public static CreativeTabs galacticraftVenusTab = new GCVenusCreativeTab(CreativeTabs.getNextID(),"galacticraftVenusTab");

    public static final String TEXTURE_DOMAIN = "galacticraftvenus";
    public static final String TEXTURE_PREFIX = GCVenus.TEXTURE_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    //Block Venus Grass
	public final static Block VenusGrass = new GCVenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("galacticraftvenus:grassVenus");

	//Block Venus Dirt
	public final static Block VenusDirt = new GCVenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("galacticraftvenus:dirtVenus");
    
	//Block Venus Stone
	public final static Block VenusStone = new GCVenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("galacticraftvenus:stoneVenus");

	//Block Venus Cobblestone
	public final static Block VenusCobblestone = new GCVenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("galacticraftvenus:cobblestoneVenus");

	//Block Venus Gem Block
	public final static Block VenusRedGemBlock = new GCVenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("galacticraftvenus:gemBlock");

	//Block Venus Meteor Block
	public final static Block VenusMeteorBlock = new GCVenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("galacticraftvenus:meteorBlock");

	//Block Venus Brick
	public final static Block VenusBrick = new GCVenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("galacticraftvenus:venusBrick");

	//Block Venus Sulfer
	public final static Block VenusSulferBlock = new GCVenusOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("galacticraftvenus:sulferBlock");

	//Block Venus Sulfer Ore
	public final static Block VenusSulferOre = new VenusOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("galacticraftvenus:sulferOre");

	//Block Venus Meteor Ore
	public final static Block VenusMeteorOre = new VenusOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("galacticraftvenus:meteorOre");

	//Block Venus Gem Ore
	public final static Block VenusRedGemOre = new VenusOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("galacticraftvenus:gemOre");

	//Block Venus Iron Ore
	public final static Block VenusIronOre = new VenusOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("galacticraftvenus:ironOre");

	//Block Venus Coal Ore
	public final static Block VenusCoalOre = new VenusOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("galacticraftvenus:coalOre");

	//Block Venus Iron Ore
	public final static Block VenusTinOre = new VenusOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("galacticraftvenus:tinOre");

	//Block Venus Coal Ore
	public final static Block VenusCopperOre = new VenusOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("galacticraftvenus:copperOre");				

	//Block Venus Basalt
	public final static Block VenusBasalt = new GCVenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("galacticraftvenus:venusBasalt");				

	//Block Venus Half Basalt
	public final static Block VenusHalfBasalt = new GCVenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("galacticraftvenus:venusBasalt");				

	//Block Evolved Blaze Egg
	public final static Block EvolvedBlazeEgg = new GCVenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("galacticraftvenus:evolvedBlazeEgg");				

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), "spacecraft/venus.conf"));

        GCVenusBlocks.initBlocks();
        GCVenusBlocks.setHarvestLevels();

        GCVenusItems.initItems();

        GCVenus.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        GameRegistry.registerBlock(VenusGrass, "VenusGrass");
        GameRegistry.registerBlock(VenusDirt, "VenusDirt");
		GameRegistry.registerBlock(VenusStone, "VenusStone");
		GameRegistry.registerBlock(VenusCobblestone, "VenusCobblestone");
		GameRegistry.registerBlock(VenusRedGemBlock, "VenusRedGemBlock");
		GameRegistry.registerBlock(VenusMeteorBlock, "VenusMeteorBlock");
		GameRegistry.registerBlock(VenusBrick, "VenusBrick");
		GameRegistry.registerBlock(VenusSulferBlock, "VenusSulferBlock");
		GameRegistry.registerBlock(VenusRedGemOre, "VenusRedGemOre");
		GameRegistry.registerBlock(VenusMeteorOre, "VenusMeteorOre");
		GameRegistry.registerBlock(VenusSulferOre, "VenusSulferOre");
		GameRegistry.registerBlock(VenusIronOre, "VenusIronOre");
		GameRegistry.registerBlock(VenusCoalOre, "VenusCoalOre");
		GameRegistry.registerBlock(VenusTinOre, "VenusTinOre");
		GameRegistry.registerBlock(VenusCopperOre, "VenusCopperOre");
		GameRegistry.registerBlock(VenusBasalt, "VenusBasalt");
		GameRegistry.registerBlock(VenusHalfBasalt, "VenusHalfBasalt");
		GameRegistry.registerBlock(EvolvedBlazeEgg, "EvolvedBlazeEgg");

        LanguageRegistry.addName(VenusGrass, "Venus Grass");
        LanguageRegistry.addName(VenusDirt, "Venus Dirt");
		LanguageRegistry.addName(VenusStone, "Venus Stone");
        LanguageRegistry.addName(VenusCobblestone, "Venus Cobblestone");
		LanguageRegistry.addName(VenusRedGemBlock, "Red Gem Block");
		LanguageRegistry.addName(VenusMeteorBlock, "Meteor Block");
        LanguageRegistry.addName(VenusBrick, "Venus Brick");
		LanguageRegistry.addName(VenusSulferBlock, "Sulfer Block");
		LanguageRegistry.addName(VenusRedGemOre, "Red Gem Ore");
		LanguageRegistry.addName(VenusMeteorOre, "Meteor Ore");
		LanguageRegistry.addName(VenusSulferOre, "Sulfer Ore");
		LanguageRegistry.addName(VenusIronOre, "Iron Ore");
		LanguageRegistry.addName(VenusCoalOre, "Coal Ore");	
		LanguageRegistry.addName(VenusTinOre, "Tin Ore");
		LanguageRegistry.addName(VenusCopperOre, "Copper Ore");
		LanguageRegistry.addName(VenusBasalt, "Basalt");
		LanguageRegistry.addName(VenusHalfBasalt, "Basalt Slab");
		LanguageRegistry.addName(EvolvedBlazeEgg, "Evolved Blaze Egg");
        
        int languages = 0;

        for (String language : GCVenus.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCVenus.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCVenus.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Galacticraft Venus Loaded: " + languages + " Languages.");

        SchematicRegistry.registerSchematicRecipe(new GCVenusSchematicRocketT3());

        NetworkRegistry.instance().registerGuiHandler(GCVenus.instance, GCVenus.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCVenus.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCVenusWorldProvider.class, new GCVenusTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVenusPlanet());
        GalacticraftRegistry.registerRocketGui(GCVenusWorldProvider.class, new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/gui/venusRocketGui.png"));
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(GCVenusItems.schematic, 1, 0));
        
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusRedGemOre, 5, 24, 0, 75, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusMeteorOre, 6, 22, 0, 60, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusSulferOre, 7, 18, 0, 45, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusDirt, 5, 24, 0, 75, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusIronOre, 6, 22, 0, 60, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusCoalOre, 7, 18, 0, 45, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusTinOre, 8, 3, 0, 25, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(GCVenus.VenusCopperOre, 8, 3, 0, 25, 7));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCVenusPacketHandlerServer(), GCVenus.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    }

    public void registerCreatures()
    {
    	GCCoreUtil.registerGalacticraftCreature(GCVenusEntityAlienVillager.class, "AlienVillager", GCVenusConfigManager.idEntityAlienVillager, GCCoreUtil.convertTo32BitColor(255, 103, 181, 145), 12422002);
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityEvolvedBlaze.class, "EvolvedBlaze", GCVenusConfigManager.idEntityEvolvedBlaze, 44975, 7969893);
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityFlameling.class, "Flameling", GCVenusConfigManager.idEntityFlameling, 44975, 7969893);
    }

    public void registerOtherEntities()
    {
        this.registerGalacticraftNonMobEntity(GCVenusEntityRocketT3.class, "SpaceshipT3", GCVenusConfigManager.idEntitySpaceshipTier3, 150, 1, true);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCVenus.proxy.postInit(event);
        GCVenus.proxy.registerRenderInformation();
        GCVenusRecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCVenus.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
