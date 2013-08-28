package micdoodle8.mods.galacticraft.core.client.gui;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.item.ItemStack;
import tconstruct.client.tabs.AbstractTab;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GCCoreInventoryTabGalacticraft extends AbstractTab
{
    public GCCoreInventoryTabGalacticraft()
    {
        super(0, 0, 0, new ItemStack(GCCoreItems.oxygenMask));
    }

    @Override
    public void onTabClicked()
    {
        PacketDispatcher.sendPacketToServer(PacketUtil.createPacket(GalacticraftCore.CHANNEL, 23, new Object[] {}));
    }

    @Override
    public boolean shouldAddToList()
    {
        return true;
    }
}
