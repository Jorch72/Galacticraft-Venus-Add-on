package micdoodle8.mods.galacticraft.core.client.model;

import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityBuggy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GCCoreModelBuggy extends ModelBase
{
    public int type;

    public ModelRenderer wheel1e;
    public ModelRenderer body;
    public ModelRenderer wheel1a;
    public ModelRenderer wheel1d;
    public ModelRenderer wheel1c;
    public ModelRenderer wheel1b;
    public ModelRenderer wheel2d;
    public ModelRenderer wheel2a;
    public ModelRenderer wheel2c;
    public ModelRenderer wheel2b;
    public ModelRenderer wheel2e;
    public ModelRenderer wheel4d;
    public ModelRenderer wheel4a;
    public ModelRenderer wheel4e;
    public ModelRenderer wheel4b;
    public ModelRenderer wheel4c;
    public ModelRenderer wheel3c;
    public ModelRenderer wheel3d;
    public ModelRenderer wheel3a;
    public ModelRenderer wheel3e;
    public ModelRenderer wheel3b;
    public ModelRenderer frontFlap;
    public ModelRenderer back3;
    public ModelRenderer back1;
    public ModelRenderer back2;
    public ModelRenderer seatBack;
    public ModelRenderer seatBottom;
    public ModelRenderer seatArmRight1;
    public ModelRenderer seatArmLeft1;
    public ModelRenderer seatArmRight2;
    public ModelRenderer seatArmLeft2;
    public ModelRenderer backBottom;

    float turn = 0;

    public GCCoreModelBuggy()
    {
        this.textureWidth = 512;
        this.textureHeight = 256;

        this.wheel1e = new ModelRenderer(this, 328, 0);
        this.wheel1e.addBox(-3F, -5F, 5F, 3, 8, 1);
        this.wheel1e.setRotationPoint(-16F, 19F, -21F);
        this.wheel1e.setTextureSize(512, 256);
        this.wheel1e.mirror = true;
        this.setRotation(this.wheel1e, 0F, 0F, 0F);
        this.body = new ModelRenderer(this, 336, 0);
        this.body.addBox(-16F, -1.5F, -28F, 32, 3, 56);
        this.body.setRotationPoint(0F, 18F, 0F);
        this.body.setTextureSize(512, 256);
        this.body.mirror = true;
        this.setRotation(this.body, 0F, 0F, 0F);
        this.wheel1a = new ModelRenderer(this, 310, 9);
        this.wheel1a.addBox(-3F, -6F, -5F, 3, 10, 10);
        this.wheel1a.setRotationPoint(-16F, 19F, -21F);
        this.wheel1a.setTextureSize(512, 256);
        this.wheel1a.mirror = true;
        this.setRotation(this.wheel1a, 0F, 0F, 0F);
        this.wheel1d = new ModelRenderer(this, 306, 0);
        this.wheel1d.addBox(-3F, 4F, -4F, 3, 1, 8);
        this.wheel1d.setRotationPoint(-16F, 19F, -21F);
        this.wheel1d.setTextureSize(512, 256);
        this.wheel1d.mirror = true;
        this.setRotation(this.wheel1d, 0F, 0F, 0F);
        this.wheel1c = new ModelRenderer(this, 328, 0);
        this.wheel1c.addBox(-3F, -5F, -6F, 3, 8, 1);
        this.wheel1c.setRotationPoint(-16F, 19F, -21F);
        this.wheel1c.setTextureSize(512, 256);
        this.wheel1c.mirror = true;
        this.setRotation(this.wheel1c, 0F, 0F, 0F);
        this.wheel1b = new ModelRenderer(this, 306, 0);
        this.wheel1b.addBox(-3F, -7F, -4F, 3, 1, 8);
        this.wheel1b.setRotationPoint(-16F, 19F, -21F);
        this.wheel1b.setTextureSize(512, 256);
        this.wheel1b.mirror = true;
        this.setRotation(this.wheel1b, 0F, 0F, 0F);
        this.wheel2d = new ModelRenderer(this, 306, 0);
        this.wheel2d.addBox(-3F, 4F, -4F, 3, 1, 8);
        this.wheel2d.setRotationPoint(-16F, 19F, 21F);
        this.wheel2d.setTextureSize(512, 256);
        this.wheel2d.mirror = true;
        this.setRotation(this.wheel2d, 0F, 0F, 0F);
        this.wheel2a = new ModelRenderer(this, 310, 9);
        this.wheel2a.addBox(-3F, -6F, -5F, 3, 10, 10);
        this.wheel2a.setRotationPoint(-16F, 19F, 21F);
        this.wheel2a.setTextureSize(512, 256);
        this.wheel2a.mirror = true;
        this.setRotation(this.wheel2a, 0F, 0F, 0F);
        this.wheel2c = new ModelRenderer(this, 328, 0);
        this.wheel2c.addBox(-3F, -5F, -6F, 3, 8, 1);
        this.wheel2c.setRotationPoint(-16F, 19F, 21F);
        this.wheel2c.setTextureSize(512, 256);
        this.wheel2c.mirror = true;
        this.setRotation(this.wheel2c, 0F, 0F, 0F);
        this.wheel2b = new ModelRenderer(this, 306, 0);
        this.wheel2b.addBox(-3F, -7F, -4F, 3, 1, 8);
        this.wheel2b.setRotationPoint(-16F, 19F, 21F);
        this.wheel2b.setTextureSize(512, 256);
        this.wheel2b.mirror = true;
        this.setRotation(this.wheel2b, 0F, 0F, 0F);
        this.wheel2e = new ModelRenderer(this, 328, 0);
        this.wheel2e.addBox(-3F, -5F, 5F, 3, 8, 1);
        this.wheel2e.setRotationPoint(-16F, 19F, 21F);
        this.wheel2e.setTextureSize(512, 256);
        this.wheel2e.mirror = true;
        this.setRotation(this.wheel2e, 0F, 0F, 0F);
        this.wheel4d = new ModelRenderer(this, 306, 0);
        this.wheel4d.addBox(0F, 4F, -4F, 3, 1, 8);
        this.wheel4d.setRotationPoint(16F, 19F, -21F);
        this.wheel4d.setTextureSize(512, 256);
        this.wheel4d.mirror = true;
        this.setRotation(this.wheel4d, 0F, 0F, 0F);
        this.wheel4a = new ModelRenderer(this, 310, 9);
        this.wheel4a.addBox(0F, -6F, -5F, 3, 10, 10);
        this.wheel4a.setRotationPoint(16F, 19F, -21F);
        this.wheel4a.setTextureSize(512, 256);
        this.wheel4a.mirror = true;
        this.setRotation(this.wheel4a, 0F, 0F, 0F);
        this.wheel4e = new ModelRenderer(this, 328, 0);
        this.wheel4e.addBox(0F, -5F, -6F, 3, 8, 1);
        this.wheel4e.setRotationPoint(16F, 19F, -21F);
        this.wheel4e.setTextureSize(512, 256);
        this.wheel4e.mirror = true;
        this.setRotation(this.wheel4e, 0F, 0F, 0F);
        this.wheel4b = new ModelRenderer(this, 306, 0);
        this.wheel4b.addBox(0F, -7F, -4F, 3, 1, 8);
        this.wheel4b.setRotationPoint(16F, 19F, -21F);
        this.wheel4b.setTextureSize(512, 256);
        this.wheel4b.mirror = true;
        this.setRotation(this.wheel4b, 0F, 0F, 0F);
        this.wheel4c = new ModelRenderer(this, 328, 0);
        this.wheel4c.addBox(0F, -5F, 5F, 3, 8, 1);
        this.wheel4c.setRotationPoint(16F, 19F, -21F);
        this.wheel4c.setTextureSize(512, 256);
        this.wheel4c.mirror = true;
        this.setRotation(this.wheel4c, 0F, 0F, 0F);
        this.wheel3c = new ModelRenderer(this, 328, 0);
        this.wheel3c.addBox(0F, -5F, 5F, 3, 8, 1);
        this.wheel3c.setRotationPoint(16F, 19F, 21F);
        this.wheel3c.setTextureSize(512, 256);
        this.wheel3c.mirror = true;
        this.setRotation(this.wheel3c, 0F, 0F, 0F);
        this.wheel3d = new ModelRenderer(this, 306, 0);
        this.wheel3d.addBox(0F, 4F, -4F, 3, 1, 8);
        this.wheel3d.setRotationPoint(16F, 19F, 21F);
        this.wheel3d.setTextureSize(512, 256);
        this.wheel3d.mirror = true;
        this.setRotation(this.wheel3d, 0F, 0F, 0F);
        this.wheel3a = new ModelRenderer(this, 310, 9);
        this.wheel3a.addBox(0F, -6F, -5F, 3, 10, 10);
        this.wheel3a.setRotationPoint(16F, 19F, 21F);
        this.wheel3a.setTextureSize(512, 256);
        this.wheel3a.mirror = true;
        this.setRotation(this.wheel3a, 0F, 0F, 0F);
        this.wheel3e = new ModelRenderer(this, 328, 0);
        this.wheel3e.addBox(0F, -5F, -6F, 3, 8, 1);
        this.wheel3e.setRotationPoint(16F, 19F, 21F);
        this.wheel3e.setTextureSize(512, 256);
        this.wheel3e.mirror = true;
        this.setRotation(this.wheel3e, 0F, 0F, 0F);
        this.wheel3b = new ModelRenderer(this, 306, 0);
        this.wheel3b.addBox(0F, -7F, -4F, 3, 1, 8);
        this.wheel3b.setRotationPoint(16F, 19F, 21F);
        this.wheel3b.setTextureSize(512, 256);
        this.wheel3b.mirror = true;
        this.setRotation(this.wheel3b, 0F, 0F, 0F);
        this.frontFlap = new ModelRenderer(this, 94, 0);
        this.frontFlap.addBox(-5F, -0.5F, -3F, 10, 1, 6);
        this.frontFlap.setRotationPoint(0F, 16F, -26F);
        this.frontFlap.setTextureSize(512, 256);
        this.frontFlap.mirror = true;
        this.setRotation(this.frontFlap, 0F, 0F, 0F);
        this.back3 = new ModelRenderer(this, 240, 0);
        this.back3.addBox(-4F, -14F, -2.5F, 8, 14, 5);
        this.back3.setRotationPoint(-10F, 16.5F, 21F);
        this.back3.setTextureSize(512, 256);
        this.back3.mirror = true;
        this.setRotation(this.back3, 0F, 0F, 0F);
        this.back1 = new ModelRenderer(this, 240, 0);
        this.back1.addBox(-4F, -14F, -2.5F, 8, 14, 5);
        this.back1.setRotationPoint(10F, 16.5F, 21F);
        this.back1.setTextureSize(512, 256);
        this.back1.mirror = true;
        this.setRotation(this.back1, 0F, 0F, 0F);
        this.back2 = new ModelRenderer(this, 240, 0);
        this.back2.addBox(-4F, -14F, -2.5F, 8, 14, 5);
        this.back2.setRotationPoint(0F, 16.5F, 20F);
        this.back2.setTextureSize(512, 256);
        this.back2.mirror = true;
        this.setRotation(this.back2, 0F, 0F, 0F);
        this.seatBack = new ModelRenderer(this, 126, 0);
        this.seatBack.addBox(-7.5F, -12F, -1F, 15, 12, 2);
        this.seatBack.setRotationPoint(0F, 16.5F, 12F);
        this.seatBack.setTextureSize(512, 256);
        this.seatBack.mirror = true;
        this.setRotation(this.seatBack, -0.1858931F, 0F, 0F);
        this.seatBottom = new ModelRenderer(this, 126, 14);
        this.seatBottom.addBox(-8.5F, -6F, -1F, 17, 12, 2);
        this.seatBottom.setRotationPoint(0F, 16F, 6F);
        this.seatBottom.setTextureSize(512, 256);
        this.seatBottom.mirror = true;
        this.setRotation(this.seatBottom, 1.570796F, 0F, 0F);
        this.seatArmRight1 = new ModelRenderer(this, 152, 33);
        this.seatArmRight1.addBox(-0.5F, -7F, -0.5F, 1, 7, 1);
        this.seatArmRight1.setRotationPoint(-7.5F, 15F, 2F);
        this.seatArmRight1.setTextureSize(512, 256);
        this.seatArmRight1.mirror = true;
        this.setRotation(this.seatArmRight1, 0F, 0F, 0F);
        this.seatArmLeft1 = new ModelRenderer(this, 152, 33);
        this.seatArmLeft1.addBox(-0.5F, -7F, -0.5F, 1, 7, 1);
        this.seatArmLeft1.setRotationPoint(7.5F, 15F, 2F);
        this.seatArmLeft1.setTextureSize(512, 256);
        this.seatArmLeft1.mirror = true;
        this.setRotation(this.seatArmLeft1, 0F, 0F, 0F);
        this.seatArmRight2 = new ModelRenderer(this, 126, 28);
        this.seatArmRight2.addBox(-0.5F, -0.5F, 0F, 1, 1, 12);
        this.seatArmRight2.setRotationPoint(-7.5F, 8F, 1F);
        this.seatArmRight2.setTextureSize(512, 256);
        this.seatArmRight2.mirror = true;
        this.setRotation(this.seatArmRight2, 0F, 0.0523599F, 0F);
        this.seatArmLeft2 = new ModelRenderer(this, 126, 28);
        this.seatArmLeft2.addBox(-0.5F, -0.5F, 0F, 1, 1, 12);
        this.seatArmLeft2.setRotationPoint(7.5F, 8F, 1F);
        this.seatArmLeft2.setTextureSize(512, 256);
        this.seatArmLeft2.mirror = true;
        this.setRotation(this.seatArmLeft2, 0F, -0.0523599F, 0F);
        this.backBottom = new ModelRenderer(this, 160, 0);
        this.backBottom.addBox(-15F, -0.5F, -5F, 30, 1, 10);
        this.backBottom.setRotationPoint(0F, 16F, 20F);
        this.backBottom.setTextureSize(512, 256);
        this.backBottom.mirror = true;
        this.setRotation(this.backBottom, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        this.wheel1e.render(f5);
        this.body.render(f5);
        this.wheel1a.render(f5);
        this.wheel1d.render(f5);
        this.wheel1c.render(f5);
        this.wheel1b.render(f5);
        this.wheel2d.render(f5);
        this.wheel2a.render(f5);
        this.wheel2c.render(f5);
        this.wheel2b.render(f5);
        this.wheel2e.render(f5);
        this.wheel4d.render(f5);
        this.wheel4a.render(f5);
        this.wheel4e.render(f5);
        this.wheel4b.render(f5);
        this.wheel4c.render(f5);
        this.wheel3c.render(f5);
        this.wheel3d.render(f5);
        this.wheel3a.render(f5);
        this.wheel3e.render(f5);
        this.wheel3b.render(f5);
        this.frontFlap.render(f5);

        if (this.type >= 1)
        {
            this.back2.render(f5);

            if (this.type >= 2)
            {
                this.back3.render(f5);

                if (this.type >= 3)
                {
                    this.back1.render(f5);
                }
            }
        }
        this.seatBack.render(f5);
        this.seatBottom.render(f5);
        this.seatArmRight1.render(f5);
        this.seatArmLeft1.render(f5);
        this.seatArmRight2.render(f5);
        this.seatArmLeft2.render(f5);
        this.backBottom.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        if (entity instanceof GCCoreEntityBuggy && entity.riddenByEntity != null)
        {
            final GCCoreEntityBuggy buggy = (GCCoreEntityBuggy) entity;

            this.wheel1a.rotateAngleY = buggy.turnProgress;
            this.wheel2a.rotateAngleY = buggy.turnProgress;
            this.wheel3a.rotateAngleY = buggy.turnProgress;
            this.wheel4a.rotateAngleY = buggy.turnProgress;
            this.wheel1b.rotateAngleY = buggy.turnProgress;
            this.wheel2b.rotateAngleY = buggy.turnProgress;
            this.wheel3b.rotateAngleY = buggy.turnProgress;
            this.wheel4b.rotateAngleY = buggy.turnProgress;
            this.wheel1c.rotateAngleY = buggy.turnProgress;
            this.wheel2c.rotateAngleY = buggy.turnProgress;
            this.wheel3c.rotateAngleY = buggy.turnProgress;
            this.wheel4c.rotateAngleY = buggy.turnProgress;
            this.wheel1d.rotateAngleY = buggy.turnProgress;
            this.wheel2d.rotateAngleY = buggy.turnProgress;
            this.wheel3d.rotateAngleY = buggy.turnProgress;
            this.wheel4d.rotateAngleY = buggy.turnProgress;
            this.wheel1e.rotateAngleY = buggy.turnProgress;
            this.wheel2e.rotateAngleY = buggy.turnProgress;
            this.wheel3e.rotateAngleY = buggy.turnProgress;
            this.wheel4e.rotateAngleY = buggy.turnProgress;

            float speed = (float) (buggy.motionX * buggy.motionX + buggy.motionZ + buggy.motionZ);

            this.wheel1a.rotateAngleX += speed / 20F;
            this.wheel2a.rotateAngleX += speed / 20F;
            this.wheel3a.rotateAngleX += speed / 20F;
            this.wheel4a.rotateAngleX += speed / 20F;
            this.wheel1b.rotateAngleX += speed / 20F;
            this.wheel2b.rotateAngleX += speed / 20F;
            this.wheel3b.rotateAngleX += speed / 20F;
            this.wheel4b.rotateAngleX += speed / 20F;
            this.wheel1c.rotateAngleX += speed / 20F;
            this.wheel2c.rotateAngleX += speed / 20F;
            this.wheel3c.rotateAngleX += speed / 20F;
            this.wheel4c.rotateAngleX += speed / 20F;
            this.wheel1d.rotateAngleX += speed / 20F;
            this.wheel2d.rotateAngleX += speed / 20F;
            this.wheel3d.rotateAngleX += speed / 20F;
            this.wheel4d.rotateAngleX += speed / 20F;
            this.wheel1e.rotateAngleX += speed / 20F;
            this.wheel2e.rotateAngleX += speed / 20F;
            this.wheel3e.rotateAngleX += speed / 20F;
            this.wheel4e.rotateAngleX += speed / 20F;
        }
    }

    public void setType(int type)
    {
        this.type = type;
    }
}
