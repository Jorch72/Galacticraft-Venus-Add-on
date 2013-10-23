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
    public static int idItemSpaceshipTier3;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;
    public static int idItemSulferFuel;
    public static int idItemSulferCanister;
    public static int idItemVenusBattery;
    public static int idArmorJetpack;
    
    // ARMOR
    public static int idArmorGemHelmet;
    public static int idArmorGemChestplate;
    public static int idArmorGemLeggings;
    public static int idArmorGemBoots;

    // TOOLS
    public static int idToolGemSword;
    public static int idToolGemPickaxe;
    public static int idToolGemAxe;
    public static int idToolGemSpade;
    public static int idToolGemHoe;

    // ENTITIES
    public static int idEntitySpaceshipTier3;
    
    // GUI
    public static int idGuiRocketCraftingBenchT3;

    // SCHEMATIC
    public static int idSchematicRocketT3;
    public static int idSchematicCargoRocket;

    // ACHIEVEMENTS
    public static int idEntityEvolvedBlaze;
    public static int idEntityAlienVillager;
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
            GCVenusConfigManager.idItemSpaceshipTier3 = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 9906).getInt(9906);
            GCVenusConfigManager.idItemSchematicMars = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 9917).getInt(9917);
            GCVenusConfigManager.idItemRocketEngine = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngineMars", 9939).getInt(9939);
            GCVenusConfigManager.idItemSulferFuel = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSulferFuel", 9993).getInt(9993);
            GCVenusConfigManager.idItemSulferCanister = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSulferCanister", 9994).getInt(9994);
            GCVenusConfigManager.idItemVenusBattery = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 9995).getInt(9995);
            GCVenusConfigManager.idArmorJetpack = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorJetpack", 8995).getInt(8995);

            GCVenusConfigManager.idToolGemSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 9907).getInt(9907);
            GCVenusConfigManager.idToolGemPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 9908).getInt(9908);
            GCVenusConfigManager.idToolGemSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 9909).getInt(9909);
            GCVenusConfigManager.idToolGemHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 9910).getInt(9910);
            GCVenusConfigManager.idToolGemAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 9911).getInt(9911);

            GCVenusConfigManager.idArmorGemHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 9912).getInt(9912);
            GCVenusConfigManager.idArmorGemChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 9913).getInt(9913);
            GCVenusConfigManager.idArmorGemLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 9914).getInt(9914);
            GCVenusConfigManager.idArmorGemBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 9915).getInt(9915);

            GCVenusConfigManager.idEntitySpaceshipTier3 = GCVenusConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            GCVenusConfigManager.idGuiRocketCraftingBenchT3 = GCVenusConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);

            GCVenusConfigManager.idSchematicRocketT3 = GCVenusConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);

            GCVenusConfigManager.idEntityEvolvedBlaze = GCVenusConfigManager.configuration.get("Entities", "idEntityEvolvedBlaze", 257).getInt(257);
            GCVenusConfigManager.idEntityAlienVillager = GCVenusConfigManager.configuration.get("Entities", "idEntityAlienVillager", 258).getInt(258);
            GCVenusConfigManager.idEntityFlameling = GCVenusConfigManager.configuration.get("Entities", "idEntityFlameling", 260).getInt(260);

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
