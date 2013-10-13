package spacecraft.mods.galacticraft.venus.items;

import java.util.List;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VenusItemT3RocketEngine extends Item
{
    public static final String[] names = { "tier3Engine", // 0
    "tier3Booster" }; // 1

    protected Icon[] icons = new Icon[VenusItemT3RocketEngine.names.length];

    public VenusItemT3RocketEngine(int id, String assetName)
    {
        super(id);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
//        this.setUnlocalizedName(assetName);
//        this.setTextureName(GalacticraftVenus.TEXTURE_PREFIX + assetName);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GalacticraftVenus.tabVenus;
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

        for (final String name : VenusItemT3RocketEngine.names)
        {
            this.icons[i++] = iconRegister.registerIcon(this.getIconString() + "." + name);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return this.getUnlocalizedName() + "." + VenusItemT3RocketEngine.names[itemStack.getItemDamage()];
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
        for (int i = 0; i < VenusItemT3RocketEngine.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
}
