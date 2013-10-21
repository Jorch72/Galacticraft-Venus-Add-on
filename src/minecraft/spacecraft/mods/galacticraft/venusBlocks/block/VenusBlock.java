package spacecraft.mods.galacticraft.venusBlocks.block;

import java.util.Random;

import spacecraft.mods.galacticraft.venusBlocks.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusBlock extends Block
{
    public VenusBlock(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }

}
