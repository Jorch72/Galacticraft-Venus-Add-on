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
    public static int dimensionIDMars;

    // BLOCKS
    public static int idBlockMars;
//    public static int idBlockBacterialSludge;
//    public static int idBlockVine;
    public static int idBlockRock;
    public static int idBlockTreasureChestT2;
//    public static int idBlockMachine;
    public static int idBlockCreeperEgg;
//    public static int idBlockTintedGlassPane;

    // ITEMS
    public static int idItemMarsBasic;
    public static int idItemSpaceshipTier3;
    public static int idItemKeyT2;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;

    // ARMOR
    public static int idArmorDeshHelmet;
    public static int idArmorDeshChestplate;
    public static int idArmorDeshLeggings;
    public static int idArmorDeshBoots;

    // TOOLS
    public static int idToolDeshSword;
    public static int idToolDeshPickaxe;
    public static int idToolDeshAxe;
    public static int idToolDeshSpade;
    public static int idToolDeshHoe;

    // ENTITIES
//    public static int idEntityCreeperBoss;
//    public static int idEntityProjectileTNT;
    public static int idEntitySpaceshipTier3;
//    public static int idEntitySludgeling;
//    public static int idEntitySlimeling;
//    public static int idEntityTerraformBubble;
//    public static int idEntityLandingBalloons;
//    public static int idEntityCargoRocket;

    // GUI
    public static int idGuiRocketCraftingBenchT3;
//    public static int idGuiMachine;
//    public static int idGuiCargoRocketCraftingBench;

    // SCHEMATIC
    public static int idSchematicRocketT3;
    public static int idSchematicCargoRocket;

    // GENERAL
    public static boolean generateOtherMods;
    public static boolean launchControllerChunkLoad;

    private void setDefaultValues()
    {
        try
        {
            GCVenus2ConfigManager.configuration.load();

            GCVenus2ConfigManager.dimensionIDMars = GCVenus2ConfigManager.configuration.get("Dimensions", "Mars Dimension ID", -29).getInt(-29);

            GCVenus2ConfigManager.idBlockMars = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMars", 3390).getInt(3390);
//            GCMarsConfigManager.idBlockBacterialSludge = GCMarsConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBacterialSludge", 3391).getInt(3391);
//            GCMarsConfigManager.idBlockVine = GCMarsConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVine", 3392).getInt(3392);
            GCVenus2ConfigManager.idBlockRock = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockRock", 3393).getInt(3393);
            GCVenus2ConfigManager.idBlockTreasureChestT2 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockTreasureChestT2", 3394).getInt(3394);
//            GCMarsConfigManager.idBlockMachine = GCMarsConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMachine", 3395).getInt(3395);
            GCVenus2ConfigManager.idBlockCreeperEgg = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockCreeperEgg", 3396).getInt(3396);
//            GCMarsConfigManager.idBlockTintedGlassPane = GCMarsConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockTintedGlassPane", 3397).getInt(3397);

            GCVenus2ConfigManager.idItemMarsBasic = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemMarsBasic", 9905).getInt(9905);
            GCVenus2ConfigManager.idItemSpaceshipTier3 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 9906).getInt(9906);
            GCVenus2ConfigManager.idItemKeyT2 = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemKeyT2", 9916).getInt(9916);
            GCVenus2ConfigManager.idItemSchematicMars = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 9917).getInt(9917);
            GCVenus2ConfigManager.idItemRocketEngine = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngineMars", 9939).getInt(9939);

            GCVenus2ConfigManager.idToolDeshSword = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolDeshSword", 9907).getInt(9907);
            GCVenus2ConfigManager.idToolDeshPickaxe = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolDeshPickaxe", 9908).getInt(9908);
            GCVenus2ConfigManager.idToolDeshSpade = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolDeshSpade", 9909).getInt(9909);
            GCVenus2ConfigManager.idToolDeshHoe = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolDeshHoe", 9910).getInt(9910);
            GCVenus2ConfigManager.idToolDeshAxe = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolDeshAxe", 9911).getInt(9911);

            GCVenus2ConfigManager.idArmorDeshHelmet = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorDeshHelmet", 9912).getInt(9912);
            GCVenus2ConfigManager.idArmorDeshChestplate = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorDeshChestplate", 9913).getInt(9913);
            GCVenus2ConfigManager.idArmorDeshLeggings = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorDeshLeggings", 9914).getInt(9914);
            GCVenus2ConfigManager.idArmorDeshBoots = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorDeshBoots", 9915).getInt(9915);

//            GCMarsConfigManager.idEntityCreeperBoss = GCMarsConfigManager.configuration.get("Entities", "idEntityCreeperBoss", 171).getInt(171);
//            GCMarsConfigManager.idEntityProjectileTNT = GCMarsConfigManager.configuration.get("Entities", "idEntityProjectileTNT", 172).getInt(172);
            GCVenus2ConfigManager.idEntitySpaceshipTier3 = GCVenus2ConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
//            GCMarsConfigManager.idEntitySludgeling = GCMarsConfigManager.configuration.get("Entities", "idEntitySludgeling", 174).getInt(174);
//            GCMarsConfigManager.idEntitySlimeling = GCMarsConfigManager.configuration.get("Entities", "idEntitySlimeling", 175).getInt(175);
//            GCMarsConfigManager.idEntityTerraformBubble = GCMarsConfigManager.configuration.get("Entities", "idEntityTerraformBubble", 176).getInt(176);
//            GCMarsConfigManager.idEntityLandingBalloons = GCMarsConfigManager.configuration.get("Entities", "idEntityLandingBalloons", 177).getInt(177);
//            GCMarsConfigManager.idEntityCargoRocket = GCMarsConfigManager.configuration.get("Entities", "idEntityCargoRocket", 178).getInt(178);

            GCVenus2ConfigManager.idGuiRocketCraftingBenchT3 = GCVenus2ConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);
//            GCMarsConfigManager.idGuiMachine = GCMarsConfigManager.configuration.get("GUI", "idGuiMachine", 146).getInt(146);
//            GCMarsConfigManager.idGuiCargoRocketCraftingBench = GCMarsConfigManager.configuration.get("GUI", "idGuiCargoRocketCraftingBench", 147).getInt(147);

            GCVenus2ConfigManager.idSchematicRocketT3 = GCVenus2ConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);
            GCVenus2ConfigManager.idSchematicCargoRocket = GCVenus2ConfigManager.configuration.get("Schematic", "idSchematicCargoRocket", 3).getInt(3);

            GCVenus2ConfigManager.generateOtherMods = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Mars", false).getBoolean(false);
            GCVenus2ConfigManager.launchControllerChunkLoad = GCVenus2ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Whether launch controller keeps chunks loaded. This will cause issues if disabled.", true).getBoolean(true);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Mars has a problem loading it's configuration");
        }
        finally
        {
            GCVenus2ConfigManager.configuration.save();
            GCVenus2ConfigManager.loaded = true;
        }
    }
}
