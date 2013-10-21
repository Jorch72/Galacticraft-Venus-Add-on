package spacecraft.mods.galacticraft.venus.blocks;

import spacecraft.mods.galacticraft.venus.GCVenus2;
import spacecraft.mods.galacticraft.venus.GCVenus2ConfigManager;
import spacecraft.mods.galacticraft.venus.items.GCVenus2ItemBlock;
import spacecraft.mods.galacticraft.venusBlocks.GCVenusConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenus2Blocks
{
    public static Block venus2Block;
	public static Block basaltSlab;
    public static Block VenusCobblestone;
    public static Block blazeEgg;

    public static void initBlocks()
    {
        GCVenus2Blocks.venus2Block = new GCVenus2Block(GCVenus2ConfigManager.idBlockVenus2).setHardness(2.2F).setUnlocalizedName("venus2");
        GCVenus2Blocks.blazeEgg = new GCVenus2BlockBlazeEgg(GCVenus2ConfigManager.idBlockBlazeEgg).setHardness(-1.0F).setUnlocalizedName("blazeEgg");
		GCVenus2Blocks.basaltSlab = new GCVenus2BlockBasaltSlab(GCVenus2ConfigManager.idBlockBasaltSlab).setHardness(-1.0F).setUnlocalizedName("basaltSlab");
    }

    public static void setHarvestLevels()
    {
        MinecraftForge.setBlockHarvestLevel(GCVenus2Blocks.venus2Block, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(GCVenus2Blocks.VenusCobblestone, "pickaxe", 3);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(GCVenus2Blocks.venus2Block, GCVenus2ItemBlock.class, GCVenus2Blocks.venus2Block.getUnlocalizedName(), GCVenus2.MODID);
		GameRegistry.registerBlock(GCVenus2Blocks.blazeEgg, ItemBlock.class, GCVenus2Blocks.blazeEgg.getUnlocalizedName(), GCVenus2.MODID);
		GameRegistry.registerBlock(GCVenus2Blocks.basaltSlab, ItemBlock.class, GCVenus2Blocks.basaltSlab.getUnlocalizedName(), GCVenus2.MODID);
	}
}
