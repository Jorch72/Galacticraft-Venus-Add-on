package spacecraft.mods.galacticraft.venusBlocks;

import java.io.File;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import spacecraft.mods.galacticraft.venusBlocks.block.*;
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

@Mod(modid="GalacticraftVenus", name="Galacticraft Venus", version="0.1.2A-P", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class GalacticraftVenus 
  {
	    public static CreativeTabs GalacticraftVenusTab;
	    
	    public static final String CHANNEL = "GalacticraftVenus";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/venus/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/GalacticraftVenus/lang/";
	    public static final String CONFIG_FILE = "Spacecraft/Venus.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "GalacticraftVenus";
	    public static String TEXTURE_PREFIX = GalacticraftVenus.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("GalacticraftVenus")
        public static GalacticraftVenus instance;
		
		//Adding Creative Tab
		public static CreativeTabs tabVenus = new CreativeTabs("tabVenus") {
			public ItemStack getIconItemStack() {
				return new ItemStack(VenusDirt, 1, 0);
			}
		};
		
		//Block Venus Grass
    	public final static Block VenusGrass = new VenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("galacticraftvenus:grassVenus");

		//Block Venus Dirt
		public final static Block VenusDirt = new VenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("galacticraftvenus:dirtVenus");
        
		//Block Venus Stone
		public final static Block VenusStone = new VenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("galacticraftvenus:stoneVenus");

		//Block Venus Cobblestone
		public final static Block VenusCobblestone = new VenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("galacticraftvenus:cobblestoneVenus");

		//Block Venus Gem Block
		public final static Block VenusRedGemBlock = new VenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("galacticraftvenus:gemBlock");

		//Block Venus Meteor Block
		public final static Block VenusMeteorBlock = new VenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("galacticraftvenus:meteorBlock");

		//Block Venus Brick
		public final static Block VenusBrick = new VenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("galacticraftvenus:venusBrick");

		//Block Venus Sulfer
		public final static Block VenusSulferBlock = new VenusOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("galacticraftvenus:sulferBlock");

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
		public final static Block VenusBasalt = new VenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("galacticraftvenus:venusBasalt");				

		//Block Venus Half Basalt
		public final static Block VenusHalfBasalt = new VenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("galacticraftvenus:venusBasalt");				

		//Block Evolved Blaze Egg
		public final static Block EvolvedBlazeEgg = new VenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("galacticraftvenus:evolvedBlazeEgg");				

        @SidedProxy(clientSide="spacecraft.mods.galacticraft.venusBlocks.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.venusBlocks.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), GalacticraftVenus.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
 		        //Registering CreativeTab Name
                LanguageRegistry.instance().addStringLocalization("itemGroup.tabVenus", "en_US", "Galacticraft Venus");
                
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
				
				//Registering Block Names
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
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}



