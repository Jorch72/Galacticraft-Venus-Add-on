package spacecraft.mods.galacticraft.venus;

import java.io.File;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spacecraft.mods.galacticraft.venus.blocks.VenusBlock;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import spacecraft.mods.galacticraft.venus.items.VenusItem;
import spacecraft.mods.galacticraft.venus.blocks.VenusStone;
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

@Mod(modid="gcvenus", name="Galacticraft Venus", version="0.1.1A-P", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class GalacticraftVenus 
  {
	    public static final IPlanet VenusPlanet = new VenusPlanet();
	    
	    public static CreativeTabs GalacticraftVenusTab;
	    
	    public static final String FILE_PATH = "/spacecraft/mods/galatcicraft/venus/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/gcvenus/lang/";
	    public static final String CONFIG_FILE = "Spacecraft/Venus.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "gcvenus";
	    public static String TEXTURE_PREFIX = GalacticraftVenus.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("gcvenus")
        public static GalacticraftVenus instance;
		
		//Adding Creative Tab
		public static CreativeTabs tabVenus = new CreativeTabs("tabVenus") {
			public ItemStack getIconItemStack() {
				return new ItemStack(VenusDirt, 1, 0);
			}
		};
		
		//Adds Blocks
		//Venus Grass
		public final static Block VenusGrass = new VenusBlock(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("spacecraft:venusGrass");
		
		//Venus Dirt
		public final static Block VenusDirt = new VenusBlock(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("spacecraft:venusDirt");
        
		//Venus Stone
		public final static Block VenusStone = new VenusBlock(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("spacecraft:venusStone");
		
		//Venus Cobblestone
		public final static Block VenusCobblestone = new VenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("spacecraft:venusCobblestone");
		
		//Venus Gem Block
		public final static Block VenusGemBlock = new VenusBlock(614, Material.ground) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("spacecraft:gemBlock");
		
		//Venus Meteor Block
		public final static Block VenusMeteorBlock = new VenusBlock(615, Material.ground) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("spacecraft:meteorBlock");
		
		//Venus Brick
		public final static Block VenusBrick = new VenusBlock(616, Material.ground) .setHardness(5.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("spacecraft:venusBrick");
		
		//Venus Sulfer
		public final static Block VenusSulferBlock = new VenusBlock(617, Material.ground) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("spacecraft:sulferBlock");
		
		//Block Venus Sulfer Ore
		public final static Block VenusSulferOre = new VenusBlock(618, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("spacecraft:venusSulfurOre");

		//Block Venus Meteor Ore
		public final static Block VenusMeteorOre = new VenusBlock(619, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("spacecraft:venusMeteorOre");

		//Block Venus Gem Ore
		public final static Block VenusGemOre = new VenusBlock(620, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("spacecraft:venusGemOre");
		
		//Block Venus Iron Ore
		public final static Block VenusIronOre = new VenusBlock(621, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("spacecraft:venusIronOre");
		
		//Block Venus Coal Ore
		public final static Block VenusCoalOre = new VenusBlock(622, Material.ground) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("spacecraft:venusCoalOre");
				
		
		//Items
		//Sufer Dust
		public final static Item VenusSulferDust = new VenusItem(623) .setUnlocalizedName("VenusSulferDust") .setTextureName("spacecraft:venusSulferDust");
		
		//Sufer Ingot
		public final static Item VenusSulferIngot = new VenusItem(624) .setUnlocalizedName("VenusSulferIngot") .setTextureName("spacecraft:venusSulferIngot");
		
		//Sufer Gem
		public final static Item VenusGem = new VenusItem(625) .setUnlocalizedName("VenusGem") .setTextureName("spacecraft:venusGem");
		
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
				GameRegistry.registerBlock(VenusGemBlock, "VenusGemBlock");
				GameRegistry.registerBlock(VenusMeteorBlock, "VenusMeteorBlock");
				GameRegistry.registerBlock(VenusBrick, "VenusBrick");
				GameRegistry.registerBlock(VenusSulferBlock, "VenusSulferBlock");
				GameRegistry.registerBlock(VenusGemOre, "VenusGemOre");
				GameRegistry.registerBlock(VenusMeteorOre, "VenusMeteorOre");
				GameRegistry.registerBlock(VenusSulferOre, "VenusSulferOre");
				GameRegistry.registerBlock(VenusIronOre, "VenusIronOre");
				GameRegistry.registerBlock(VenusCoalOre, "VenusCoalOre");
                
				//Registering Block Names
                LanguageRegistry.addName(VenusGrass, "Venus Grass");
                LanguageRegistry.addName(VenusDirt, "Venus Dirt");
				LanguageRegistry.addName(VenusStone, "Venus Stone");
                LanguageRegistry.addName(VenusCobblestone, "Venus Cobblestone");
				LanguageRegistry.addName(VenusGemBlock, "Gem Block");
				LanguageRegistry.addName(VenusMeteorBlock, "Meteor Block");
                LanguageRegistry.addName(VenusBrick, "Venus Brick");
				LanguageRegistry.addName(VenusSulferBlock, "Sulfer Block");
				LanguageRegistry.addName(VenusGemOre, "Gem Ore");
				LanguageRegistry.addName(VenusMeteorOre, "Meteor Ore");
				LanguageRegistry.addName(VenusSulferOre, "Sulfer Ore");
				LanguageRegistry.addName(VenusIronOre, "Iron Ore");
				LanguageRegistry.addName(VenusCoalOre, "Coal Ore");
                
				
				//Registring Items Names
                LanguageRegistry.addName(VenusSulferDust, "Sulfer Dust");
                LanguageRegistry.addName(VenusSulferIngot, "Sulfer Ingot");
                LanguageRegistry.addName(VenusGem, "Venus Gem");
                
				//Adding ItemStack for recipes
                ItemStack VenusCobblestone = new ItemStack(GalacticraftVenus.VenusCobblestone);
                ItemStack VenusStone = new ItemStack(GalacticraftVenus.VenusStone);                
                ItemStack VenusSulferIngot = new ItemStack(GalacticraftVenus.VenusSulferIngot);
                ItemStack VenusSulferDust = new ItemStack(GalacticraftVenus.VenusSulferDust);
                ItemStack VenusSulfer = new ItemStack(GalacticraftVenus.VenusSulferBlock);
                ItemStack VenusGem = new ItemStack(GalacticraftVenus.VenusGem);
                ItemStack VenusGemBlock = new ItemStack(GalacticraftVenus.VenusGemBlock);
                ItemStack meteoricIronRaw = new ItemStack(GCMoonItems.meteoricIronRaw);               
                ItemStack VenusCoalOre = new ItemStack(GalacticraftVenus.VenusCoalOre);
                
                ItemStack coal = new ItemStack(Item.coal);
                ItemStack ingotIron = new ItemStack(Item.ingotIron);
                
                //Register Crafting
                GameRegistry.addRecipe(VenusSulferIngot, "xx ", "xx ", "   ", 'x', VenusSulferDust);
                GameRegistry.addRecipe(VenusSulfer, "xxx", "xxx", "xxx", 'x', VenusSulferIngot);
                GameRegistry.addRecipe(VenusGemBlock, "xxx", "xxx", "xxx", 'x', VenusGem);
                
                //Register Smelting
                GameRegistry.addSmelting(GalacticraftVenus.VenusCobblestone.blockID, VenusStone, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusSulferOre.blockID, VenusSulferDust, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusMeteorOre.blockID, meteoricIronRaw, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusGemOre.blockID, VenusGem, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusCoalOre.blockID, coal, 0.7f);
                GameRegistry.addSmelting(GalacticraftVenus.VenusIronOre.blockID, ingotIron, 0.7f);
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {

        }
}
