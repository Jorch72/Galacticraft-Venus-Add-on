package spacecraft.mods.galacticraft.venus.items;

import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemBow;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemRocketEngine;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class GCVenusItems
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
    public static Item jetpack;
    
    public static Item venusBattery;
    public static Item rocketEngine;
    public static Item spaceship;
    public static Item schematic;
    public static Item sulferFuel;
    public static Item sulferCanister;

    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 200, new int[] {0, 0, 0, 0}, 0);
    
    public static void initItems()
    {
        GCVenusItems.venus2ItemBasic = new GCVenusItem(GCVenusConfigManager.idItemVenus2Basic);
        GCVenusItems.gemPickaxe = new GCVenusItemPickaxe(GCVenusConfigManager.idToolGemPickaxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemPick");
        GCVenusItems.gemAxe = new GCVenusItemAxe(GCVenusConfigManager.idToolGemAxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemAxe");
        GCVenusItems.gemHoe = new GCVenusItemHoe(GCVenusConfigManager.idToolGemHoe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemHoe");
        GCVenusItems.gemSpade = new GCVenusItemSpade(GCVenusConfigManager.idToolGemSpade, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSpade");
        GCVenusItems.gemSword = new GCVenusItemSword(GCVenusConfigManager.idToolGemSword, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSword");
        GCVenusItems.gemHelmet = new GCVenusItemArmor(GCVenusConfigManager.idArmorGemHelmet, GCVenusItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        GCVenusItems.gemChestplate = new GCVenusItemArmor(GCVenusConfigManager.idArmorGemChestplate, GCVenusItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        GCVenusItems.gemLeggings = new GCVenusItemArmor(GCVenusConfigManager.idArmorGemLeggings, GCVenusItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        GCVenusItems.gemBoots = new GCVenusItemArmor(GCVenusConfigManager.idArmorGemBoots, GCVenusItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");
        
        GCVenusItems.jetpack = new GCVenusItemJetpack(GCVenusConfigManager.idArmorJetpack, GCVenusItems.ARMORJETPACK, 11, 1, false, null).setUnlocalizedName("jetpack");
        
        GCVenusItems.rocketEngine = new GCVenusItemRocketEngine(GCVenusConfigManager.idItemRocketEngine, "engine");
        GCVenusItems.spaceship = new GCVenusItemSpaceshipTier3(GCVenusConfigManager.idItemSpaceshipTier3).setUnlocalizedName("spaceshipTier3");
        GCVenusItems.schematic = new GCVenusItemSchematic(GCVenusConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
        GCVenusItems.sulferFuel = new GCVenusItemSulferFuel(GCVenusConfigManager.idItemSulferFuel, "sulferFuel");
        GCVenusItems.sulferCanister = new GCVenusItemSulferCanister(GCVenusConfigManager.idItemSulferCanister, "sulferCanister");
        GCVenusItems.venusBattery = new GCVenusItemBattery(GCVenusConfigManager.idItemVenusBattery, "venusBattery");
    }
    
    public static void registerHarvestLevels()
    {
        MinecraftForge.setToolClass(GCVenusItems.gemPickaxe, "pickaxe", 4);
        MinecraftForge.setToolClass(GCVenusItems.gemAxe, "axe", 4);
        MinecraftForge.setToolClass(GCVenusItems.gemSpade, "shovel", 4);
    }
}
