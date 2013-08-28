package micdoodle8.mods.galacticraft.core.blocks;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCCoreBlockOre extends Block
{
    public GCCoreBlockOre(int id, String name)
    {
        super(id, Material.rock);
        this.setUnlocalizedName(name);
        this.func_111022_d(GalacticraftCore.TEXTURE_PREFIX + name);
        this.setHardness(2.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return GalacticraftCore.galacticraftTab;
    }
}
