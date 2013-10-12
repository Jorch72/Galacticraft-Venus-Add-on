package spacecraft.mods.galacticraft.venus.block;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class VenusGrass extends Block
{
	public VenusGrass(int id, Material material)
    {
    	super( id, material);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
    }
    public int damageDropped(int par1)
    {
        return this.blockID == GalacticraftVenus.VenusDirt.blockID ? 4 : 0;
	}
}