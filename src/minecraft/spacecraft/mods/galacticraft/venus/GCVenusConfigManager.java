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
	public static int sulferWireID;
	public static int Tier3LaunchPadID;
	
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
            
	        GCVenusConfigManager.VenusGrassID = GCVenusConfigManager.configuration.get("Blocks", "Venus Grass ID", 5004).getInt(5004);	        
	        GCVenusConfigManager.VenusDirtID= GCVenusConfigManager.configuration.get("Blocks", "Venus Dirt ID", 5005).getInt(5005);			
			GCVenusConfigManager.VenusStoneID= GCVenusConfigManager.configuration.get("Blocks", "Venus Stone ID", 5006).getInt(5006);			
			GCVenusConfigManager.VenusCobblestoneID= GCVenusConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 5007).getInt(5007);			
			GCVenusConfigManager.VenusRedGemBlockID= GCVenusConfigManager.configuration.get("Blocks", "Venus Red Gem Block ID", 5008).getInt(5008);			
			GCVenusConfigManager.VenusMeteorBlockID= GCVenusConfigManager.configuration.get("Blocks", "Venus Meteor Block ID", 5009).getInt(5009);			
			GCVenusConfigManager.VenusBrickID= GCVenusConfigManager.configuration.get("Blocks", "Venus Brick ID", 5010).getInt(5010);			
			GCVenusConfigManager.VenusSulferBlockID= GCVenusConfigManager.configuration.get("Blocks", "Venus Sulfer Block ID", 5011).getInt(5011);			
			GCVenusConfigManager.VenusRedGemOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Red Gem Ore ID", 5012).getInt(5012);			
			GCVenusConfigManager.VenusMeteorOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Meteor Ore ID", 5013).getInt(5013);			
			GCVenusConfigManager.VenusSulferOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Sulfer Ore ID", 5014).getInt(5014);
			GCVenusConfigManager.VenusIronOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Iron Ore ID", 5015).getInt(5015);
			GCVenusConfigManager.VenusCoalOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Coal Ore ID", 5016).getInt(5016);
			GCVenusConfigManager.VenusTinOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Tin Ore ID", 5017).getInt(5017);
			GCVenusConfigManager.VenusCopperOreID= GCVenusConfigManager.configuration.get("Blocks", "Venus Copper Ore ID", 5018).getInt(5018);
			GCVenusConfigManager.VenusBasaltID= GCVenusConfigManager.configuration.get("Blocks", "Basalt ID", 5019).getInt(5019);
			GCVenusConfigManager.VenusHalfBasaltID= GCVenusConfigManager.configuration.get("Blocks", "HalfSlab Basalt ID", 5020).getInt(5020);
			GCVenusConfigManager.SpiderEggID= GCVenusConfigManager.configuration.get("Blocks", "Spider Egg ID", 5021).getInt(5021);
			GCVenusConfigManager.gemWireID= GCVenusConfigManager.configuration.get("Blocks", "Gem Wire ID", 5022).getInt(5022);
			GCVenusConfigManager.sulferWireID= GCVenusConfigManager.configuration.get("Blocks", "Sulfer Wire ID", 5023).getInt(5023);
			GCVenusConfigManager.Tier3LaunchPadID= GCVenusConfigManager.configuration.get("Blocks", "Tier 3 Launch Pad ID", 5024).getInt(5024);
			
			
			GCVenusConfigManager.SulferDustID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Sulfer Dust ID", 5025).getInt(5025);
			GCVenusConfigManager.SulferIngotID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Sulfer Ingot ID", 5026).getInt(5026);
			GCVenusConfigManager.RedGemID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Red Gem ID", 5027).getInt(5027);
			GCVenusConfigManager.CompressedSulferID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Compressed Sulfer ID", 5028).getInt(5028);
			GCVenusConfigManager.CompressedRedGemID = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Compressed Red Gem ID", 5029).getInt(5029);
			
			
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