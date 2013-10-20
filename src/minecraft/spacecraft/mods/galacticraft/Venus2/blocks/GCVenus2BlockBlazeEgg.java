package spacecraft.mods.galacticraft.venus2.blocks;

import spacecraft.mods.galacticraft.venus2.GCVenus2;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenus2BlockBlazeEgg extends BlockDragonEgg
{
    public GCVenus2BlockBlazeEgg(int par1)
    {
        super(par1);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return GCVenus2.galacticraftVenus2Tab;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return 27;
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        return false;
    }

    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return 1;
    }

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
    {
        if (!world.isRemote)
        {
            EntityBlaze blaze = new EntityBlaze(world);
            blaze.setPosition(x + 0.5, y + 1, z + 0.5);
            world.spawnEntityInWorld(blaze);
        }

        world.setBlockToAir(x, y, z);
        this.onBlockDestroyedByExplosion(world, x, y, z, explosion);
    }
}
