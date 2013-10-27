package spacecraft.mods.galacticraft.spacecraftBlocks;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SpacecraftBlocksConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public SpacecraftBlocksConfigManager(File file)
    {
        if (!SpacecraftBlocksConfigManager.loaded)
        {
            SpacecraftBlocksConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    //Rocket

    // DIMENSIONS

    // BLOCKS
    public static int idVenusGrass;
    public static int idVenusDirt;
    public static int idVenusStone;
    public static int idVenusCobblestone;
    public static int idVenusRedGemBlock;
    public static int idVenusMeteorBlock;
    public static int idVenusBrick;
    public static int idVenusSulferBlock;
    public static int idVenusRedGemOre;
    public static int idVenusMeteorOre;
    public static int idVenusSulferOre;
    public static int idVenusIronOre;
    public static int idVenusCoalOre;
    public static int idVenusTinOre;
    public static int idVenusCopperOre;
    public static int idVenusBasalt;
    public static int idVenusHalfBasalt;
    public static int idEvolvedBlazeEgg;
    				
    public static int idPlutoGrass;
    public static int idPlutoDirt;
    public static int idPlutoStone;
    public static int idPlutoCobblestone;
    public static int idPlutoBrick;
    				
    public static int idMercuryGrass;
    public static int idMercuryDirt;
    public static int idMercuryStone;
    public static int idMercuryCobblestone;
    public static int idMercuryBrick;
    public static int idMercuryRedGemOre;
    public static int idMercuryCoalOre;
    public static int idMercuryTinOre;
    public static int idMercuryCopperOre;
    				
    public static int idJupiterLightGas;
    public static int idJupiterMediumGas;
    public static int idJupiterHeavyGas;


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
            SpacecraftBlocksConfigManager.configuration.load();

//	        SpacecraftBlocksConfigManager.VenusGrassID = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Grass ID", 7004).getInt(7004);	        

        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Spacecraft Blocks has a problem loading it's configuration");
        }
        finally
        {
        	SpacecraftBlocksConfigManager.configuration.save();
        	SpacecraftBlocksConfigManager.loaded = true;
        }
    }
}