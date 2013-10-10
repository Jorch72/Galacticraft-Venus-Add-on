package spacecraft.mods.galacticraft.venus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VenusGrassBlock extends Block
{

	public VenusGrassBlock(int par1)
    {
		super(par1, Material.grass);
	    this.setCreativeTab(GalacticraftVenus.tabVenus);
	}

	public boolean isTerraformable(World world, int x, int y, int z) {
		return true;
	}

	public boolean isSealed(World world, int x, int y, int z) {
		return false;
	}

	public boolean isValueable(int metadata) {
		return true;
	}
	        
}