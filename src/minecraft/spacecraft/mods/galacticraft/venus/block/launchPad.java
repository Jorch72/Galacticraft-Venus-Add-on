package spacecraft.mods.galacticraft.venus.block;

import java.util.List;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlockAdvanced;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityBuggyFuelerSingle;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityCargoPadSingle;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityLandingPadSingle;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class launchPad extends GCCoreBlockAdvanced
{
    private Icon[] icons = new Icon[3];

    public launchPad(int id, Material material)
    {
    	super( id, material);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundStoneFootstep);
//        this.setTextureName(GalacticraftCore.TEXTURE_PREFIX + assetName);
//        this.setUnlocalizedName(assetName);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return GalacticraftVenus.tabVenus;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < 2; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.icons[0] = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "launch_pad");
        this.icons[1] = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "buggy_fueler_blank");
        this.icons[2] = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "cargo_pad");
        this.blockIcon = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "launch_pad");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > this.icons.length)
        {
            return this.blockIcon;
        }

        return this.icons[par2];
    }

    @Override
    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        final int id = GalacticraftVenus.Tier2LandingPad.blockID;

        if (par1World.getBlockId(par2 + 1, par3, par4) == id && par1World.getBlockId(par2 + 2, par3, par4) == id && par1World.getBlockId(par2 + 3, par3, par4) == id)
        {
            return false;
        }

        if (par1World.getBlockId(par2 - 1, par3, par4) == id && par1World.getBlockId(par2 - 2, par3, par4) == id && par1World.getBlockId(par2 - 3, par3, par4) == id)
        {
            return false;
        }

        if (par1World.getBlockId(par2, par3, par4 + 1) == id && par1World.getBlockId(par2, par3, par4 + 2) == id && par1World.getBlockId(par2, par3, par4 + 3) == id)
        {
            return false;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == id && par1World.getBlockId(par2, par3, par4 - 2) == id && par1World.getBlockId(par2, par3, par4 - 3) == id)
        {
            return false;
        }

        if (par1World.getBlockId(par2, par3 - 1, par4) == GalacticraftVenus.Tier2LandingPad.blockID && par5 == 1)
        {
            return false;
        }
        else
        {
            return this.canPlaceBlockAt(par1World, par2, par3, par4);
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        switch (metadata)
        {
        case 0:
            return new GCCoreTileEntityLandingPadSingle();
        case 1:
            return new GCCoreTileEntityBuggyFuelerSingle();
        case 2:
            return new GCCoreTileEntityCargoPadSingle();
        default:
            return null;
        }
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return null;
    }
}
