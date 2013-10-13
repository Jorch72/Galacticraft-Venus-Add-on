package spacecraft.mods.galacticraft.DevVenus.schematic;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import spacecraft.mods.galacticraft.DevVenus.GCDevVenusConfigManager;
import spacecraft.mods.galacticraft.DevVenus.client.gui.VenusGuiSchematicRocketT3;
import spacecraft.mods.galacticraft.DevVenus.inventory.VenusContainerRocketBenchT3;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VenusSchematicRocketT3 implements ISchematicPage
{
    @Override
    public int getPageID()
    {
        return GCDevVenusConfigManager.tier3SchematicID;
    }

    @Override
    public int getGuiID()
    {
        return GCDevVenusConfigManager.idGuiRocketCraftingBenchT3;
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
        return new VenusGuiSchematicRocketT3(player.inventory, x, y, z);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new VenusContainerRocketBenchT3(player.inventory, x, y, z);
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
