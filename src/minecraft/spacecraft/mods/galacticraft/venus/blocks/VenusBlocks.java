package spacecraft.mods.galacticraft.venus.blocks;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class VenusBlocks 
	{
	//Block Venus Grass
	public final static Block VenusGrass = new GCVenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("galacticraftvenus:grassVenus");

	//Block Venus Dirt
	public final static Block VenusDirt = new GCVenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("galacticraftvenus:dirtVenus");

	//Block Venus Stone
	public final static Block VenusStone = new GCVenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("galacticraftvenus:stoneVenus");

	//Block Venus Cobblestone
	public final static Block VenusCobblestone = new GCVenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("galacticraftvenus:cobblestoneVenus");

	//Block Venus Gem Block
	public final static Block VenusRedGemBlock = new GCVenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("galacticraftvenus:gemBlock");

	//Block Venus Meteor Block
	public final static Block VenusMeteorBlock = new GCVenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("galacticraftvenus:meteorBlock");

	//Block Venus Brick
	public final static Block VenusBrick = new GCVenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("galacticraftvenus:venusBrick");

	//Block Venus Sulfer
	public final static Block VenusSulferBlock = new GCVenusBlockOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("galacticraftvenus:sulferBlock");

	//Block Venus Sulfer Ore
	public final static Block VenusSulferOre = new GCVenusBlockOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("galacticraftvenus:sulferOre");

	//Block Venus Meteor Ore
	public final static Block VenusMeteorOre = new GCVenusBlockOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("galacticraftvenus:meteorOre");

	//Block Venus Gem Ore
	public final static Block VenusRedGemOre = new GCVenusBlockOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("galacticraftvenus:gemOre");

	//Block Venus Iron Ore
	public final static Block VenusIronOre = new GCVenusBlockOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("galacticraftvenus:ironOre");

	//Block Venus Coal Ore
	public final static Block VenusCoalOre = new GCVenusBlockOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("galacticraftvenus:coalOre");

	//Block Venus Iron Ore
	public final static Block VenusTinOre = new GCVenusBlockOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("galacticraftvenus:tinOre");

	//Block Venus Coal Ore
	public final static Block VenusCopperOre = new GCVenusBlockOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("galacticraftvenus:copperOre");				

	//Block Venus Basalt
	public final static Block VenusBasalt = new GCVenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("galacticraftvenus:venusBasalt");				

	//Block Venus Half Basalt
	public final static Block VenusHalfBasalt = new GCVenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("galacticraftvenus:venusBasalt");				

	//Block Evolved Blaze Egg
	public final static Block EvolvedBlazeEgg = new GCVenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("galacticraftvenus:evolvedBlazeEgg");				

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
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
		GameRegistry.registerBlock(EvolvedBlazeEgg, "EvolvedBlazeEgg");

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
		LanguageRegistry.addName(VenusHalfBasalt, "Basalt Slab");
		LanguageRegistry.addName(EvolvedBlazeEgg, "Evolved Blaze Egg");
	}
}