package spacecraft.mods.galacticraft.devVenus;

import java.io.File;
import java.util.logging.Level;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCDevVenusConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCDevVenusConfigManager(File file)
    {
        if (!GCDevVenusConfigManager.loaded)
        {
            GCDevVenusConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS

    // BLOCKS
    public static int idBlockTreasureChestT3;

    // ITEMS
    public static int idItemSpaceshipTier3;
    public static int idItemKeyT3;

    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI
    public static int idGuiRocketCraftingBenchT3;

    // SCHEMATIC
    public static int idSchematicRocketT3;

    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            GCDevVenusConfigManager.configuration.load();

            GCDevVenusConfigManager.idBlockTreasureChestT3 = GCDevVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockTreasureChestT3", 5394).getInt(5394);
            
            GCDevVenusConfigManager.idItemSpaceshipTier3 = GCDevVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 7906).getInt(7906);
            GCDevVenusConfigManager.idItemKeyT3 = GCDevVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemKeyT3", 8916).getInt(8916);
        
            GCDevVenusConfigManager.idGuiRocketCraftingBenchT3 = GCDevVenusConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 343).getInt(343);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Dev-Venus has a problem loading it's configuration");
        }
        finally
        {
            GCDevVenusConfigManager.configuration.save();
            GCDevVenusConfigManager.loaded = true;
        }
    }
}
