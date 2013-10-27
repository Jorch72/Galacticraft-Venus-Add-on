package spacecraft.mods.galacticraft.venusBlocks;

import java.io.File;

import spacecraft.mods.galacticraft.venusBlocks.block.*;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="SpacecraftVenusBlocks", name="Spacecraft Venus Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class VenusBlocks 
  {
	    public static CreativeTabs GalacticraftVenusTab;
	    
	    public static final String CHANNEL = "GalacticraftVenus";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/venusBlocks/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/spacecraftvenus/lang/";
	    public static final String CONFIG_FILE = "spacecraft/VenusBlocks.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "spacecraftvenus";
	    public static String TEXTURE_PREFIX = VenusBlocks.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("SpacecraftVenus")
        public static VenusBlocks instance;
		
		//Block Venus Grass
    	public final static Block VenusGrass = new VenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("spacecraftvenus:grassVenus");

		//Block Venus Dirt
		public final static Block VenusDirt = new VenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("spacecraftvenus:dirtVenus");
        
		//Block Venus Stone
		public final static Block VenusStone = new VenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("spacecraftvenus:stoneVenus");

		//Block Venus Cobblestone
		public final static Block VenusCobblestone = new VenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("spacecraftvenus:cobblestoneVenus");

		//Block Venus Gem Block
		public final static Block VenusRedGemBlock = new VenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("spacecraftvenus:gemBlock");

		//Block Venus Meteor Block
		public final static Block VenusMeteorBlock = new VenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("spacecraftvenus:meteorBlock");

		//Block Venus Brick
		public final static Block VenusBrick = new VenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("spacecraftvenus:venusBrick");

		//Block Venus Sulfer
		public final static Block VenusSulferBlock = new VenusOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("spacecraftvenus:sulferBlock");

		//Block Venus Sulfer Ore
		public final static Block VenusSulferOre = new VenusOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("spacecraftvenus:sulferOre");

		//Block Venus Meteor Ore
		public final static Block VenusMeteorOre = new VenusOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("spacecraftvenus:meteorOre");

		//Block Venus Gem Ore
		public final static Block VenusRedGemOre = new VenusOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("spacecraftvenus:gemOre");

		//Block Venus Iron Ore
		public final static Block VenusIronOre = new VenusOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("spacecraftvenus:ironOre");

		//Block Venus Coal Ore
		public final static Block VenusCoalOre = new VenusOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("spacecraftvenus:coalOre");

		//Block Venus Iron Ore
		public final static Block VenusTinOre = new VenusOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("spacecraftvenus:tinOre");

		//Block Venus Coal Ore
		public final static Block VenusCopperOre = new VenusOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("spacecraftvenus:copperOre");				

		//Block Venus Basalt
		public final static Block VenusBasalt = new VenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("spacecraftvenus:venusBasalt");				

		//Block Venus Half Basalt
		public final static Block VenusHalfBasalt = new VenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("spacecraftvenus:venusBasalt");				

		//Block Evolved Blaze Egg
		public final static Block EvolvedBlazeEgg = new VenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("spacecraftvenus:evolvedBlazeEgg");				

        @SidedProxy(clientSide="spacecraft.mods.galacticraft.venusBlocks.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.venusBlocks.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new GCVenusBlocksConfigManager(new File(event.getModConfigurationDirectory(), VenusBlocks.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
                //Registering Blocks
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
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}