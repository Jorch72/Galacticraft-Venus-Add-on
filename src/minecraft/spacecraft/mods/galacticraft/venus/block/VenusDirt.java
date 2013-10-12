package spacecraft.mods.galacticraft.venus.block;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusDirt extends Block
{
	public VenusDirt(int id, Material material)
    {
    	super( id, material);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }
}
