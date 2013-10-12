package spacecraft.mods.galacticraft.venus;

import java.io.File;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spacecraft.mods.galacticraft.venus.block.*;
import spacecraft.mods.galacticraft.venus.items.*;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import spacecraft.mods.galacticraft.venus.wgen.*;
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

@Mod(modid="galacticraftVenus", name="Galacticraft Venus", version="0.1.2A-P", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class GalacticraftVenus 
  {
	    public static final IPlanet VenusPlanet = new VenusPlanet();
	    
	    public static CreativeTabs GalacticraftVenusTab;
	    
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/venus/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/spacecraft/lang/";
	    public static final String CONFIG_FILE = "Spacecraft/Venus.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "galacticraftVenus";
	    public static String TEXTURE_PREFIX = GalacticraftVenus.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("galacticraftVenus")
        public static GalacticraftVenus instance;
		
		//Adding Creative Tab
		public static CreativeTabs tabVenus = new CreativeTabs("tabVenus") {
			public ItemStack getIconItemStack() {
				return new ItemStack(VenusDirt, 1, 0);
			}
		};
		
		//Block Venus Grass
    	public final static Block VenusGrass = new VenusDirt(610, Material.ground) .setHardness(0.4F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("spacecraft:venusGrass_top");
		
		//Block Venus Dirt
		public final static Block VenusDirt = new VenusDirt(611, Material.ground) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("spacecraft:venusDirt");
        
		//Block Venus Stone
		public final static Block VenusStone = new VenusStone(612, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("spacecraft:venusStone");
		
		//Block Venus Cobblestone
		public final static Block VenusCobblestone = new VenusCobblestone(613, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("spacecraft:venusCobblestone");
		
		//Block Venus Gem Block
		public final static Block VenusRedGemBlock = new VenusBlock(614, Material.ground) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("spacecraft:gemBlock");
		
		//Block Venus Meteor Block
		public final static Block VenusMeteorBlock = new VenusBlock(615, Material.ground) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("spacecraft:meteorBlock");
		
		//Block Venus Brick
		public final static Block VenusBrick = new VenusBlock(616, Material.ground) .setHardness(5.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("spacecraft:venusBrick");
		
		//Block Venus Sulfer
		public final static Block VenusSulferBlock = new VenusBlock(617, Material.ground) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("spacecraft:sulferBlock");
		
		//Block Venus Sulfer Ore
		public final static Block VenusSulferOre = new VenusBlock(618, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("spacecraft:venusSulfurOre");

		//Block Venus Meteor Ore
		public final static Block VenusMeteorOre = new VenusBlock(619, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("spacecraft:venusMeteorOre");

		//Block Venus Gem Ore
		public final static Block VenusRedGemOre = new VenusBlock(620, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("spacecraft:venusGemOre");
		
		//Block Venus Iron Ore
		public final static Block VenusIronOre = new VenusBlock(621, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("spacecraft:venusIronOre");
		
		//Block Venus Coal Ore
		public final static Block VenusCoalOre = new VenusBlock(622, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("spacecraft:venusCoalOre");
		
		//Block Venus Iron Ore
		public final static Block VenusTinOre = new VenusBlock(623, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("spacecraft:venusTinOre");
				
		//Block Venus Coal Ore
		public final static Block VenusCopperOre = new VenusBlock(624, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("spacecraft:venusCopperOre");				
		
		//Block Venus Basalt
		public final static Block VenusBasalt = new VenusBlock(625, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("spacecraft:venusBasalt");				
		
		//Block Venus Half Basalt
		public final static Block VenusHalfBasalt = new VenusBlock(626, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("spacecraft:venusBasalt");				
		
		
		//Item Sufer Dust
		public final static Item SulferDust = new VenusItem(627) .setUnlocalizedName("SulferDust") .setTextureName("spacecraft:sulferDust");
		
		//Item Sufer Ingot
		public final static Item SulferIngot = new VenusItem(628) .setUnlocalizedName("SulferIngot") .setTextureName("spacecraft:sulferIngot");
		
		//Item Red Gem
		public final static Item RedGem = new VenusItem(629) .setUnlocalizedName("RedGem") .setTextureName("spacecraft:redGem");
		
		//Item Sufer Plate
		public final static Item SulferPlate = new VenusItem(630) .setUnlocalizedName("SulferPlate") .setTextureName("spacecraft:sulferPlate");
				
		//Item Red Gem Plate
		public final static Item RedGemPlate = new VenusItem(631) .setUnlocalizedName("RedGemPlate") .setTextureName("spacecraft:redGemPlate");
		
		//Where the client and server proxy is loaded.
        @SidedProxy(clientSide="spacecraft.mods.galacticraft.venus.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.venus.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
            GalacticraftRegistry.registerTeleportType(GCVenusWorldProvider.class, new GCVenusTeleportType());
    		GalacticraftRegistry.registerCelestialBody(new VenusPlanet());
    		new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), GalacticraftVenus.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
 		        //Registering CreativeTab Name
                LanguageRegistry.instance().addStringLocalization("itemGroup.tabVenus", "en_US", "Spacecraft Venus");
                
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
				LanguageRegistry.addName(VenusHalfBasalt, "Basalt Half Slab");
				
				//Registring Items Names
                LanguageRegistry.addName(SulferDust, "Sulfer Dust");
                LanguageRegistry.addName(SulferIngot, "Sulfer Ingot");
                LanguageRegistry.addName(RedGem, "Red Gem");
                LanguageRegistry.addName(SulferPlate, "Sulfer Plate");
                LanguageRegistry.addName(RedGemPlate, "Red Gem Plate");
                
				//Adding ItemStack for recipes
                ItemStack VenusCobblestone = new ItemStack(GalacticraftVenus.VenusCobblestone);
                ItemStack VenusStone = new ItemStack(GalacticraftVenus.VenusStone);                
                ItemStack SulferIngot = new ItemStack(GalacticraftVenus.SulferIngot);
                ItemStack SulferDust = new ItemStack(GalacticraftVenus.SulferDust);
                ItemStack VenusSulfer = new ItemStack(GalacticraftVenus.VenusSulferBlock);
                ItemStack VenusRedGem = new ItemStack(GalacticraftVenus.RedGem);
                ItemStack VenusRedGemBlock = new ItemStack(GalacticraftVenus.VenusRedGemBlock);
                ItemStack VenusCoalOre = new ItemStack(GalacticraftVenus.VenusCoalOre);
                ItemStack VenusTinOre = new ItemStack(GalacticraftVenus.VenusTinOre);
                ItemStack VenusCopperOre = new ItemStack(GalacticraftVenus.VenusCopperOre);
                
//                ItemStack ingotTin = new ItemStack(GCCoreItems.ingotTin);  
//                ItemStack ingotCopper = new ItemStack(GCCoreItems.ingotCopper);
                
                ItemStack meteoricIronRaw = new ItemStack(GCMoonItems.meteoricIronRaw);
                ItemStack furnace = new ItemStack(Block.furnaceIdle);
                ItemStack coal = new ItemStack(Item.coal);
                ItemStack ingotIron = new ItemStack(Item.ingotIron);
                
                //Register Crafting
                GameRegistry.addRecipe(SulferIngot, "xx ", "xx ", "   ", 'x', SulferDust);
                GameRegistry.addRecipe(VenusSulfer, "xxx", "xxx", "xxx", 'x', SulferIngot);
                GameRegistry.addRecipe(VenusRedGemBlock, "xxx", "xxx", "xxx", 'x', VenusRedGem);
                GameRegistry.addRecipe(furnace, "xxx", "x x", "xxx", 'x', VenusCobblestone);
                
                //Register Smelting
                GameRegistry.addSmelting(GalacticraftVenus.VenusCobblestone.blockID, VenusStone, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusSulferOre.blockID, SulferDust, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusMeteorOre.blockID, meteoricIronRaw, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusRedGemOre.blockID, VenusRedGem, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusCoalOre.blockID, coal, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusIronOre.blockID, ingotIron, 0.7f);
                
//                GameRegistry.addSmelting(GalacticraftVenus.VenusTinOre.blockID, ingotTin, 0.7f);
//                GameRegistry.addSmelting(GalacticraftVenus.VenusCopperOre.blockID, ingotCopper, 0.7f);
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {

        }
}
