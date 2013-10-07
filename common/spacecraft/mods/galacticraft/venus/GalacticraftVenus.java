package spacecraft.mods.galacticraft.venus;

import java.io.File;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import spacecraft.mods.galacticraft.venus.blocks.VenusBlock;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
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
		public final static Block VenusGrass = new VenusBlock(610, Material.ground)
		.setHardness(0.4F).setStepSound(Block.soundGrassFootstep)
		.setUnlocalizedName("VenusGrass")
		.setTextureName("gcvenus:veunsGrass");
		
		//Venus Dirt
		public final static Block VenusDirt = new VenusBlock(611, Material.ground)
		.setHardness(0.3F).setStepSound(Block.soundDirtFootstep)
		.setUnlocalizedName("VenusDirt")
		.setTextureName("gcvenus:venusDirt");
        
		//Venus Stone
		public final static Block VenusStone = new VenusStone(612, Material.ground)
		.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
		.setUnlocalizedName("VenusStone")
		.setTextureName("gcvenus:Stone");
		
		//Venus Cobblestone
		public final static Block VenusCobblestone = new VenusStone(613, Material.ground)
		.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
		.setUnlocalizedName("VenusCobblestone")
		.setTextureName("gcvenus:Cobblestone");
		
		//Venus Gem Block
		public final static Block VenusGem = new VenusBlock(614, Material.ground)
		.setHardness(2.5F).setStepSound(Block.soundStoneFootstep)
		.setUnlocalizedName("VenusGem")
		.setTextureName("gcvenus:gemBlock");
		
		//Venus Meteor Block
		public final static Block VenusMeteor = new VenusBlock(615, Material.ground)
		.setHardness(3.5F).setStepSound(Block.soundStoneFootstep)
		.setUnlocalizedName("VenusMeteor")
		.setTextureName("gcvenus:meteorBlock");
		
		//Venus Brick
		public final static Block VenusBrick = new VenusBlock(616, Material.ground)
		.setHardness(5.0F).setStepSound(Block.soundStoneFootstep)
		.setUnlocalizedName("VenusBrick")
		.setTextureName("gcvenus:venusBrick");
		
		//Venus Sulfer
		public final static Block VenusSulfer = new VenusBlock(617, Material.ground)
		.setHardness(2.5F).setStepSound(Block.soundStoneFootstep)
		.setUnlocalizedName("VenusSulfer")
		.setTextureName("gcvenus:venusSulfer");
		
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
				GameRegistry.registerBlock(VenusGem, "VenusGem");
				GameRegistry.registerBlock(VenusMeteor, "VenusMeteor");
				GameRegistry.registerBlock(VenusBrick, "VenusBrick");
				GameRegistry.registerBlock(VenusSulfer, "VenusBSulfer");
                //Registering Names
                LanguageRegistry.addName(VenusGrass, "Venus Grass");
                LanguageRegistry.addName(VenusDirt, "Venus Dirt");
				LanguageRegistry.addName(VenusStone, "Venus Stone");
                LanguageRegistry.addName(VenusCobblestone, "Venus Cobblestone");
				LanguageRegistry.addName(VenusGem, "Venus Gem");
				LanguageRegistry.addName(VenusMeteor, "Venus Meteor");
                LanguageRegistry.addName(VenusBrick, "Venus Brick");
				LanguageRegistry.addName(VenusSulfer, "Venus Sulfer");

        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {

        }
}