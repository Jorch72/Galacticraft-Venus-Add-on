package spacecraft.mods.galacticraft.jupiterBlocks;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCJupiterBlocksConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCJupiterBlocksConfigManager(File file)
    {
        if (!GCJupiterBlocksConfigManager.loaded)
        {
            GCJupiterBlocksConfigManager.configuration = new Configuration(file);
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
            GCJupiterBlocksConfigManager.configuration.load();

//	        GCPlutoBlocksConfigManager.VenusGrassID = GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Grass ID", 7004).getInt(7004);	        
//	        GCPlutoBlocksConfigManager.VenusDirtID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Dirt ID", 7005).getInt(7005);			
//			GCPlutoBlocksConfigManager.VenusStoneID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Stone ID", 7006).getInt(7006);			
//			GCPlutoBlocksConfigManager.VenusCobblestoneID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 7007).getInt(7007);			
//			GCPlutoBlocksConfigManager.VenusRedGemOreID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Red Gem Ore ID", 7012).getInt(7012);			
//			GCPlutoBlocksConfigManager.VenusCoalOreID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Coal Ore ID", 7016).getInt(7016);
//			GCPlutoBlocksConfigManager.VenusTinOreID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Tin Ore ID", 7017).getInt(7017);
//			GCPlutoBlocksConfigManager.VenusCopperOreID= GCPlutoBlocksConfigManager.configuration.get("Blocks", "Venus Copper Ore ID", 7018).getInt(7018);
      }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft plutoBlocks has a problem loading it's configuration");
        }
        finally
        {
        	GCJupiterBlocksConfigManager.configuration.save();
        	GCJupiterBlocksConfigManager.loaded = true;
        }
    }
}