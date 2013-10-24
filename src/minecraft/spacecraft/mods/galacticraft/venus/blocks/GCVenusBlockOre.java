package spacecraft.mods.galacticraft.venus.blocks;

import spacecraft.mods.galacticraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusBlockOre extends Block implements IDetectableResource
{
    public GCVenusBlockOre(int id, Material material)
    {
     	super( id, material.rock);
//        this.setUnlocalizedName(name);
//        this.setTextureName(GCVenus.TEXTURE_PREFIX + name);
        this.setHardness(2.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return GCVenus.galacticraftVenusTab;
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
            return true;
        }
    }
}