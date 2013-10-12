package spacecraft.mods.galacticraft.venus.block;

import java.util.Random;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusStone extends Block
{
    public VenusStone(int id, Material material)
    {
    	super( id, material);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GalacticraftVenus.VenusCobblestone.blockID;
    }
}
