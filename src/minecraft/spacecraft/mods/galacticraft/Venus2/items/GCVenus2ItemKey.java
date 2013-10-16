package spacecraft.mods.galacticraft.Venus2.items;

import java.util.List;

import spacecraft.mods.galacticraft.Venus2.GalacticraftVenus2;
import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenus2ItemKey extends Item implements IKeyItem
{
    public static String[] keyTypes = new String[] { "T3" };
    public Icon[] keyIcons = new Icon[1];

    public GCVenus2ItemKey(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GalacticraftVenus2.galacticraftVenus2Tab;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "item." + "key." + GCVenus2ItemKey.keyTypes[itemStack.getItemDamage()];
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

        for (final String name : GCVenus2ItemKey.keyTypes)
        {
            this.keyIcons[i++] = iconRegister.registerIcon(GalacticraftVenus2.TEXTURE_PREFIX + "key_" + name);
        }
    }

    @Override
    public Icon getIconFromDamage(int damage)
    {
        if (this.keyIcons.length > damage)
        {
            return this.keyIcons[damage];
        }

        return super.getIconFromDamage(damage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < GCVenus2ItemKey.keyTypes.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }

    @Override
    public int getTier(ItemStack keyStack)
    {
        return 3;
    }
}
