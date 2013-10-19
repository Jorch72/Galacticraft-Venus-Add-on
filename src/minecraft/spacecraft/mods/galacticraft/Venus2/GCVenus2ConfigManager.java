package spacecraft.mods.galacticraft.Venus2;

import java.io.File;
import java.util.logging.Level;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVenus2ConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCVenus2ConfigManager(File file)
    {
        if (!GCVenus2ConfigManager.loaded)
        {
            GCVenus2ConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDVenus2;

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
            GCVenus2ConfigManager.configuration.load();

            GCVenus2ConfigManager.dimensionIDVenus2 = GCVenus2ConfigManager.configuration.get("Dimensions", "Venus 2 Dimension ID", -46).getInt(-46);

            GCVenus2ConfigManager.idBlockVenus2 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus2", 3390).getInt(3390);
            GCVenus2ConfigManager.idBlockTreasureChestT3 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockTreasureChestT3", 3394).getInt(3394);
            GCVenus2ConfigManager.idBlockBlazeEgg = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBlazeEgg", 3396).getInt(3396);
			GCVenus2ConfigManager.idBlockBasaltSlab = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBasaltSlab", 3700).getInt(3700);

            GCVenus2ConfigManager.idItemVenus2Basic = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenus2ItemBasic", 9905).getInt(9905);
            GCVenus2ConfigManager.idItemSpaceshipTier3 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 9906).getInt(9906);
            GCVenus2ConfigManager.idItemKeyT2 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemKeyT2", 9916).getInt(9916);
            GCVenus2ConfigManager.idItemSchematicMars = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 9917).getInt(9917);
            GCVenus2ConfigManager.idItemRocketEngine = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngineMars", 9939).getInt(9939);
            GCVenus2ConfigManager.idItemSulferFuel = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSulferFuel", 9993).getInt(9993);
            GCVenus2ConfigManager.idItemSulferCanister = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSulferCanister", 9994).getInt(9994);

            GCVenus2ConfigManager.idToolGemSword = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 9907).getInt(9907);
            GCVenus2ConfigManager.idToolGemPickaxe = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 9908).getInt(9908);
            GCVenus2ConfigManager.idToolGemSpade = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 9909).getInt(9909);
            GCVenus2ConfigManager.idToolGemHoe = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 9910).getInt(9910);
            GCVenus2ConfigManager.idToolGemAxe = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 9911).getInt(9911);

            GCVenus2ConfigManager.idArmorGemHelmet = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 9912).getInt(9912);
            GCVenus2ConfigManager.idArmorGemChestplate = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 9913).getInt(9913);
            GCVenus2ConfigManager.idArmorGemLeggings = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 9914).getInt(9914);
            GCVenus2ConfigManager.idArmorGemBoots = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 9915).getInt(9915);

            GCVenus2ConfigManager.idEntitySpaceshipTier3 = GCVenus2ConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            GCVenus2ConfigManager.idGuiRocketCraftingBenchT3 = GCVenus2ConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);

            GCVenus2ConfigManager.idSchematicRocketT3 = GCVenus2ConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);
            GCVenus2ConfigManager.idSchematicCargoRocket = GCVenus2ConfigManager.configuration.get("Schematic", "idSchematicCargoRocket", 3).getInt(3);

            GCVenus2ConfigManager.generateOtherMods = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Mars", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus 2 has a problem loading it's configuration");
        }
        finally
        {
            GCVenus2ConfigManager.configuration.save();
            GCVenus2ConfigManager.loaded = true;
        }
    }
}
