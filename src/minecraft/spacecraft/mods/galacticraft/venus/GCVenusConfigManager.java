package spacecraft.mods.galacticraft.venus;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVenusConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCVenusConfigManager(File file)
    {
        if (!GCVenusConfigManager.loaded)
        {
            GCVenusConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDVenus;

    // BLOCKS
    public static int idBlockVenus2;
    public static int idBlockTreasureChestT3;
    public static int idBlockBlazeEgg;
	public static int idBlockBasaltSlab;

    // ITEMS
    public static int idItemVenus2Basic;
    public static int idItemSpaceshipTier3;
    public static int idItemKeyT2;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;
    public static int idItemSulferFuel;
    public static int idItemSulferCanister;
    public static int idItemVenusBattery;
    
    // ARMOR
    public static int idArmorGemHelmet;
    public static int idArmorGemChestplate;
    public static int idArmorGemLeggings;
    public static int idArmorGemBoots;

    // TOOLS
    public static int idToolGemSword;
    public static int idToolGemPickaxe;
    public static int idToolGemAxe;
    public static int idToolGemSpade;
    public static int idToolGemHoe;

    // ENTITIES
    public static int idEntitySpaceshipTier3;
    
    // GUI
    public static int idGuiRocketCraftingBenchT3;

    // SCHEMATIC
    public static int idSchematicRocketT3;
    public static int idSchematicCargoRocket;

    // GENERAL
    public static boolean generateOtherMods;

    private void setDefaultValues()
    {
        try
        {
            GCVenusConfigManager.configuration.load();

            GCVenusConfigManager.dimensionIDVenus = GCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -46).getInt(-46);

            GCVenusConfigManager.idBlockVenus2 = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus2", 3390).getInt(3390);
            GCVenusConfigManager.idBlockTreasureChestT3 = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockTreasureChestT3", 3394).getInt(3394);
            GCVenusConfigManager.idBlockBlazeEgg = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBlazeEgg", 3396).getInt(3396);
            GCVenusConfigManager.idBlockBasaltSlab = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBasaltSlab", 3700).getInt(3700);

            GCVenusConfigManager.idItemVenus2Basic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenus2ItemBasic", 9905).getInt(9905);
            GCVenusConfigManager.idItemSpaceshipTier3 = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 9906).getInt(9906);
            GCVenusConfigManager.idItemKeyT2 = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemKeyT2", 9916).getInt(9916);
            GCVenusConfigManager.idItemSchematicMars = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 9917).getInt(9917);
            GCVenusConfigManager.idItemRocketEngine = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngineMars", 9939).getInt(9939);
            GCVenusConfigManager.idItemSulferFuel = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSulferFuel", 9993).getInt(9993);
            GCVenusConfigManager.idItemSulferCanister = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSulferCanister", 9994).getInt(9994);
            GCVenusConfigManager.idItemVenusBattery = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 9995).getInt(9995);

            GCVenusConfigManager.idToolGemSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 9907).getInt(9907);
            GCVenusConfigManager.idToolGemPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 9908).getInt(9908);
            GCVenusConfigManager.idToolGemSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 9909).getInt(9909);
            GCVenusConfigManager.idToolGemHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 9910).getInt(9910);
            GCVenusConfigManager.idToolGemAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 9911).getInt(9911);

            GCVenusConfigManager.idArmorGemHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 9912).getInt(9912);
            GCVenusConfigManager.idArmorGemChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 9913).getInt(9913);
            GCVenusConfigManager.idArmorGemLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 9914).getInt(9914);
            GCVenusConfigManager.idArmorGemBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 9915).getInt(9915);

            GCVenusConfigManager.idEntitySpaceshipTier3 = GCVenusConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            GCVenusConfigManager.idGuiRocketCraftingBenchT3 = GCVenusConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);

            GCVenusConfigManager.idSchematicRocketT3 = GCVenusConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);
            GCVenusConfigManager.idSchematicCargoRocket = GCVenusConfigManager.configuration.get("Schematic", "idSchematicCargoRocket", 3).getInt(3);

            GCVenusConfigManager.idSchematicRocketT3 = GCVenusConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);
            GCVenusConfigManager.idSchematicCargoRocket = GCVenusConfigManager.configuration.get("Schematic", "idSchematicCargoRocket", 3).getInt(3);

            GCVenusConfigManager.generateOtherMods = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus 2", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus 2 has a problem loading it's configuration");
        }
        finally
        {
            GCVenusConfigManager.configuration.save();
            GCVenusConfigManager.loaded = true;
        }
    }
}
