package spacecraft.mods.galacticraft.Venus2.schematic;

import spacecraft.mods.galacticraft.Venus2.GCVenus2ConfigManager;
import spacecraft.mods.galacticraft.Venus2.client.gui.GCVenus2GuiSchematicRocketT3;
import spacecraft.mods.galacticraft.Venus2.inventory.GCVenus2ContainerRocketBenchT3;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenus2SchematicRocketT3 implements ISchematicPage
{
    @Override
    public int getPageID()
    {
        return GCVenus2ConfigManager.idSchematicRocketT3;
    }

    @Override
    public int getGuiID()
    {
        return GCVenus2ConfigManager.idGuiRocketCraftingBenchT3;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new GCVenus2GuiSchematicRocketT3(player.inventory, x, y, z);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new GCVenus2ContainerRocketBenchT3(player.inventory, x, y, z);
    }

    @Override
    public int compareTo(ISchematicPage o)
    {
        if (this.getPageID() > o.getPageID())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
