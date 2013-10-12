package spacecraft.mods.galacticraft.venus.block;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class VenusDirt extends Block
{
	public VenusDirt(int id, Material material)
    {
    	super( id, material);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }
	        public boolean isTerraformable(World world, int x, int y, int z)
	        {
	            return world.getBlockMetadata(x, y, z) == 5 && world.getBlockId(x, y + 1, z) == 0;
	        }
}
