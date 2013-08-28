package micdoodle8.mods.galacticraft.moon.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GCMoonSlotRenderer implements ICelestialBodyRenderer
{
    @Override
    public ResourceLocation getPlanetSprite()
    {
        return new ResourceLocation(GalacticraftCore.TEXTURE_DOMAIN, "textures/gui/planets/moon.png");
    }

    @Override
    public String getPlanetName()
    {
        return "Moon";
    }

    @Override
    public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
    {
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x - slotHeight / 2 * 1.25, y + slotHeight / 2 * 1.25, -90.0D, 0.35D, 0.65D);
        tessellator.addVertexWithUV(x + slotHeight / 2 * 1.25, y + slotHeight / 2 * 1.25, -90.0D, 0.65D, 0.65D);
        tessellator.addVertexWithUV(x + slotHeight / 2 * 1.25, y - slotHeight / 2 * 1.25, -90.0D, 0.65D, 0.35D);
        tessellator.addVertexWithUV(x - slotHeight / 2 * 1.25, y - slotHeight / 2 * 1.25, -90.0D, 0.35D, 0.35D);
        tessellator.draw();
    }
}
