package spacecraft.mods.galacticraft.venus.blocks;

import spacecraft.mods.galacticraft.venus.GCVenus;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemBlock;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenusBlocks
{
    public static Block venus2Block;
	public static Block basaltSlab;
    public static Block VenusCobblestone;
    public static Block blazeEgg;

    public static void initBlocks()
    {
        GCVenusBlocks.venus2Block = new GCVenusBlock(GCVenusConfigManager.idBlockVenus2).setHardness(2.2F).setUnlocalizedName("venus2");
        GCVenusBlocks.blazeEgg = new GCVenusBlockBlazeEgg(GCVenusConfigManager.idBlockBlazeEgg).setHardness(-1.0F).setUnlocalizedName("blazeEgg");
		GCVenusBlocks.basaltSlab = new GCVenusBlockBasaltSlab(GCVenusConfigManager.idBlockBasaltSlab).setHardness(-1.0F).setUnlocalizedName("basaltSlab");
    }

    public static void setHarvestLevels()
    {
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.venus2Block, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(GCVenusBlocks.VenusCobblestone, "pickaxe", 3);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(GCVenusBlocks.venus2Block, GCVenusItemBlock.class, GCVenusBlocks.venus2Block.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(GCVenusBlocks.blazeEgg, ItemBlock.class, GCVenusBlocks.blazeEgg.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(GCVenusBlocks.basaltSlab, ItemBlock.class, GCVenusBlocks.basaltSlab.getUnlocalizedName(), GCVenus.MODID);
	}
}
