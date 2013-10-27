package spacecraft.mods.galacticraft.mercuryBlocks;

import java.io.File;

import spacecraft.mods.galacticraft.mercuryBlocks.block.*;
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

@Mod(modid="SpacecraftMercuryBlocks", name="Spacecraft Mercury Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class MercuryBlocks 
  {
	    public static CreativeTabs GalacticraftMercuryTab;
	    
	    public static final String CHANNEL = "SpacecraftMercury";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/mercuryBlocks/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/spacecraftmercury/lang/";
	    public static final String CONFIG_FILE = "spacecraft/MercuryBlocks.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "spacecraftmercury";
	    public static String TEXTURE_PREFIX = MercuryBlocks.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("SpacecraftMercury")
        public static MercuryBlocks instance;
		
		//Block Venus Grass
    	public final static Block MercuryGrass = new VenusGrass(710, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("MercuryGrass") .setTextureName("spacecraftmercury:grassMercury");

		//Block Venus Dirt
		public final static Block MercuryDirt = new VenusDirt(711, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("MercuryDirt") .setTextureName("spacecraftmercury:dirtMercury");
        
		//Block Venus Stone
		public final static Block MercuryStone = new VenusStone(712, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryStone") .setTextureName("spacecraftmercury:stoneMercury");

		//Block Venus Cobblestone
		public final static Block MercuryCobblestone = new VenusBlock(713, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCobblestone") .setTextureName("spacecraftmercury:cobblestoneMercury");

		//Block Venus Brick
		public final static Block MercuryBrick = new VenusBlock(716, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryBrick") .setTextureName("spacecraftmercury:mercuryBrick");

		//Block Venus Gem Ore
		public final static Block MercuryRedGemOre = new VenusOre(720, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryGemOre") .setTextureName("spacecraftmercury:gemOreMercury");

		//Block Venus Coal Ore
		public final static Block MercuryCoalOre = new VenusOre(722, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCoalOre") .setTextureName("spacecraftmercury:coalOreMercury");

		//Block Venus Iron Ore
		public final static Block MercuryTinOre = new VenusOre(723, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryTinOre") .setTextureName("spacecraftmercury:tinOreMercury");

		//Block Venus Coal Ore
		public final static Block MercuryCopperOre = new VenusOre(724, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCopperOre") .setTextureName("spacecraftmercury:copperOreMercury");				

        @SidedProxy(clientSide="spacecraft.mods.galacticraft.mercuryBlocks.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.mercuryBlocks.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new GCMercuryBlocksConfigManager(new File(event.getModConfigurationDirectory(), MercuryBlocks.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
                //Registering Blocks
                GameRegistry.registerBlock(MercuryGrass, "MercuryGrass");
                GameRegistry.registerBlock(MercuryDirt, "MercuryDirt");
				GameRegistry.registerBlock(MercuryStone, "MercuryStone");
				GameRegistry.registerBlock(MercuryCobblestone, "MercuryCobblestone");
				GameRegistry.registerBlock(MercuryBrick, "MercuryBrick");
				GameRegistry.registerBlock(MercuryRedGemOre, "MercuryRedGemOre");
				GameRegistry.registerBlock(MercuryCoalOre, "MercuryCoalOre");
				GameRegistry.registerBlock(MercuryTinOre, "MercuryTinOre");
				GameRegistry.registerBlock(MercuryCopperOre, "MercuryCopperOre");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}