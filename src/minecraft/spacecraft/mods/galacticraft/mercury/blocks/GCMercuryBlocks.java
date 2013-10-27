package spacecraft.mods.galacticraft.mercury.blocks;

import spacecraft.mods.galacticraft.mercury.GCMercury;
import spacecraft.mods.galacticraft.mercury.GCMercuryConfigManager;
import spacecraft.mods.galacticraft.mercury.items.GCMercuryItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCMercuryBlocks
{
    public static Block venusBlock;
    public static Block VenusCobblestone;

    public static void initBlocks()
    {
        GCMercuryBlocks.venusBlock = new GCMercuryBlock(GCMercuryConfigManager.idBlockMercury).setHardness(2.2F).setUnlocalizedName("venus2");
    }

    public static void setHarvestLevels()
    {
        MinecraftForge.setBlockHarvestLevel(GCMercuryBlocks.venusBlock, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(GCMercuryBlocks.VenusCobblestone, "pickaxe", 3);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(GCMercuryBlocks.venusBlock, GCMercuryItemBlock.class, GCMercuryBlocks.venusBlock.getUnlocalizedName(), GCMercury.MODID);
	}
}
