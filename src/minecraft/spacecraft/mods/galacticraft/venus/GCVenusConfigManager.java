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
	public static int VenusRedGemBlockID;
	public static int VenusMeteorBlockID;
	public static int VenusBrickID;
	public static int VenusSulferBlockID;
	public static int VenusRedGemOreID;
	public static int VenusMeteorOreID;
	public static int VenusSulferOreID;
	public static int VenusIronOreID;
	public static int VenusCoalOreID;
	public static int VenusTinOreID;
	public static int VenusCopperOreID;
	public static int VenusBasaltID;
	public static int VenusHalfBasaltID;
	public static int SpiderEggID;
	public static int gemWireID;
	public static int VenusPlateID;
	
    // ITEMS
	public static int SulferDustID;
	public static int SulferIngotID;
	public static int RedGemID;
	public static int CompressedSulferID;
	public static int CompressedRedGemID;
	
    // ARMOR
    
    // TOOLS

    // ENTITIES
	
    // GUI

    // SCHEMATIC
    
    // GENERAL
    public static boolean disableGemOreVenus;
    public static boolean disableSulferOreVenus;
    public static boolean disableMeteorOreVenus;
    public static boolean disableIronOreVenus;
    public static boolean disableCoalOreVenus;  
    public static boolean disableTinOreVenus;
    public static boolean disableCopperOreVenus;
  
    public static boolean generateOtherMods;
    public static boolean disableVenusVillageGen;

    private void setDefaultValues()
    {
        try
        {
            GCVenusConfigManager.configuration.load();

            GCVenusConfigManager.dimensionIDVenus = GCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -45).getInt(-45);            
            
            GCVenusConfigManager.TierLevel = GCVenusConfigManager.configuration.get("Rocket", "Tier Level", 2).getInt(2);
            
	        GCVenusConfigManager.VenusGrassID = GCVenusConfigManager.configuration.get("Blocks", "Venus Grass ID", 6004).getInt(6004);	        
	        GCVenusConfigManager.VenusDirtID= GCVenusConfigManager.configuration.get("Blocks", "Venus Dirt ID", 6005).getInt(6005);			
			GCVenusConfigManager.VenusStoneID= GCVenusConfigManager.configuration.get("Blocks", "Venus Stone ID", 6006).getInt(6006);			
			GCVenusConfigManager.VenusCobblestoneID= GCVenusConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 6007).getInt(6007);			
			GCVenusConfigManager.VenusRedGemBlockID= GCVenusConfigManager.configuration.get("Blocks", "Venus Red Gem Block ID", 6008).getInt(6008);			
			GCVenusConfigManager.VenusMeteorBlockID= GCVenusConfigManager.configuration.get("Blocks", "Venus Meteor Block ID", 6009).getInt(6009);			
			GCVenusConfigManager.VenusBrickID= GCVenusConfigManager.configuration.get("Blocks", "Venus Brick ID", 6010).getInt(6010);			
			GCVenusConfigManager.VenusSulferBlockID= GCVenusConfigManager.configuration.get("Blocks", "Venus Sulfer Block ID", 6011).getInt(6011);			
			GCVenusConfigManager.VenusRedGemOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Red Gem Ore ID", 6012).getInt(6012);			
			GCVenusConfigManager.VenusMeteorOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Meteor Ore ID", 6013).getInt(6013);			
			GCVenusConfigManager.VenusSulferOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Sulfer Ore ID", 6014).getInt(6014);
			GCVenusConfigManager.VenusIronOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Iron Ore ID", 6015).getInt(6015);
			GCVenusConfigManager.VenusCoalOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Coal Ore ID", 6016).getInt(6016);
			GCVenusConfigManager.VenusTinOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Tin Ore ID", 6017).getInt(6017);
			GCVenusConfigManager.VenusCopperOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Copper Ore ID", 6018).getInt(6018);
			GCVenusConfigManager.VenusBasaltID= GCVenusConfigManager.configuration.get("Blocks", "Basalt ID", 6019).getInt(6019);
			GCVenusConfigManager.VenusHalfBasaltID= GCVenusConfigManager.configuration.get("Blocks", "HalfSlab Basalt ID", 6020).getInt(6020);
			GCVenusConfigManager.SpiderEggID= GCVenusConfigManager.configuration.get("Blocks", "Spider Egg ID", 6021).getInt(6021);
			GCVenusConfigManager.gemWireID= GCVenusConfigManager.configuration.get("Blocks", "Gem Wire ID", 6022).getInt(6022);

			
			GCVenusConfigManager.SulferDustID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Sulfer Dust ID", 6024).getInt(6024);
			GCVenusConfigManager.SulferIngotID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Sulfer Ingot ID", 6025).getInt(6025);
			GCVenusConfigManager.RedGemID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Red Gem ID", 6026).getInt(6026);
			GCVenusConfigManager.CompressedSulferID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Compressed Sulfer ID", 6027).getInt(6027);
			GCVenusConfigManager.CompressedRedGemID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Compressed Red Gem ID", 6028).getInt(6028);
			GCVenusConfigManager.VenusPlateID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Venus Plate ID", 6029).getInt(6029);

			
			GCVenusConfigManager.disableGemOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Gem Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableMeteorOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Meteor Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableSulferOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Sulfer Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableIronOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Iron Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableCoalOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Coal Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableTinOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Tin Ore Gen on Venus", false).getBoolean(false);
			GCVenusConfigManager.disableCopperOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Copper Ore Gen on Venus", false).getBoolean(false);
            
			GCVenusConfigManager.generateOtherMods = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus", false).getBoolean(false);	
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