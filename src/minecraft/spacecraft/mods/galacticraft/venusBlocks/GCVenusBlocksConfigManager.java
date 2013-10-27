package spacecraft.mods.galacticraft.venusBlocks;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVenusBlocksConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCVenusBlocksConfigManager(File file)
    {
        if (!GCVenusBlocksConfigManager.loaded)
        {
            GCVenusBlocksConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    //Rocket

    // DIMENSIONS

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
	public static int VenusPlateID;
	public static int EvolvedBlazeEggID;
	
    // ITEMS
	public static int SulferIngotID;
	public static int RedGemID;
	public static int CompressedSulferID;
	public static int CompressedRedGemID;
	public static int HeavyVenusPlateID;
	
    // ARMOR
    
    // TOOLS

    // ENTITIES
	
    // GUI

    // SCHEMATIC
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            GCVenusBlocksConfigManager.configuration.load();

	        GCVenusBlocksConfigManager.VenusGrassID = GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Grass ID", 6004).getInt(6004);	        
	        GCVenusBlocksConfigManager.VenusDirtID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Dirt ID", 6005).getInt(6005);			
			GCVenusBlocksConfigManager.VenusStoneID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Stone ID", 6006).getInt(6006);			
			GCVenusBlocksConfigManager.VenusCobblestoneID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 6007).getInt(6007);			
			GCVenusBlocksConfigManager.VenusRedGemBlockID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Red Gem Block ID", 6008).getInt(6008);			
			GCVenusBlocksConfigManager.VenusMeteorBlockID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Meteor Block ID", 6009).getInt(6009);			
			GCVenusBlocksConfigManager.VenusBrickID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Brick ID", 6010).getInt(6010);			
			GCVenusBlocksConfigManager.VenusSulferBlockID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Sulfer Block ID", 6011).getInt(6011);			
			GCVenusBlocksConfigManager.VenusRedGemOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Red Gem Ore ID", 6012).getInt(6012);			
			GCVenusBlocksConfigManager.VenusMeteorOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Meteor Ore ID", 6013).getInt(6013);			
			GCVenusBlocksConfigManager.VenusSulferOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Sulfer Ore ID", 6014).getInt(6014);
			GCVenusBlocksConfigManager.VenusIronOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Iron Ore ID", 6015).getInt(6015);
			GCVenusBlocksConfigManager.VenusCoalOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Coal Ore ID", 6016).getInt(6016);
			GCVenusBlocksConfigManager.VenusTinOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Tin Ore ID", 6017).getInt(6017);
			GCVenusBlocksConfigManager.VenusCopperOreID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Venus Copper Ore ID", 6018).getInt(6018);
			GCVenusBlocksConfigManager.VenusBasaltID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Basalt ID", 6019).getInt(6019);
			GCVenusBlocksConfigManager.VenusHalfBasaltID= GCVenusBlocksConfigManager.configuration.get("Blocks", "HalfSlab Basalt ID", 6020).getInt(6020);
			GCVenusBlocksConfigManager.EvolvedBlazeEggID= GCVenusBlocksConfigManager.configuration.get("Blocks", "Evolved Blaze Egg ID", 6021).getInt(6021);
			
			
			GCVenusBlocksConfigManager.SulferIngotID = GCVenusBlocksConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Sulfer Ingot ID", 6025).getInt(6025);
			GCVenusBlocksConfigManager.RedGemID = GCVenusBlocksConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Red Gem ID", 6026).getInt(6026);
			GCVenusBlocksConfigManager.CompressedSulferID = GCVenusBlocksConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Compressed Sulfer ID", 6027).getInt(6027);
			GCVenusBlocksConfigManager.CompressedRedGemID = GCVenusBlocksConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Compressed Red Gem ID", 6028).getInt(6028);
			GCVenusBlocksConfigManager.VenusPlateID = GCVenusBlocksConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Venus Plate ID", 6029).getInt(6029);
			GCVenusBlocksConfigManager.HeavyVenusPlateID= GCVenusBlocksConfigManager.configuration.get("Blocks", "HeavyVenusPlateID", 6050).getInt(6050);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft venusBlocks has a problem loading it's configuration");
        }
        finally
        {
        	GCVenusBlocksConfigManager.configuration.save();
        	GCVenusBlocksConfigManager.loaded = true;
        }
    }
}