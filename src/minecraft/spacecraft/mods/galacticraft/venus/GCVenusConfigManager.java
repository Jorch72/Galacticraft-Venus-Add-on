package spacecraft.mods.galacticraft.venus;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import micdoodle8.mods.galacticraft.moon.GCMoonConfigManager;
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

    //Rocket
	public static int TierLevel;
	
    // DIMENSIONS
    public static int dimensionIDVenus;

    // BLOCKS
	public static int VenusGrassID;
	public static int VenusDirtID;
	public static int VenusStoneID;
	public static int VenusCobblestoneID;
	public static int VenusGemID;
	public static int VenusMeteorID;
	public static int VenusBrickID;
	public static int VenusSulferID;
	public static int VenusGemOreID;
	public static int VenusMeteorOreID;
	public static int VenusSulferOreID;

    // ITEMS

    // ARMOR
	
    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // GENERAL
  public static boolean disableGemOreVenus;
  public static boolean disableSulferOreVenus;
  public static boolean disableMeteorOreVenus;
  
  
  public static boolean generateOtherMods; //disables other mods from generating
  public static boolean disableVenusVillageGen;

    private void setDefaultValues()
    {
        try
        {
            GCVenusConfigManager.configuration.load();

            
            GCVenusConfigManager.dimensionIDVenus = GCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -45).getInt(-45);            
            
            GCVenusConfigManager.TierLevel = GCVenusConfigManager.configuration.get("Rocket", "Tier Level", 1).getInt(1);
	        	        
	        GCVenusConfigManager.VenusGrassID = GCVenusConfigManager.configuration.get("Blocks", "Venus Grass ID", 5004).getInt(5004);	        
	        GCVenusConfigManager.VenusDirtID= GCVenusConfigManager.configuration.get("Blocks", "Venus Dirt ID", 5005).getInt(5005);			
			GCVenusConfigManager.VenusStoneID= GCVenusConfigManager.configuration.get("Blocks", "Venus Stone ID", 5006).getInt(5006);			
			GCVenusConfigManager.VenusCobblestoneID= GCVenusConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 5007).getInt(5007);			
			GCVenusConfigManager.VenusGemID= GCVenusConfigManager.configuration.get("Blocks", "Venus Gem ID", 5008).getInt(5008);			
			GCVenusConfigManager.VenusMeteorID= GCVenusConfigManager.configuration.get("Blocks", "Venus Meteor ID", 5009).getInt(5009);			
			GCVenusConfigManager.VenusBrickID= GCVenusConfigManager.configuration.get("Blocks", "Venus Brick ID", 5010).getInt(5010);			
			GCVenusConfigManager.VenusSulferID= GCVenusConfigManager.configuration.get("Blocks", "Venus Sulfer ID", 5011).getInt(5011);			
			GCVenusConfigManager.VenusGemOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Gem Ore ID", 5012).getInt(5012);			
			GCVenusConfigManager.VenusMeteorOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Meteor Ore ID", 5013).getInt(5013);			
			GCVenusConfigManager.VenusSulferOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Sulfer Ore ID", 5014).getInt(5014);
			
			GCVenusConfigManager.generateOtherMods = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus", false).getBoolean(false);
       
			GCVenusConfigManager.disableGemOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Gem Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableMeteorOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Meteor Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableSulferOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Sulfer Ore Gen on Venus", false).getBoolean(false);
            
            GCVenusConfigManager.disableVenusVillageGen = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Venus Village Gen", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
        }
        finally
        {
        	GCVenusConfigManager.configuration.save();
        	GCVenusConfigManager.loaded = true;
        }
    }
}

