package spacecraft.mods.galacticraft.T3Rocket.util;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import net.minecraft.item.ItemStack;

public class RecipeUtilVenus
{
    public static ItemStack findMatchingSpaceshipT2Recipe(VenusInventoryRocketBenchT3 inventoryRocketBench)
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
}
