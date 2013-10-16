package spacecraft.mods.galacticraft.Venus2.blocks;

import spacecraft.mods.galacticraft.Venus2.GCVenus2ConfigManager;
import spacecraft.mods.galacticraft.Venus2.GCVenus2;
import spacecraft.mods.galacticraft.Venus2.items.GCVenus2ItemBlock;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenus2Blocks
{
    public static Block marsBlock;
    public static Block VenusCobblestone;
    public static Block rock;
    public static Block tier3TreasureChest;
    public static Block blazeEgg;

    public static void initBlocks()
    {
        GCVenus2Blocks.marsBlock = new GCVenus2Block(GCVenus2ConfigManager.idBlockMars).setHardness(2.2F).setUnlocalizedName("mars");
        GCVenus2Blocks.tier3TreasureChest = new GCVenus2BlockT3TreasureChest(GCVenus2ConfigManager.idBlockTreasureChestT3).setHardness(2.5F).setUnlocalizedName("treasureT3");
        GCVenus2Blocks.blazeEgg = new GCVenus2BlockBlazeEgg(GCVenus2ConfigManager.idBlockBlazeEgg).setHardness(-1.0F).setUnlocalizedName("blazeEgg");
//        GCMarsBlocks.tintedGlassPane = new GCMarsBlockTintedGlassPane(GCMarsConfigManager.idBlockTintedGlassPane).setHardness(0.6F).setUnlocalizedName("tintedGlassPane");
    }

    public static void setHarvestLevels()
    {
        MinecraftForge.setBlockHarvestLevel(GCVenus2Blocks.marsBlock, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(GCVenus2Blocks.rock, "pickaxe", 3);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(GCVenus2Blocks.marsBlock, GCVenus2ItemBlock.class, GCVenus2Blocks.marsBlock.getUnlocalizedName(), GCVenus2.MODID);
//        GameRegistry.registerBlock(GCMarsBlocks.rock, GCMarsItemBlockRock.class, GCMarsBlocks.rock.getUnlocalizedName(), GalacticraftMars.MODID);
        GameRegistry.registerBlock(GCVenus2Blocks.tier3TreasureChest, ItemBlock.class, GCVenus2Blocks.tier3TreasureChest.getUnlocalizedName(), GCVenus2.MODID);
        GameRegistry.registerBlock(GCVenus2Blocks.blazeEgg, ItemBlock.class, GCVenus2Blocks.blazeEgg.getUnlocalizedName(), GCVenus2.MODID);
    }
}
