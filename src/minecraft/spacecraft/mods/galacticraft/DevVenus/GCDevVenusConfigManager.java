package spacecraft.mods.galacticraft.DevVenus;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import micdoodle8.mods.galacticraft.moon.GCMoonConfigManager;
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

    // BLOCKS
	
    // ITEMS
	public static int spaceshipT3ID;
	public static int HeavyVenusPlateID;
	
    // ARMOR
    
    // TOOLS

    // ENTITIES
	public static int idEntitySpaceshipTier3;
	
    // GUI
    public static int idGuiRocketCraftingBenchT3;

    // SCHEMATIC
    public static int tier3SchematicID;
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            GCDevVenusConfigManager.configuration.load();

            
			GCDevVenusConfigManager.spaceshipT3ID= GCDevVenusConfigManager.configuration.get("Blocks", "T3RocketID", 6023).getInt(6023);
			GCDevVenusConfigManager.HeavyVenusPlateID= GCDevVenusConfigManager.configuration.get("Blocks", "HeavyVenusPlateID", 6050).getInt(6050);


			GCDevVenusConfigManager.idEntitySpaceshipTier3 = GCDevVenusConfigManager.configuration.get("Entities", "Entity Spaceship Tier 3", 273).getInt(273);
			
			
			GCDevVenusConfigManager.idGuiRocketCraftingBenchT3 = GCDevVenusConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 243).getInt(244);
			
			
			GCDevVenusConfigManager.tier3SchematicID = GCDevVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Tier 3 Schematic ID", 6030).getInt(6030);
        
        
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