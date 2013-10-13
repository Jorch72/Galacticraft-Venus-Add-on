package spacecraft.mods.galacticraft.venus.util;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import spacecraft.mods.galacticraft.venus.inventory.VenusInventoryRocketBenchT3;
import net.minecraft.item.ItemStack;

public class RecipeUtilVenus
{
    public static ItemStack findMatchingSpaceshipT3Recipe(VenusInventoryRocketBenchT3 inventoryRocketBench)
    {
        for (INasaWorkbenchRecipe recipe : GalacticraftRegistry.getRocketT3Recipes())
        {
            if (recipe.matches(inventoryRocketBench))
            {
                return recipe.getRecipeOutput();
            }
        }

        return null;
    }

//    public static ItemStack findMatchingCargoRocketRecipe(GCMarsInventoryCargoRocketBench inventoryRocketBench)
//    {
//        for (INasaWorkbenchRecipe recipe : GalacticraftRegistry.getCargoRocketRecipes())
//        {
//            if (recipe.matches(inventoryRocketBench))
//            {
//                return recipe.getRecipeOutput();
//            }
//        }

//        return null;
//    }
}
