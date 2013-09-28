package spacecraft.mods.galacticraft.venus;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import spacecraft.mods.galacticraft.venus.GalacticraftVenus;

public class CGVenusSlotRenderer implements ICelestialBodyRenderer 
{

	@Override
	public ResourceLocation getPlanetSprite() 
	{
        return new ResourceLocation("GalacticraftVenus:textures/gui/planets/Venus.png");
	}

	@Override
	public String getPlanetName() 
	{
		return "Venus";
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
