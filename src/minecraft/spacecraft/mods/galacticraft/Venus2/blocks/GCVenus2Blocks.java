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
//    public static Block blockSludge;
//    public static Block vine;
    public static Block rock;
    public static Block tier3TreasureChest;
//    public static Block machine;
    public static Block creeperEgg;
//    public static Block tintedGlassPane;

//    public static Material bacterialSludge = new MaterialLiquid(MapColor.foliageColor);

    public static void initBlocks()
    {
        GCVenus2Blocks.marsBlock = new GCVenus2Block(GCVenus2ConfigManager.idBlockMars).setHardness(2.2F).setUnlocalizedName("mars");
//        GCMarsBlocks.blockSludge = new GCMarsBlockSludge(GalacticraftMars.SLUDGE.getBlockID(), GCMarsBlocks.bacterialSludge).setUnlocalizedName("sludge");
//        GCMarsBlocks.vine = new GCMarsBlockVine(GCMarsConfigManager.idBlockVine).setHardness(0.1F).setUnlocalizedName("cavernVines");
//        GCMarsBlocks.rock = new GCMarsBlockSlimelingEgg(GCMarsConfigManager.idBlockRock).setHardness(0.75F).setUnlocalizedName("slimelingEgg");
        GCVenus2Blocks.tier3TreasureChest = new GCVenus2BlockT3TreasureChest(GCVenus2ConfigManager.idBlockTreasureChestT3).setHardness(2.5F).setUnlocalizedName("treasureT3");
//        GCMarsBlocks.machine = new GCMarsBlockMachine(GCMarsConfigManager.idBlockMachine).setHardness(1.8F).setUnlocalizedName("marsMachine");
        GCVenus2Blocks.creeperEgg = new GCVenus2BlockCreeperEgg(GCVenus2ConfigManager.idBlockCreeperEgg).setHardness(-1.0F).setUnlocalizedName("creeperEgg");
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
//        GameRegistry.registerBlock(GCMarsBlocks.blockSludge, ItemBlock.class, GCMarsBlocks.blockSludge.getUnlocalizedName(), GalacticraftMars.MODID);
//        GameRegistry.registerBlock(GCMarsBlocks.vine, ItemBlock.class, GCMarsBlocks.vine.getUnlocalizedName(), GalacticraftMars.MODID);
//        GameRegistry.registerBlock(GCMarsBlocks.rock, GCMarsItemBlockRock.class, GCMarsBlocks.rock.getUnlocalizedName(), GalacticraftMars.MODID);
        GameRegistry.registerBlock(GCVenus2Blocks.tier3TreasureChest, ItemBlock.class, GCVenus2Blocks.tier3TreasureChest.getUnlocalizedName(), GCVenus2.MODID);
//        GameRegistry.registerBlock(GCMarsBlocks.machine, GCMarsItemBlockMachine.class, GCMarsBlocks.machine.getUnlocalizedName(), GalacticraftMars.MODID);
        GameRegistry.registerBlock(GCVenus2Blocks.creeperEgg, ItemBlock.class, GCVenus2Blocks.creeperEgg.getUnlocalizedName(), GCVenus2.MODID);
//        GameRegistry.registerBlock(GCMarsBlocks.tintedGlassPane, GCMarsItemBlockTintedGlassPane.class, GCMarsBlocks.tintedGlassPane.getUnlocalizedName(), GalacticraftMars.MODID);
    }
}
