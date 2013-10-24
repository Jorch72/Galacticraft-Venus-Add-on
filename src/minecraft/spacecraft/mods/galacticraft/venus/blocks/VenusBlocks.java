package spacecraft.mods.galacticraft.venus.blocks;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class VenusBlocks
{
	public static Block VenusGrass;
	public static Block VenusDirt;
	public static Block VenusStone;
	public static Block VenusCobblestone;
	public static Block VenusRedGemBlock;
	public static Block VenusMeteorBlock;
	public static Block VenusBrick;
	public static Block VenusSulferBlock;
	public static Block VenusRedGemOre;
	public static Block VenusMeteorOre;
	public static Block VenusSulferOre;
	public static Block VenusIronOre;
	public static Block VenusCoalOre;
	public static Block VenusTinOre;
	public static Block VenusCopperOre;
	public static Block VenusBasalt;
	public static Block VenusHalfBasalt;
	public static Block EvolvedBlazeEgg;

    public static void initBlocks()
    {
	//Block Venus Grass
	VenusBlocks.VenusGrass = new GCVenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass"); //.setTextureName("galacticraftvenus:grassVenus");

	//Block Venus Dirt
	VenusBlocks.VenusDirt = new GCVenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt"); //.setTextureName("galacticraftvenus:dirtVenus");

	//Block Venus Stone
	VenusBlocks.VenusStone = new GCVenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone"); //.setTextureName("galacticraftvenus:stoneVenus");

	//Block Venus Cobblestone
	VenusBlocks.VenusCobblestone = new GCVenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone"); //.setTextureName("galacticraftvenus:cobblestoneVenus");

	//Block Venus Gem Block
	VenusBlocks.VenusRedGemBlock = new GCVenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem"); //.setTextureName("galacticraftvenus:gemBlock");

	//Block Venus Meteor Block
	VenusBlocks.VenusMeteorBlock = new GCVenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor"); //.setTextureName("galacticraftvenus:meteorBlock");

	//Block Venus Brick
	VenusBlocks.VenusBrick = new GCVenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick"); //.setTextureName("galacticraftvenus:venusBrick");

	//Block Venus Sulfer
	VenusBlocks.VenusSulferBlock = new GCVenusBlockOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer"); //.setTextureName("galacticraftvenus:sulferBlock");

	//Block Venus Sulfer Ore
	VenusBlocks.VenusSulferOre = new GCVenusBlockOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre"); //.setTextureName("galacticraftvenus:sulferOre");

	//Block Venus Meteor Ore
	VenusBlocks.VenusMeteorOre = new GCVenusBlockOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre"); //.setTextureName("galacticraftvenus:meteorOre");

	//Block Venus Gem Ore
	VenusBlocks.VenusRedGemOre = new GCVenusBlockOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre"); //.setTextureName("galacticraftvenus:gemOre");

	//Block Venus Iron Ore
	VenusBlocks.VenusIronOre = new GCVenusBlockOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre"); //.setTextureName("galacticraftvenus:ironOre");

	//Block Venus Coal Ore
	VenusBlocks.VenusCoalOre = new GCVenusBlockOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre"); //.setTextureName("galacticraftvenus:coalOre");

	//Block Venus Iron Ore
	VenusBlocks.VenusTinOre = new GCVenusBlockOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre"); //.setTextureName("galacticraftvenus:tinOre");

	//Block Venus Coal Ore
	VenusBlocks.VenusCopperOre = new GCVenusBlockOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre"); //.setTextureName("galacticraftvenus:copperOre");				

	//Block Venus Basalt
	VenusBlocks.VenusBasalt = new GCVenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt"); //.setTextureName("galacticraftvenus:venusBasalt");				

	//Block Venus Half Basalt
	VenusBlocks.VenusHalfBasalt = new GCVenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt"); //.setTextureName("galacticraftvenus:venusBasalt");				

	//Block Evolved Blaze Egg
	VenusBlocks.EvolvedBlazeEgg = new GCVenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg"); //.setTextureName("galacticraftvenus:evolvedBlazeEgg");				
    }
	
//	public static void setHarvestLevels()
//    {
//        MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, 0, "pickaxe", 3);
//        MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, 1, "pickaxe", 3);
//        MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, 2, "pickaxe", 3);
//        MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, 3, "shovel", 0);
//        MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, 4, "pickaxe", 2);

//        for (int num = 5; num < 14; num++)
//        {
//            MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, num, "shovel", 0);
//        }
//        MinecraftForge.setBlockHarvestLevel(GCMoonBlocks.blockMoon, 14, "pickaxe", 2);
//    }

    public static void registerBlocks()
    {
//    	GameRegistry.registerBlock(GCMoonBlocks.blockMoon, GCMoonItemBlock.class, GCMoonBlocks.blockMoon.getUnlocalizedName(), GalacticraftCore.MODID);
    	
		GameRegistry.registerBlock(VenusBlocks.VenusGrass, "VenusGrass");
		GameRegistry.registerBlock(VenusBlocks.VenusDirt, "VenusDirt");
		GameRegistry.registerBlock(VenusBlocks.VenusStone, "VenusStone");
		GameRegistry.registerBlock(VenusBlocks.VenusCobblestone, "VenusCobblestone");
		GameRegistry.registerBlock(VenusBlocks.VenusRedGemBlock, "VenusRedGemBlock");
		GameRegistry.registerBlock(VenusBlocks.VenusMeteorBlock, "VenusMeteorBlock");
		GameRegistry.registerBlock(VenusBlocks.VenusBrick, "VenusBrick");
		GameRegistry.registerBlock(VenusBlocks.VenusSulferBlock, "VenusSulferBlock");
		GameRegistry.registerBlock(VenusBlocks.VenusRedGemOre, "VenusRedGemOre");
		GameRegistry.registerBlock(VenusBlocks.VenusMeteorOre, "VenusMeteorOre");
		GameRegistry.registerBlock(VenusBlocks.VenusSulferOre, "VenusSulferOre");
		GameRegistry.registerBlock(VenusBlocks.VenusIronOre, "VenusIronOre");
		GameRegistry.registerBlock(VenusBlocks.VenusCoalOre, "VenusCoalOre");
		GameRegistry.registerBlock(VenusBlocks.VenusTinOre, "VenusTinOre");
		GameRegistry.registerBlock(VenusBlocks.VenusCopperOre, "VenusCopperOre");
		GameRegistry.registerBlock(VenusBlocks.VenusBasalt, "VenusBasalt");
		GameRegistry.registerBlock(VenusBlocks.VenusHalfBasalt, "VenusHalfBasalt");
		GameRegistry.registerBlock(VenusBlocks.EvolvedBlazeEgg, "EvolvedBlazeEgg");

//		LanguageRegistry.addName(VenusGrass, "Venus Grass");
//		LanguageRegistry.addName(VenusDirt, "Venus Dirt");
//		LanguageRegistry.addName(VenusStone, "Venus Stone");
//		LanguageRegistry.addName(VenusCobblestone, "Venus Cobblestone");
//		LanguageRegistry.addName(VenusRedGemBlock, "Red Gem Block");
//		LanguageRegistry.addName(VenusMeteorBlock, "Meteor Block");
//		LanguageRegistry.addName(VenusBrick, "Venus Brick");
//		LanguageRegistry.addName(VenusSulferBlock, "Sulfer Block");
//		LanguageRegistry.addName(VenusRedGemOre, "Red Gem Ore");
//		LanguageRegistry.addName(VenusMeteorOre, "Meteor Ore");
//		LanguageRegistry.addName(VenusSulferOre, "Sulfer Ore");
//		LanguageRegistry.addName(VenusIronOre, "Iron Ore");
//		LanguageRegistry.addName(VenusCoalOre, "Coal Ore");	
//		LanguageRegistry.addName(VenusTinOre, "Tin Ore");
//		LanguageRegistry.addName(VenusCopperOre, "Copper Ore");
//		LanguageRegistry.addName(VenusBasalt, "Basalt");
//		LanguageRegistry.addName(VenusHalfBasalt, "Basalt Slab");
//		LanguageRegistry.addName(EvolvedBlazeEgg, "Evolved Blaze Egg");
	}
}