package spacecraft.mods.galacticraft.venus.block;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;

public class VenusGrass extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock
{
	public VenusGrass(int id, Material material)
    {
    	super( id, material);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }
    public int damageDropped(int par1)
    {
        return this.blockID == GalacticraftVenus.VenusDirt.blockID ? 4 : 0;//Drops VenusDirt When Bricked
	}
	
    @Override
    public boolean isValueable(int metadata)//Let The Sensor Glasses View The Blocks(VenusGrass)
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

    @Override
    public boolean isTerraformable(World world, int x, int y, int z)//Makes The Block TransFormable
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        if ((meta >= 5 && meta <= 13))
        {
            return world.getBlockId(x, y + 1, z) == 0;
        }
        
        return false;
    }
}
