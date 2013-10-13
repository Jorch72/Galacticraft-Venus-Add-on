package spacecraft.mods.galacticraft.DevVenus;

import java.io.File;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import micdoodle8.mods.galacticraft.mars.GalacticraftMars;
import micdoodle8.mods.galacticraft.mars.entities.GCMarsEntityCreeperBoss;
import micdoodle8.mods.galacticraft.mars.entities.GCMarsEntitySlimeling;
import micdoodle8.mods.galacticraft.mars.entities.GCMarsEntitySludgeling;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItems;
import micdoodle8.mods.galacticraft.mars.recipe.GCMarsRecipeManager;
import micdoodle8.mods.galacticraft.mars.tile.GCMarsTileEntityCryogenicChamber;
import micdoodle8.mods.galacticraft.mars.tile.GCMarsTileEntityDungeonSpawner;
import micdoodle8.mods.galacticraft.mars.tile.GCMarsTileEntityLaunchController;
import micdoodle8.mods.galacticraft.mars.tile.GCMarsTileEntitySlimelingEgg;
import micdoodle8.mods.galacticraft.mars.tile.GCMarsTileEntityTerraformer;
import micdoodle8.mods.galacticraft.mars.tile.GCMarsTileEntityTreasureChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spacecraft.mods.galacticraft.DevVenus.items.*;
import spacecraft.mods.galacticraft.DevVenus.blocks.*;
import spacecraft.mods.galacticraft.venus.CommonProxy;
import spacecraft.mods.galacticraft.venus.block.VenusBlazeEgg;
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
		
		//Block Gem Wire
		public final static Block copperWire = new GCCoreBlockCopperWire(728, Material.cloth) .setHardness(1.5F).setStepSound(Block.soundClothFootstep) .setUnlocalizedName("copperWire") .setTextureName("devgalacticraftvenus:copperWire");

		
		//Item T3Spaceship
		public final static Item spaceshipT3 = new VenusItemSpaceshipTier3(729) .setUnlocalizedName("spaceshipT3"); //.setTextureName("DevGalacticraftvenus:rocketT3");
		
		
		//Item Tier3 Schematic
		public final static Item tier3Schematic = new VenusItemSchematic(731) .setUnlocalizedName("tier3Schematic") .setTextureName("devgalacticraftvenus:tier3Schematic");

		
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
				
				//Registering Block Names
				
				//Registring Items Names
                LanguageRegistry.addName(spaceshipT3, "Tier 3 Rocket");
                LanguageRegistry.addName(tier3Schematic, "Tier 3 Rocket Schematic");
                
				//Adding ItemStack for recipes
                
                //Register Crafting
                
                //Register Smelting
           
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	
        }
        
}


