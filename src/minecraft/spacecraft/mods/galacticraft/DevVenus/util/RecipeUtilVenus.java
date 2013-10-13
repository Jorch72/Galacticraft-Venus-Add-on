package spacecraft.mods.galacticraft.DevVenus.util;

import spacecraft.mods.galacticraft.DevVenus.inventory.VenusInventoryRocketBenchT3;
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
