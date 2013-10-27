package spacecraft.mods.galacticraft.plutoBlocks.block;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.plutoBlocks.PlutoBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GCPlutoStone extends Block
{
    public GCPlutoStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftPlutoTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return PlutoBlocks.PlutoCobblestone.blockID;
    }
}
