package spacecraft.mods.galacticraft.mercuryBlocks;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCMercuryBlocksConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCMercuryBlocksConfigManager(File file)
    {
        if (!GCMercuryBlocksConfigManager.loaded)
        {
            GCMercuryBlocksConfigManager.configuration = new Configuration(file);
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
	public static int VenusRedGemOreID;
	public static int VenusCoalOreID;
	public static int VenusTinOreID;
	public static int VenusCopperOreID;
	
    // ITEMS

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
            GCMercuryBlocksConfigManager.configuration.load();

	        GCMercuryBlocksConfigManager.VenusGrassID = GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Grass ID", 7004).getInt(7004);	        
	        GCMercuryBlocksConfigManager.VenusDirtID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Dirt ID", 7005).getInt(7005);			
			GCMercuryBlocksConfigManager.VenusStoneID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Stone ID", 7006).getInt(7006);			
			GCMercuryBlocksConfigManager.VenusCobblestoneID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 7007).getInt(7007);			
			GCMercuryBlocksConfigManager.VenusRedGemOreID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Red Gem Ore ID", 7012).getInt(7012);			
			GCMercuryBlocksConfigManager.VenusCoalOreID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Coal Ore ID", 7016).getInt(7016);
			GCMercuryBlocksConfigManager.VenusTinOreID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Tin Ore ID", 7017).getInt(7017);
			GCMercuryBlocksConfigManager.VenusCopperOreID= GCMercuryBlocksConfigManager.configuration.get("Blocks", "Venus Copper Ore ID", 7018).getInt(7018);
      }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft venusBlocks has a problem loading it's configuration");
        }
        finally
        {
        	GCMercuryBlocksConfigManager.configuration.save();
        	GCMercuryBlocksConfigManager.loaded = true;
        }
    }
}