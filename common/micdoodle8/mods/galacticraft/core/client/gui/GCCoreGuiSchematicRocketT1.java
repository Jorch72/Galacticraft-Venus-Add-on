package micdoodle8.mods.galacticraft.core.client.gui;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicResultPage;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerRocketBench;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GCCoreGuiSchematicRocketT1 extends GCCoreGuiContainer implements ISchematicResultPage
{
    private static final ResourceLocation rocketBenchTexture = new ResourceLocation(GalacticraftCore.TEXTURE_DOMAIN, "textures/gui/rocketbench.png");

    private GuiButton backButton;
    private GuiButton nextButton;
    private int pageIndex;

    public GCCoreGuiSchematicRocketT1(InventoryPlayer par1InventoryPlayer, int x, int y, int z)
    {
        super(new GCCoreContainerRocketBench(par1InventoryPlayer, x, y, z));
        this.ySize = 221;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.add(this.backButton = new GuiButton(0, this.width / 2 - 130, this.height / 2 - 30 + 27, 40, 20, LanguageRegistry.instance().getStringLocalization("gui.button.back.name")));
        this.buttonList.add(this.nextButton = new GuiButton(1, this.width / 2 + 90, this.height / 2 - 30 + 27, 40, 20, LanguageRegistry.instance().getStringLocalization("gui.button.next.name")));
        this.backButton.enabled = false;
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
            case 0:
                SchematicRegistry.flipToLastPage(this.pageIndex);
                break;
            case 1:
                SchematicRegistry.flipToNextPage(this.pageIndex);
                break;
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(LanguageRegistry.instance().getStringLocalization("schematic.rocketT1.name"), 7, -20 + 27, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, 202 - 104 + 2 + 27, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.func_110577_a(GCCoreGuiSchematicRocketT1.rocketBenchTexture);
        final int var5 = (this.width - this.xSize) / 2;
        final int var6 = (this.height - 220) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, 220);
    }

    @Override
    public void setPageIndex(int index)
    {
        this.pageIndex = index;
    }
}
