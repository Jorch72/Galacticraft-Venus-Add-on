package spacecraft.mods.galacticraft.devVenus;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spacecraft.mods.galacticraft.devVenus.blocks.*;
import spacecraft.mods.galacticraft.devVenus.items.*;
import spacecraft.mods.galacticraft.venus.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="GalacticraftDevVenus", name="GalacticraftDevVenus", version="a0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class GalacticraftDevVenus 
  {
	    public static CreativeTabs GalacticraftDevVenusTab;
	    
	    public static final String CHANNEL = "GalacticraftDevVenus";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/DevVenus/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/DevVenus/lang/";
	    public static final String CONFIG_FILE = "Spacecraft/DevVenus.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "DevGalacticraftvenus";
	    public static String TEXTURE_PREFIX = GalacticraftDevVenus.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("GalacticraftDevVenus")
        public static GalacticraftDevVenus instance;
		
		//Adding Creative Tab
		public static CreativeTabs tabGalacticraftDevVenus = new CreativeTabs("tabGalacticraftDevVenus") {
		public ItemStack getIconItemStack() {
		return new ItemStack(Item.netherStar, 1, 0);}
		};
		
		//Block Tier 3 Treasure Chest
//		public final static Block T3TreasureChest = new GCMarsBlockT2TreasureChest(734, Material.rock) .setHardness(1.5F).setStepSound(Block.soundClothFootstep) .setUnlocalizedName("copperWire") .setTextureName("devgalacticraftvenus:T3TreasureChest");

		
		//Item T3Spaceship
//		public final static Item spaceshipT3 = new VenusItemSpaceshipTier3(735) .setUnlocalizedName("spaceshipT3"); //.setTextureName("DevGalacticraftvenus:rocketT3");
		
		
		//Item Tier3 Schematic
//		public final static Item tier3Schematic = new GCVenusSchematicRocketT3(736) .setUnlocalizedName("tier3Schematic") .setTextureName("devgalacticraftvenus:tier3Schematic");

		
		//Where the client and server proxy is loaded.
        @SidedProxy(clientSide="spacecraft.mods.galacticraft.venus.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.venus.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new GCDevVenusConfigManager(new File(event.getModConfigurationDirectory(), GalacticraftDevVenus.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
 		        //Registering CreativeTab Name
                LanguageRegistry.instance().addStringLocalization("itemGroup.tabGalacticraftDevVenus", "en_US", "Galacticraft Dev-Venus");
                
                //Registering Blocks
//                GameRegistry.registerBlock(T3TreasureChest, "T3TreasureChest");
                
				//Registering Block Names
//                LanguageRegistry.addName(T3TreasureChest, "T3TreasureChest");
                
				//Registring Items Names
//              LanguageRegistry.addName(spaceshipT3, "Tier 3 Rocket");
//              LanguageRegistry.addName(tier3Schematic, "Tier 3 Rocket Schematic");
                
				//Adding ItemStack for recipes
                
                //Register Crafting
                
                //Register Smelting
           
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	
        }
        
}


