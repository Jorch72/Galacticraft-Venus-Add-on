package spacecraft.mods.galacticraft.venus;

import net.minecraftforge.common.DimensionManager;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import java.io.File;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid="GalacticraftVenus", name="Galacticraft Venus", version="0.0.8b", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class GalacticraftVenus 
  {
	    public static final IPlanet VenusPlanet = new VenusPlanet();
	    
	    public static CreativeTabs GalacticraftVenusTab;
	    
	    public static final String FILE_PATH = "/spacecraft/mods/galatcicraft/venus/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/galacticraftvenus/lang/";
	    public static final String CONFIG_FILE = "Spacecraft/Venus.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "galacticraftvenus";
	    public static String TEXTURE_PREFIX = GalacticraftVenus.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("GalacticraftVenus")
        public static GalacticraftVenus instance;
        
        @SidedProxy(clientSide="spacecraft.mods.galacticraft.venus.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.venus.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
            GalacticraftRegistry.registerTeleportType(GCVenusWorldProvider.class, new GCVenusTeleportType());
    		GalacticraftRegistry.registerCelestialBody(new VenusPlanet());
    		new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), GalacticraftVenus.CONFIG_FILE));
    		
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();

        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {

        }
}