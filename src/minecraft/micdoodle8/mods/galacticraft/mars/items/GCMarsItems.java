package micdoodle8.mods.galacticraft.mars.items;

import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class GCMarsItems
{
    public static Item marsItemBasic;
    public static Item gemPickaxe;
    public static Item gemAxe;
    public static Item gemHoe;
    public static Item gemSpade;
    public static Item gemSword;
    public static Item gemHelmet;
    public static Item gemChestplate;
    public static Item gemLeggings;
    public static Item gemBoots;
    
    public static Item spaceship;
    public static Item key;
    public static Item schematic;

    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);

    public static void initItems()
    {
        GCMarsItems.marsItemBasic = new GCMarsItem(GCMarsConfigManager.idItemMarsBasic);
        GCMarsItems.gemPickaxe = new GCMarsItemPickaxe(GCMarsConfigManager.idToolDeshPickaxe, GCMarsItems.TOOLGEM).setUnlocalizedName("gemPick");
        GCMarsItems.gemAxe = new GCMarsItemAxe(GCMarsConfigManager.idToolDeshAxe, GCMarsItems.TOOLGEM).setUnlocalizedName("gemAxe");
        GCMarsItems.gemHoe = new GCMarsItemHoe(GCMarsConfigManager.idToolDeshHoe, GCMarsItems.TOOLGEM).setUnlocalizedName("gemHoe");
        GCMarsItems.gemSpade = new GCMarsItemSpade(GCMarsConfigManager.idToolDeshSpade, GCMarsItems.TOOLGEM).setUnlocalizedName("gemSpade");
        GCMarsItems.gemSword = new GCMarsItemSword(GCMarsConfigManager.idToolDeshSword, GCMarsItems.TOOLGEM).setUnlocalizedName("gemSword");
        GCMarsItems.gemHelmet = new GCMarsItemArmor(GCMarsConfigManager.idArmorDeshHelmet, GCMarsItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        GCMarsItems.gemChestplate = new GCMarsItemArmor(GCMarsConfigManager.idArmorDeshChestplate, GCMarsItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        GCMarsItems.gemLeggings = new GCMarsItemArmor(GCMarsConfigManager.idArmorDeshLeggings, GCMarsItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        GCMarsItems.gemBoots = new GCMarsItemArmor(GCMarsConfigManager.idArmorDeshBoots, GCMarsItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");
        GCMarsItems.spaceship = new GCMarsItemSpaceshipTier2(GCMarsConfigManager.idItemSpaceshipTier2).setUnlocalizedName("spaceshipTier2");
        GCMarsItems.key = new GCMarsItemKey(GCMarsConfigManager.idItemKeyT2).setUnlocalizedName("key");
        GCMarsItems.schematic = new GCMarsItemSchematic(GCMarsConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
    }

    public static void registerHarvestLevels()
    {
        MinecraftForge.setToolClass(GCMarsItems.gemPickaxe, "pickaxe", 4);
        MinecraftForge.setToolClass(GCMarsItems.gemAxe, "axe", 4);
        MinecraftForge.setToolClass(GCMarsItems.gemSpade, "shovel", 4);
    }
}
