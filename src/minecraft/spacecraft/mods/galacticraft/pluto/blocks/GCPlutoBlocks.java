package spacecraft.mods.galacticraft.pluto.blocks;

import spacecraft.mods.galacticraft.pluto.GCPluto;
import spacecraft.mods.galacticraft.pluto.GCPlutoConfigManager;
import spacecraft.mods.galacticraft.pluto.items.GCPlutoItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCPlutoBlocks
{
    public static Block venusBlock;
    public static Block VenusCobblestone;

    public static void initBlocks()
    {
        GCPlutoBlocks.venusBlock = new GCPlutoBlock(GCPlutoConfigManager.idBlockPluto).setHardness(2.2F).setUnlocalizedName("pluto");
    }

    public static void setHarvestLevels()
    {
        MinecraftForge.setBlockHarvestLevel(GCPlutoBlocks.venusBlock, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(GCPlutoBlocks.VenusCobblestone, "pickaxe", 3);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(GCPlutoBlocks.venusBlock, GCPlutoItemBlock.class, GCPlutoBlocks.venusBlock.getUnlocalizedName(), GCPluto.MODID);
	}
}
