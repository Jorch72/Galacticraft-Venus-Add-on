package spacecraft.mods.galacticraft.venus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VenusGrassBlock extends Block{
	
	public VenusGrassBlock (int id, Material material) 
    {
            super( id, material);
            this.setCreativeTab(GalacticraftVenus.tabVenus);
    }

	public boolean isTerraformable(World world, int x, int y, int z) {
		return true;
	}
	public boolean isSealed(World world, int x, int y, int z) {
		return true;
	}
	public boolean isValueable(int metadata) {
		return true;
	}
	public int idDropped(int par1, Random random, int zero) {
        return GalacticraftVenus.VenusDirt.blockID;
	}
}
