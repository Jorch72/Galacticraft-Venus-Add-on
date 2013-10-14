package spacecraft.mods.galacticraft.venus.items;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import mekanism.api.EnumColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VenusHeavyPlate extends Item {
	public VenusHeavyPlate(int id) {
        super(id);
        this.setCreativeTab(GalacticraftVenus.tabVenus);
}
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if (par2EntityPlayer.worldObj.isRemote)
        {
            switch (par1ItemStack.getItemDamage())
            {
            case 0:
                par3List.add("Tier 3");
                break;
            }
        }
    }
}