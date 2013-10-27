package spacecraft.mods.galacticraft.plutoBlocks.block;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.plutoBlocks.PlutoBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GCPlutoCobblestone extends Block
{
    public GCPlutoCobblestone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftPlutoTab);
    }

}
