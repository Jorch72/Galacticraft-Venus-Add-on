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

        @Override
        public boolean isTerraformable(World world, int x, int y, int z)
        {
            return world.getBlockMetadata(x, y, z) == 5 && world.getBlockId(x, y + 1, z) == 0;
        }

	public boolean isSealed(World world, int x, int y, int z) {
		return true;
	}
        @Override
        public boolean isValueable(int metadata)
        {
           switch (metadata)
           {
           case 0:
               return true;
           case 1:
               return true;
           case 2:
               return true;
           default:
               return false;
           }
        }

	public int idDropped(int par1, Random random, int zero) {
        return GalacticraftVenus.VenusDirt.blockID;
        }
}
