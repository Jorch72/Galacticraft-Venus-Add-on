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
	    
	    public static final String NAME = "Galacticraft DevVenus";
	    public static final String MODID = "GalacticraftDevVenus";
	    public static final String CHANNEL = "GalacticraftDevVenus";
	    
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/devVenus/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/DevVenus/lang/";
	    public static final String CONFIG_FILE = "Spacecraft/DevVenus.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "devgalacticraftvenus";
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
		public final static Block tier3TreasureChest = new GCVenusBlockT3TreasureChest(734) .setHardness(2.5F) .setUnlocalizedName("treasureT3");
	
		
		//Item T3Spaceship
		public final static Item spaceshipT3 = new GCVenusItemSpaceshipTier3(735) .setUnlocalizedName("spaceshipT3");
		
		//Item Tier3 Schematic
		public final static Item tier3Schematic = new GCVenusItemSchematic(736) .setUnlocalizedName("tier3Schematic") .setTextureName("devgalacticraftvenus:schematic_rocketT3");

		//Item Tier3 Key
		public final static Item tier3Key = new GCVenusItemKey(737) .setUnlocalizedName("tier3Key") .setTextureName("devgalacticraftvenus:key_T3");	
		
		
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
                GameRegistry.registerBlock(tier3TreasureChest, "tier3TreasureChest");
                
				//Registering Block Names
                LanguageRegistry.addName(tier3TreasureChest, "Tier 3 Treasure Chest");
                
				//Registring Items Names
                LanguageRegistry.addName(spaceshipT3, "Tier 3 Rocket");
                LanguageRegistry.addName(tier3Schematic, "Tier 3 Rocket Schematic");
                LanguageRegistry.addName(tier3Key, "Tier 3 Key");  
                
				//Adding ItemStack for recipes
                
                //Register Crafting
                
                //Register Smelting
           
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	
        }
        
}


