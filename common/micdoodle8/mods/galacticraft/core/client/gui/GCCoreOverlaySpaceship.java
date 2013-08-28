package micdoodle8.mods.galacticraft.core.client.gui;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.render.entities.GCCoreRenderSpaceship;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityRocketT1;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCCoreOverlaySpaceship extends GCCoreOverlay
{
    private final static ResourceLocation guiTexture = new ResourceLocation(GalacticraftCore.TEXTURE_DOMAIN, "textures/gui/spaceshipgui.png");

    private static Minecraft minecraft = FMLClientHandler.instance().getClient();

    /**
     * Render the GUI when player is in inventory
     */
    public static void renderSpaceshipOverlay()
    {
        final ScaledResolution scaledresolution = new ScaledResolution(GCCoreOverlaySpaceship.minecraft.gameSettings, GCCoreOverlaySpaceship.minecraft.displayWidth, GCCoreOverlaySpaceship.minecraft.displayHeight);
        scaledresolution.getScaledWidth();
        final int height = scaledresolution.getScaledHeight();
        GCCoreOverlaySpaceship.minecraft.entityRenderer.setupOverlayRendering();
        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        FMLClientHandler.instance().getClient().renderEngine.func_110577_a(GCCoreOverlaySpaceship.guiTexture);

        float var1 = 0F;
        float var2 = height / 2 - 170 / 2;
        float var3 = GCCoreOverlaySpaceship.minecraft.thePlayer.worldObj.provider.dimensionId == 0 ? 0 : 13.5F;
        float var3b = 0;
        float var4 = 0;
        float var5 = 13.5F;
        float var6 = 170;
        float var7 = 0.00390625F * 1.5F;
        float var8 = 0.00390625F * 1.5F;

        final Tessellator var9 = Tessellator.instance;
        var9.startDrawingQuads();
        var9.addVertexWithUV(var1 + 0, var2 + var6, 0.0, (var3 + 0) * var7, (var4 + var6) * var8);
        var9.addVertexWithUV(var1 + var5, var2 + var6, 0.0, (var3 + var5) * var7, (var4 + var6) * var8);
        var9.addVertexWithUV(var1 + var5, var2 + 0, 0.0, (var3 + var5) * var7, (var4 + 0) * var8);
        var9.addVertexWithUV(var1 + 0, var2 + 0, 0.0, (var3 + 0) * var7, (var4 + 0) * var8);
        var9.draw();

        GL11.glColor3f(1.0F, 1.0F, 1.0F);

        final GCCoreRenderSpaceship spaceship = (GCCoreRenderSpaceship) RenderManager.instance.entityRenderMap.get(GCCoreEntityRocketT1.class);

        final int y1 = height / 2 + 60 - (int) Math.floor(GCCoreOverlay.getPlayerPositionY(GCCoreOverlaySpaceship.minecraft.thePlayer) / 10.5F);
        var1 = 2.5F;
        var2 = y1;
        var3 = 8;
        var3b = 40;
        var4 = 8;
        var5 = 8;
        var6 = 8;
        var7 = 1.0F / 64.0F;
        var8 = 1.0F / 32.0F;

        GL11.glPushMatrix();
        final int i = GCCoreOverlaySpaceship.minecraft.thePlayer.ridingEntity.getBrightnessForRender(1);
        final int j = i % 65536;
        final int k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glTranslatef(var1 + 4, var2 + 6, 50F);
        GL11.glScalef(5F, 5F, 5F);
        GL11.glRotatef(180F, 1, 0, 0);
        GL11.glRotatef(90F, 0, 1, 0);
        spaceship.renderSpaceship(new GCCoreEntityRocketT1(GCCoreOverlaySpaceship.minecraft.theWorld), 0, 0, 0, 0, 0);
        GL11.glPopMatrix();

        ResourceLocation resourcelocation = AbstractClientPlayer.field_110314_b;
        resourcelocation = AbstractClientPlayer.func_110305_h(GCCoreOverlaySpaceship.minecraft.thePlayer.username);
        AbstractClientPlayer.func_110304_a(resourcelocation, GCCoreOverlaySpaceship.minecraft.thePlayer.username);

        FMLClientHandler.instance().getClient().renderEngine.func_110577_a(resourcelocation);

        GL11.glTranslatef(0F, 0F, 60F);

        var9.startDrawingQuads();
        var9.addVertexWithUV(var1 + 0, var2 + var6, 0.0, (var3 + 0) * var7, (var4 + var6) * var8);
        var9.addVertexWithUV(var1 + var5, var2 + var6, 0.0, (var3 + var5) * var7, (var4 + var6) * var8);
        var9.addVertexWithUV(var1 + var5, var2 + 0, 0.0, (var3 + var5) * var7, (var4 + 0) * var8);
        var9.addVertexWithUV(var1 + 0, var2 + 0, 0.0, (var3 + 0) * var7, (var4 + 0) * var8);
        var9.draw();

        var9.startDrawingQuads();
        var9.addVertexWithUV(var1 + 0, var2 + var6, 0.0, (var3b + 0) * var7, (var4 + var6) * var8);
        var9.addVertexWithUV(var1 + var5, var2 + var6, 0.0, (var3b + var5) * var7, (var4 + var6) * var8);
        var9.addVertexWithUV(var1 + var5, var2 + 0, 0.0, (var3b + var5) * var7, (var4 + 0) * var8);
        var9.addVertexWithUV(var1 + 0, var2 + 0, 0.0, (var3b + 0) * var7, (var4 + 0) * var8);
        var9.draw();

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
