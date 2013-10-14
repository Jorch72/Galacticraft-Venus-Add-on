package spacecraft.mods.galacticraft.devVenus.util;

import spacecraft.mods.galacticraft.devVenus.inventory.GCMarsInventoryRocketBenchT2;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class RecipeUtilMars
{
    public static ItemStack findMatchingSpaceshipT2Recipe(GCMarsInventoryRocketBenchT2 inventoryRocketBench)
    {
        for (INasaWorkbenchRecipe recipe : GalacticraftRegistry.getRocketT2Recipes())
        {
            if (recipe.matches(inventoryRocketBench))
            {
                return recipe.getRecipeOutput();
            }
        }

        return null;
    }

 //   public static ItemStack findMatchingCargoRocketRecipe(GCMarsInventoryCargoRocketBench inventoryRocketBench)
    {
        for (INasaWorkbenchRecipe recipe : GalacticraftRegistry.getCargoRocketRecipes())
        {
//            if (recipe.matches(inventoryRocketBench))
            {
//                return recipe.getRecipeOutput();
            }
        }

//        return null;
    }
}
