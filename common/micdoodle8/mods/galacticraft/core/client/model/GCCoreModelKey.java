package micdoodle8.mods.galacticraft.core.client.model;

import net.minecraft.client.model.ModelBase;
import com.overminddl1.mods.NMT.NMTModelRenderer;

public class GCCoreModelKey extends ModelBase
{
    public NMTModelRenderer keyParts[] = new NMTModelRenderer[5];

    public GCCoreModelKey()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.keyParts[4] = new NMTModelRenderer(this, 50, 43);
        this.keyParts[4].addBox(7F, 2F, -0.5F, 3, 1, 1);
        this.keyParts[4].setRotationPoint(0F, 0F, 0F);
        this.keyParts[4].setTextureSize(64, 64);
        this.keyParts[4].mirror = true;
        this.keyParts[3] = new NMTModelRenderer(this, 39, 43);
        this.keyParts[3].addBox(6F, 1F, -0.5F, 4, 1, 1);
        this.keyParts[3].setRotationPoint(0F, 0F, 0F);
        this.keyParts[3].setTextureSize(64, 64);
        this.keyParts[3].mirror = true;
        this.keyParts[2] = new NMTModelRenderer(this, 14, 43);
        this.keyParts[2].addBox(-0.5F, 0F, -0.5F, 11, 1, 1);
        this.keyParts[2].setRotationPoint(0F, 0F, 0F);
        this.keyParts[2].setTextureSize(64, 64);
        this.keyParts[2].mirror = true;
        this.keyParts[1] = new NMTModelRenderer(this, 9, 43);
        this.keyParts[1].addBox(-1.5F, -0.5F, -0.5F, 1, 2, 1);
        this.keyParts[1].setRotationPoint(0F, 0F, 0F);
        this.keyParts[1].setTextureSize(64, 64);
        this.keyParts[1].mirror = true;
        this.keyParts[0] = new NMTModelRenderer(this, 0, 43);
        this.keyParts[0].addBox(-4.5F, -1F, -0.5F, 3, 3, 1);
        this.keyParts[0].setRotationPoint(0F, 0F, 0F);
        this.keyParts[0].setTextureSize(64, 64);
        this.keyParts[0].mirror = true;
    }

    public void renderAll()
    {
        for (final NMTModelRenderer nmtmr : this.keyParts)
        {
            nmtmr.rotationPointX = -4.0F;
            nmtmr.rotationPointY = 0.0F;
            nmtmr.rotationPointZ = -2.0F;
            nmtmr.render(0.0625F);
        }
    }
}
