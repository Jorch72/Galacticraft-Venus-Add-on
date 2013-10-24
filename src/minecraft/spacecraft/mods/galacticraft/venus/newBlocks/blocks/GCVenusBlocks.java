package spacecraft.mods.galacticraft.venus.newBlocks.blocks;

import spacecraft.mods.galacticraft.venus.GCVenus;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import spacecraft.mods.galacticraft.venus.blocks.GCVenusBlockOre;
import spacecraft.mods.galacticraft.venus.newBlocks.items.GCVenusItemOres;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenusBlocks
{
    public static Block blockVenus;
//    public static Block cheeseBlock;

    public static void initBlocks()
    {
        GCVenusBlocks.blockVenus = new GCVenusBlockOre(GCVenusConfigManager.idBlockVenus, null);
//        GCVenusBlocks.cheeseBlock = new GCMoonBlockCheese(GCMoonConfigManager.idBlockCheese).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("cheeseBlock");
    }

    public static void setHarvestLevels()
    {
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 0, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 1, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 2, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 3, "pickaxe", 3);
//        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 3, "shovel", 0);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 4, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 5, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 6, "pickaxe", 3);

//        for (int num = 5; num < 14; num++)
//        {
//            MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, num, "shovel", 0);
//        }

        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.blockVenus, 14, "pickaxe", 2);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(GCVenusBlocks.blockVenus, GCVenusItemOres.class, GCVenusBlocks.blockVenus.getUnlocalizedName(), GCVenus.MODID);
//        GameRegistry.registerBlock(GCVenusBlocks.cheeseBlock, ItemBlock.class, GCVenusBlocks.cheeseBlock.getUnlocalizedName(), GalacticraftCore.MODID);
    }
}
