package spacecraft.mods.galacticraft.venus.schematic;

import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import spacecraft.mods.galacticraft.venus.client.gui.GCVenusGuiSchematicRocketT3;
import spacecraft.mods.galacticraft.venus.inventory.GCVenusContainerRocketBenchT3;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusSchematicRocketT3 implements ISchematicPage
{
    @Override
    public int getPageID()
    {
        return GCVenusConfigManager.idSchematicRocketT3;
    }

    @Override
    public int getGuiID()
    {
        return GCVenusConfigManager.idGuiRocketCraftingBenchT3;
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
        return new GCVenusGuiSchematicRocketT3(player.inventory, x, y, z);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new GCVenusContainerRocketBenchT3(player.inventory, x, y, z);
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
