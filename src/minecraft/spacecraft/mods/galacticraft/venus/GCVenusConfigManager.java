package spacecraft.mods.galacticraft.venus;

import java.io.File;
import java.util.logging.Level;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
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

    // DIMENSIONS
    public static int dimensionIDVenus;

    // BLOCKS
    public static int idBlockVenus;
    public static int idBlockBlazeEgg;
    public static int idBlockBasaltSlab;
	
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
    public static int idItemVenusBasic;
    public static int idItemVenusBattery;
    
    // ARMOR
    public static int idArmorSulferHelmet;
    public static int idArmorSulferChestplate;
    public static int idArmorSulferLeggings;
    public static int idArmorSulferBoots;

    // TOOLS
    public static int idToolSulferSword;
    public static int idToolSulferPickaxe;
    public static int idToolSulferAxe;
    public static int idToolSulferSpade;
    public static int idToolSulferHoe;

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS
    public static int idEntityEvolvedBlaze;
    public static int idEntityVenusianVillager;
    public static int idEntityFlameling;
    
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

            GCVenusConfigManager.dimensionIDVenus = GCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -46).getInt(-46);

            GCVenusConfigManager.idBlockVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus", 3390).getInt(3390);
            GCVenusConfigManager.idBlockBlazeEgg = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBlazeEgg", 3396).getInt(3396);
            GCVenusConfigManager.idBlockBasaltSlab = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBasaltSlab", 3700).getInt(3700);

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
			GCVenusConfigManager.EvolvedBlazeEggID= GCVenusConfigManager.configuration.get("Blocks", "Evolved Blaze Egg ID", 6021).getInt(6021);
            
            GCVenusConfigManager.idItemVenusBasic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 9905).getInt(9905);
            GCVenusConfigManager.idItemVenusBattery = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 9995).getInt(9995);

            GCVenusConfigManager.idToolSulferSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSword", 9907).getInt(9907);
            GCVenusConfigManager.idToolSulferPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferPickaxe", 9908).getInt(9908);
            GCVenusConfigManager.idToolSulferSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSpade", 9909).getInt(9909);
            GCVenusConfigManager.idToolSulferHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferHoe", 9910).getInt(9910);
            GCVenusConfigManager.idToolSulferAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferAxe", 9911).getInt(9911);

            GCVenusConfigManager.idArmorSulferHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferHelmet", 9912).getInt(9912);
            GCVenusConfigManager.idArmorSulferChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferChestplate", 9913).getInt(9913);
            GCVenusConfigManager.idArmorSulferLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferLeggings", 9914).getInt(9914);
            GCVenusConfigManager.idArmorSulferBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferBoots", 9915).getInt(9915);

            GCVenusConfigManager.idEntityEvolvedBlaze = GCVenusConfigManager.configuration.get("Entities", "idEntityEvolvedBlaze", 257).getInt(257);
            GCVenusConfigManager.idEntityVenusianVillager = GCVenusConfigManager.configuration.get("Entities", "idEntityVenusianVillager", 258).getInt(258);
            GCVenusConfigManager.idEntityFlameling = GCVenusConfigManager.configuration.get("Entities", "idEntityFlameling", 259).getInt(259);

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
