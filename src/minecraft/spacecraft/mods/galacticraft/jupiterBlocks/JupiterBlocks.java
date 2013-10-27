package spacecraft.mods.galacticraft.jupiterBlocks;

import java.io.File;

import spacecraft.mods.galacticraft.jupiterBlocks.block.*;
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

@Mod(modid="SpacecraftJupiterBlocks", name="Spacecraft Jupiter Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class JupiterBlocks 
  {
	    public static CreativeTabs GalacticraftPlutoTab;
	    
	    public static final String CHANNEL = "GalacticraftJupiter";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/jupiterBlocks/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/spacecraftpluto/lang/";
	    public static final String CONFIG_FILE = "spacecraft/jupiterBlocks.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "spacecraftjupiter";
	    public static String TEXTURE_PREFIX = JupiterBlocks.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("SpacecraftJupiter")
        public static JupiterBlocks instance;
		
		//Block Venus Grass
    	public final static Block JupiterLightGas = new GCPlutoDirt(650, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("lightGas") .setTextureName("spacecraftjupiter:lightGasJupiter");

		//Block Venus Dirt
		public final static Block JupiterMediumGas = new GCPlutoDirt(651, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("mediumGas") .setTextureName("spacecraftjupiter:mediumGasJupiter");
        
		//Block Venus Stone
		public final static Block JupiterHeavyGas = new GCPlutoStone(652, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("heavyGas") .setTextureName("spacecraftjupiter:heavyGasJupiter");

        @SidedProxy(clientSide="spacecraft.mods.galacticraft.jupiterBlocks.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.jupiterBlocks.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new GCJupiterBlocksConfigManager(new File(event.getModConfigurationDirectory(), JupiterBlocks.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
                //Registering Blocks
                GameRegistry.registerBlock(JupiterLightGas, "JupiterHeavyGas");
                GameRegistry.registerBlock(JupiterMediumGas, "JupiterMediumGas");
				GameRegistry.registerBlock(JupiterHeavyGas, "JupiterHeavyGas");
				
				//Registering Block Names
//                LanguageRegistry.addName(PlutoGrass, "Pluto Grass");
//                LanguageRegistry.addName(PlutoDirt, "Pluto Dirt");
//				  LanguageRegistry.addName(PlutoStone, "Pluto Stone");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}