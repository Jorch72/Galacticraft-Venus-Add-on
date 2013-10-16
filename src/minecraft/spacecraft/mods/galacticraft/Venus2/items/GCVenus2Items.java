package spacecraft.mods.galacticraft.Venus2.items;

import spacecraft.mods.galacticraft.Venus2.GCVenus2ConfigManager;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemRocketEngine;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class GCVenus2Items
{
    public static Item venus2ItemBasic;
    public static Item gemPickaxe;
    public static Item gemAxe;
    public static Item gemHoe;
    public static Item gemSpade;
    public static Item gemSword;
    public static Item gemHelmet;
    public static Item gemChestplate;
    public static Item gemLeggings;
    public static Item gemBoots;
    
    public static Item rocketEngine;
    public static Item spaceship;
    public static Item key;
    public static Item schematic;

    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);

    public static void initItems()
    {
        GCVenus2Items.venus2ItemBasic = new GCVenus2Item(GCVenus2ConfigManager.idItemVenus2Basic);
        GCVenus2Items.gemPickaxe = new GCVenus2ItemPickaxe(GCVenus2ConfigManager.idToolGemPickaxe, GCVenus2Items.TOOLGEM).setUnlocalizedName("gemPick");
        GCVenus2Items.gemAxe = new GCVenus2ItemAxe(GCVenus2ConfigManager.idToolGemAxe, GCVenus2Items.TOOLGEM).setUnlocalizedName("gemAxe");
        GCVenus2Items.gemHoe = new GCVenus2ItemHoe(GCVenus2ConfigManager.idToolGemHoe, GCVenus2Items.TOOLGEM).setUnlocalizedName("gemHoe");
        GCVenus2Items.gemSpade = new GCVenus2ItemSpade(GCVenus2ConfigManager.idToolGemSpade, GCVenus2Items.TOOLGEM).setUnlocalizedName("gemSpade");
        GCVenus2Items.gemSword = new GCVenus2ItemSword(GCVenus2ConfigManager.idToolGemSword, GCVenus2Items.TOOLGEM).setUnlocalizedName("gemSword");
        GCVenus2Items.gemHelmet = new GCVenus2ItemArmor(GCVenus2ConfigManager.idArmorGemHelmet, GCVenus2Items.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        GCVenus2Items.gemChestplate = new GCVenus2ItemArmor(GCVenus2ConfigManager.idArmorGemChestplate, GCVenus2Items.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        GCVenus2Items.gemLeggings = new GCVenus2ItemArmor(GCVenus2ConfigManager.idArmorGemLeggings, GCVenus2Items.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        GCVenus2Items.gemBoots = new GCVenus2ItemArmor(GCVenus2ConfigManager.idArmorGemBoots, GCVenus2Items.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");
        GCVenus2Items.rocketEngine = new GCVenus2ItemRocketEngine(GCVenus2ConfigManager.idItemRocketEngine, "engine");
        GCVenus2Items.spaceship = new GCVenus2ItemSpaceshipTier3(GCVenus2ConfigManager.idItemSpaceshipTier3).setUnlocalizedName("spaceshipTier3");
        GCVenus2Items.key = new GCVenus2ItemKey(GCVenus2ConfigManager.idItemKeyT2).setUnlocalizedName("key");
        GCVenus2Items.schematic = new GCVenus2ItemSchematic(GCVenus2ConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
    }

    public static void registerHarvestLevels()
    {
        MinecraftForge.setToolClass(GCVenus2Items.gemPickaxe, "pickaxe", 4);
        MinecraftForge.setToolClass(GCVenus2Items.gemAxe, "axe", 4);
        MinecraftForge.setToolClass(GCVenus2Items.gemSpade, "shovel", 4);
    }
}
