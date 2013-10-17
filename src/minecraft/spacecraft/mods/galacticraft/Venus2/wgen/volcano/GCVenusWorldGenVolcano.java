package spacecraft.mods.galacticraft.Venus2.wgen.volcano;

import java.util.Random;
import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GCVenusWorldGenVolcano extends WorldGenerator
{
	private int idToGenerate = GalacticraftVenus.VenusBasalt.blockID;
	private int metaToGenerate = 0;

	protected int[] GetValidSpawnBlocks() 
	{
		return new int[] 
		{
			idToGenerate
		};
	}
	
	protected int[] getValidSpawnMeta() 
	{
		return new int[] 
		{
			0
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
	return true;
	}

	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) 
	{
		
		generate7(world, rand, i, j, k);
		return true;
	}

	public boolean generate7(World world, Random rand, int i, int j, int k) {
		
		generate42(world, rand, i, j, k);
		return true;
	}

	public boolean generate42(World world, Random rand, int i, int j, int k) {
		
		generate43(world, rand, i, j, k);
		return true;
	}

	public boolean generate43(World world, Random rand, int i, int j, int k) {
		
		generate44(world, rand, i, j, k);
		return true;
	}

	public boolean generate44(World world, Random rand, int i, int j, int k) {
		
		generate45(world, rand, i, j, k);
		return true;
	}

	public boolean generate45(World world, Random rand, int i, int j, int k) {
		
		generate46(world, rand, i, j, k);
		return true;
	}

	public boolean generate46(World world, Random rand, int i, int j, int k) {
		
		generate47(world, rand, i, j, k);
		return true;
	}

	public boolean generate47(World world, Random rand, int i, int j, int k) {
		
		generate48(world, rand, i, j, k);
		return true;
	}

	public boolean generate48(World world, Random rand, int i, int j, int k) {
		
		generate49(world, rand, i, j, k);
		return true;
	}

	public boolean generate49(World world, Random rand, int i, int j, int k) {
		
		generate50(world, rand, i, j, k);
		return true;
	}

	public boolean generate50(World world, Random rand, int i, int j, int k) {
		
		generate51(world, rand, i, j, k);
		return true;
	}

	public boolean generate51(World world, Random rand, int i, int j, int k) {
		
		generate52(world, rand, i, j, k);
		return true;
	}

	public boolean generate52(World world, Random rand, int i, int j, int k) {
		
		generate53(world, rand, i, j, k);
		return true;
	}

	public boolean generate53(World world, Random rand, int i, int j, int k) {

		generate54(world, rand, i, j, k);
		return true;
	}

	public boolean generate54(World world, Random rand, int i, int j, int k) {

		generate55(world, rand, i, j, k);
		return true;
	}

	public boolean generate55(World world, Random rand, int i, int j, int k) {

		generate56(world, rand, i, j, k);
		return true;
	}

	public boolean generate56(World world, Random rand, int i, int j, int k) {

		generate57(world, rand, i, j, k);
		return true;
	}

	public boolean generate57(World world, Random rand, int i, int j, int k) {

		generate58(world, rand, i, j, k);
		return true;
	}

	public boolean generate58(World world, Random rand, int i, int j, int k) {

		generate59(world, rand, i, j, k);
		return true;
	}

	public boolean generate59(World world, Random rand, int i, int j, int k) {

		generate60(world, rand, i, j, k);
		return true;
	}

	public boolean generate60(World world, Random rand, int i, int j, int k) {

		generate61(world, rand, i, j, k);
		return true;
	}

	public boolean generate61(World world, Random rand, int i, int j, int k) {

		generate62(world, rand, i, j, k);
		return true;
	}

	public boolean generate62(World world, Random rand, int i, int j, int k) {

		generate63(world, rand, i, j, k);
		return true;
	}

	public boolean generate63(World world, Random rand, int i, int j, int k) {

		generate64(world, rand, i, j, k);
		return true;
	}

	public boolean generate64(World world, Random rand, int i, int j, int k) {

		generate65(world, rand, i, j, k);
		return true;
	}

	public boolean generate65(World world, Random rand, int i, int j, int k) {

		generate66(world, rand, i, j, k);
		return true;
	}

	public boolean generate66(World world, Random rand, int i, int j, int k) {

		generate67(world, rand, i, j, k);
		return true;
	}

	public boolean generate67(World world, Random rand, int i, int j, int k) {

		generate68(world, rand, i, j, k);
		return true;
	}

	public boolean generate68(World world, Random rand, int i, int j, int k) {

		generate69(world, rand, i, j, k);
		return true;
	}

	public boolean generate69(World world, Random rand, int i, int j, int k) {

		generate70(world, rand, i, j, k);
		return true;
	}

	public boolean generate70(World world, Random rand, int i, int j, int k) {

		generate71(world, rand, i, j, k);
		return true;
	}

	public boolean generate71(World world, Random rand, int i, int j, int k) {

		generate72(world, rand, i, j, k);
		return true;
	}

	public boolean generate72(World world, Random rand, int i, int j, int k) {

		return true;
	}
}
