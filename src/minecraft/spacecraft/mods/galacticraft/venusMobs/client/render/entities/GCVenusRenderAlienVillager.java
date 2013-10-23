package spacecraft.mods.galacticraft.venusMobs.client.render.entities;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import spacecraft.mods.galacticraft.venusMobs.client.model.GCVenusModelVillager;
import spacecraft.mods.galacticraft.venusMobs.entities.GCVenusEntityAlienVillager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCVenusRenderAlienVillager extends RenderLiving
{
    private static final ResourceLocation villagerTexture = new ResourceLocation(GalacticraftCore.TEXTURE_DOMAIN, "textures/model/villager.png");

    protected GCVenusModelVillager villagerModel;

    public GCVenusRenderAlienVillager()
    {
        super(new GCVenusModelVillager(0.0F), 0.5F);
        this.villagerModel = (GCVenusModelVillager) this.mainModel;
    }

    protected int shouldVillagerRenderPass(GCVenusEntityAlienVillager par1EntityVillager, int par2, float par3)
    {
        return -1;
    }

    public void renderVillager(GCVenusEntityAlienVillager par1EntityVillager, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityVillager, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110902_a(GCVenusEntityAlienVillager par1EntityVillager)
    {
        return GCVenusRenderAlienVillager.villagerTexture;
    }

    protected void renderVillagerEquipedItems(GCVenusEntityAlienVillager par1EntityVillager, float par2)
    {
        super.renderEquippedItems(par1EntityVillager, par2);
    }

    protected void preRenderVillager(GCVenusEntityAlienVillager par1EntityVillager, float par2)
    {
        float f1 = 0.9375F;

        if (par1EntityVillager.getGrowingAge() < 0)
        {
            f1 = (float) (f1 * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
    }

    @Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((GCVenusEntityAlienVillager) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderVillager((GCVenusEntityAlienVillager) par1EntityLivingBase, par2);
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldVillagerRenderPass((GCVenusEntityAlienVillager) par1EntityLivingBase, par2, par3);
    }

    @Override
    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderVillagerEquipedItems((GCVenusEntityAlienVillager) par1EntityLivingBase, par2);
    }

    @Override
    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((GCVenusEntityAlienVillager) par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110902_a((GCVenusEntityAlienVillager) par1Entity);
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((GCVenusEntityAlienVillager) par1Entity, par2, par4, par6, par8, par9);
    }
}
