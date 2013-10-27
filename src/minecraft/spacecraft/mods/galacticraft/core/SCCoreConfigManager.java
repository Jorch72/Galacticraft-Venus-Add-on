package spacecraft.mods.galacticraft.core;

import java.io.File;
import java.util.logging.Level;

import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCCoreConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public SCCoreConfigManager(File file)
    {
        if (!SCCoreConfigManager.loaded)
        {
            SCCoreConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS

    // BLOCKS
    
    // ITEMS
    public static int idItemVenusBasic;
    public static int idItemSpaceshipTier3;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;
    public static int idArmorJetpack;
    
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

    // ACHIEVEMENTS
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            SCCoreConfigManager.configuration.load();

            SCCoreConfigManager.idItemVenusBasic = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 5905).getInt(5905);
            SCCoreConfigManager.idItemSpaceshipTier3 = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 5906).getInt(5906);
            SCCoreConfigManager.idItemSchematicMars = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 5907).getInt(5907);
            SCCoreConfigManager.idItemRocketEngine = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngineMars", 5908).getInt(5908);
            SCCoreConfigManager.idArmorJetpack = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorJetpack", 5910).getInt(5910);

            SCCoreConfigManager.idToolGemSword = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 8907).getInt(8907);
            SCCoreConfigManager.idToolGemPickaxe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 8908).getInt(8908);
            SCCoreConfigManager.idToolGemSpade = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 8909).getInt(8909);
            SCCoreConfigManager.idToolGemHoe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 8910).getInt(8910);
            SCCoreConfigManager.idToolGemAxe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 8911).getInt(8911);

            SCCoreConfigManager.idArmorGemHelmet = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 8912).getInt(8912);
            SCCoreConfigManager.idArmorGemChestplate = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 8913).getInt(8913);
            SCCoreConfigManager.idArmorGemLeggings = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 8914).getInt(8914);
            SCCoreConfigManager.idArmorGemBoots = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 8915).getInt(8915);

            SCCoreConfigManager.idEntitySpaceshipTier3 = SCCoreConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            SCCoreConfigManager.idGuiRocketCraftingBenchT3 = SCCoreConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);

            SCCoreConfigManager.idSchematicRocketT3 = SCCoreConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
        }
        finally
        {
            SCCoreConfigManager.configuration.save();
            SCCoreConfigManager.loaded = true;
        }
    }
}
