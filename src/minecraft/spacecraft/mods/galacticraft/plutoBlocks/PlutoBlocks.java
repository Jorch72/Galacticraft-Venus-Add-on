package spacecraft.mods.galacticraft.plutoBlocks;

import java.io.File;

import spacecraft.mods.galacticraft.plutoBlocks.block.*;
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

@Mod(modid="SpacecraftPlutoBlocks", name="Spacecraft Pluto Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class PlutoBlocks 
  {
	    public static CreativeTabs GalacticraftPlutoTab;
	    
	    public static final String CHANNEL = "GalacticraftPluto";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/mercuryPluto/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/spacecraftpluto/lang/";
	    public static final String CONFIG_FILE = "spacecraft/PlutoBlocks.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "spacecraftpluto";
	    public static String TEXTURE_PREFIX = PlutoBlocks.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("SpacecraftPluto")
        public static PlutoBlocks instance;
		
		//Block Venus Grass
    	public final static Block PlutoGrass = new GCPlutoGrass(910, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("grassPluto") .setTextureName("spacecraftpluto:grassPluto");

		//Block Venus Dirt
		public final static Block PlutoDirt = new GCPlutoDirt(911, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("dirtPluto") .setTextureName("spacecraftpluto:dirtPluto");
        
		//Block Venus Stone
		public final static Block PlutoStone = new GCPlutoStone(912, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("stonePluto") .setTextureName("spacecraftpluto:stonePluto");

		//Block Venus Cobblestone
		public final static Block PlutoCobblestone = new GCPlutoBlock(913, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("cobblestonePluto") .setTextureName("spacecraftpluto:cobblestonePluto");

		//Block Venus Brick
		public final static Block PlutoBrick = new GCPlutoBlock(916, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("plutoBrick") .setTextureName("spacecraftpluto:plutoBrick");

        @SidedProxy(clientSide="spacecraft.mods.galacticraft.plutoBlocks.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.plutoBlocks.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new GCPlutoBlocksConfigManager(new File(event.getModConfigurationDirectory(), PlutoBlocks.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
                //Registering Blocks
                GameRegistry.registerBlock(PlutoGrass, "PlutoGrass");
                GameRegistry.registerBlock(PlutoDirt, "PlutoDirt");
				GameRegistry.registerBlock(PlutoStone, "PlutoStone");
				GameRegistry.registerBlock(PlutoCobblestone, "PlutoCobblestone");
				GameRegistry.registerBlock(PlutoBrick, "PlutoBrick");
				
				//Registering Block Names
//                LanguageRegistry.addName(PlutoGrass, "Pluto Grass");
//                LanguageRegistry.addName(PlutoDirt, "Pluto Dirt");
//				  LanguageRegistry.addName(PlutoStone, "Pluto Stone");
//                LanguageRegistry.addName(PlutoCobblestone, "Pluto Cobblestone");
//                LanguageRegistry.addName(PlutoBrick, "Pluto Brick");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}