package micdoodle8.mods.galacticraft.venus;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;


public class GCVenusConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	// DIMENSIONS
	public static int dimensionIDVenus;
	
	// BLOCKS
	public static int idBlock;
	
	public GCVenusConfigManager(File file)
	{
		if (!loaded)
		{
			configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}
	
	private void setDefaultValues()
    {
		try
		{
	        configuration.load();
	        
	        dimensionIDVenus = 				configuration.get("Dimensions", 										"Venus Dimension ID",				-30)		.getInt(-26);
	    
	        idBlock = 						configuration.get(configuration.CATEGORY_BLOCK, 						"idBlockVenus", 					199)	.getInt(199);
		}
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
