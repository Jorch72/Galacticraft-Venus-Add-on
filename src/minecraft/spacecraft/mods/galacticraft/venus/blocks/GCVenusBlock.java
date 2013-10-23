package spacecraft.mods.galacticraft.venus.blocks;

import java.util.Random;

import spacecraft.mods.galacticraft.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GCVenusBlock extends Block
{
    public GCVenusBlock(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(GCVenus.galacticraftVenusTab);
    }

}
