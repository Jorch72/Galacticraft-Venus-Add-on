package spacecraft.mods.galacticraft.devVenus.util;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.mars.inventory.GCMarsInventoryRocketBenchT2;
import net.minecraft.item.ItemStack;

public class RecipeUtilVenus
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
}
