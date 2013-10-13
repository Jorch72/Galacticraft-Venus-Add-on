package spacecraft.mods.galacticraft.venus.block;

import java.util.Random;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusCobblestone extends Block
{
    public VenusCobblestone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }

}
