package spacecraft.mods.galacticraft.venus.items;

import java.util.List;

import spacecraft.mods.galacticraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItem extends Item
{
    public static String[] names = { "ingotSulfer", "ingotGem", "itemGem", "reinforcedVenusPlateT3", "venusPlate", "redGemPlate", "sulferPlate", "venusPowerCrystal", "venusPowerCell", "rawBasalt", "basaltBrick", "vurnBerry" };
    protected Icon[] icons = new Icon[GCVenusItem.names.length];

    public GCVenusItem(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCVenus.galacticraftVenusTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        int i = 0;

        for (String name : GCVenusItem.names)
        {
            this.icons[i++] = iconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + name);
        }
    }

    @Override
    public Icon getIconFromDamage(int damage)
    {
        if (this.icons.length > damage)
        {
            return this.icons[damage];
        }

        return super.getIconFromDamage(damage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < GCVenusItem.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        if (this.icons.length > par1ItemStack.getItemDamage())
        {
            return "item." + GCVenusItem.names[par1ItemStack.getItemDamage()];
        }

        return "unnamed";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if (par1ItemStack != null && par1ItemStack.getItemDamage() == 3)
        {
            par3List.add(LanguageRegistry.instance().getStringLocalization("item.tier3.desc"));
        }
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
}
