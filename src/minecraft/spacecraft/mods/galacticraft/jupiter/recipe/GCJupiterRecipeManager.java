package spacecraft.mods.galacticraft.jupiter.recipe;

import java.util.HashMap;

import spacecraft.mods.galacticraft.jupiter.util.GCJupiterUtil;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCJupiterRecipeManager
{
    public static void loadRecipes()
    {
        GCJupiterRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
//        OreDictionary.registerOre("ingotDesh", new ItemStack(GCMercuryItems.venusItemBasic, 1, 2));
//        OreDictionary.registerOre("plateDesh", new ItemStack(GCMercuryItems.venusItemBasic, 1, 5));
//        OreDictionary.registerOre("plateHeavyT2", new ItemStack(GCMercuryItems.venusItemBasic, 1, 3));

//        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.venusItemBasic, 1, 1), new Object[] { "X", "X", 'X', "ingotDesh" });

//        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.venusItemBasic, 1, 4), new Object[] { "XWX", "XYX", " Z ", 'W', Item.diamond, 'X', Item.leather, 'Y', Item.slimeBall, 'Z', Block.chest });
        
        // Smelting
//        FurnaceRecipes.smelting().addSmelting(GCMercuryItems.venusItemBasic.itemID, 0, new ItemStack(GCMercuryItems.venusItemBasic, 1, 2), 0.2F);
    }
}
