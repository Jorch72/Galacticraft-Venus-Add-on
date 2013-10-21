package spacecraft.mods.galacticraft.venusBlocks.block;

import java.util.Random;

import spacecraft.mods.galacticraft.venusBlocks.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusStone extends Block
{
    public VenusStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GalacticraftVenus.VenusCobblestone.blockID;
    }
}
