package spacecraft.mods.galacticraft.Venus2.items;

import spacecraft.mods.galacticraft.Venus2.GCVenus2;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenus2ItemBlock extends ItemBlock
{
    public GCVenus2ItemBlock(int i)
    {
        super(i);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
        case 0:
        {
            name = "coppervenus";
            break;
        }
        case 1:
        {
            name = "tinvenus";
            break;
        }
        case 2:
        {
            name = "ironvenus";
            break;
        }
        case 3:
        {
            name = "coalmars";
            break;
        }
        case 4:
        {
            name = "meteormars";
            break;
        }
        case 5:
        {
            name = "gemmars";
            break;
        }
        case 6:
        {
            name = "sulfermars";
            break;
        }
        case 7:
        {
            name = "marscobblestone";
            break;
        }
        case 8:
        {
            name = "marsgrass";
            break;
        }
        case 9:
        {
            name = "marsdirt";
            break;
        }
        case 10:
        {
            name = "marsdungeon";
            break;
        }
        case 11:
        {
            name = "venusgemblock";
            break;
        }
        case 12:
        {
            name = "sulferblock";
            break;
        }
        case 13:
        {
            name = "gemblock";
            break;
        }
        case 14:
        {
            name = "meteorblock";
            break;
        }
        case 15:
        {
            name = "marsstone";
            break;
        }
        default:
            name = "null";
        }

        return Block.blocksList[this.getBlockID()].getUnlocalizedName() + "." + name;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCVenus2.galacticraftVenus2Tab;
    }

    @Override
    public String getUnlocalizedName()
    {
        return Block.blocksList[this.getBlockID()].getUnlocalizedName() + ".0";
    }
}
