package spacecraft.mods.galacticraft.venus.blocks;

import java.util.Random;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusStone extends Block
{
    public VenusStone(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GalacticraftVenus.VenusCobblestone.blockID;
    }
}
