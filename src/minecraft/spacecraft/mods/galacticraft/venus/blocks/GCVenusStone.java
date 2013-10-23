package spacecraft.mods.galacticraft.venus.blocks;

import java.util.Random;

import spacecraft.mods.galacticraft.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GCVenusStone extends Block
{
    public GCVenusStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(GCVenus.galacticraftVenusTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GCVenus.VenusCobblestone.blockID;
    }
}
