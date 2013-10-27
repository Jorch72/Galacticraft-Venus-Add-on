package spacecraft.mods.galacticraft.jupiterBlocks.block;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.jupiterBlocks.JupiterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GCPlutoBlock extends Block
{
    public GCPlutoBlock(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftGasTab);
    }

}
