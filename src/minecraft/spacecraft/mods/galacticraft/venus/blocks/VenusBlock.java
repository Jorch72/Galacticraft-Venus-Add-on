package spacecraft.mods.galacticraft.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import spacecraft.mods.galacticraft.venus.GalacticraftVenus;

public class VenusBlock extends Block {
	public VenusBlock (int id, Material material) 
    {
            super( id, material);
            this.setCreativeTab(GalacticraftVenus.tabVenus);
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
}
