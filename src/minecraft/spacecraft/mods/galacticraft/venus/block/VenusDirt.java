package spacecraft.mods.galacticraft.venus.block;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;

public class VenusDirt extends Block implements IPlantableBlock
{
	public VenusDirt(int id, Material material)
    {
    	super( id, material);
		this.setCreativeTab(GalacticraftVenus.tabVenus);
	}
	@Override
    	public int requiredLiquidBlocksNearby()
    	{
        	return 5; //Set How LiquidBlocks Is Needed Nearby To Plant in.
    	}
    
    	@Override
    	public boolean isPlantable(int metadata)
    	{
        	if (metadata >= 5 && metadata <= 13)
        	{
            	return true;
        	}

        return false;
    	}

}
