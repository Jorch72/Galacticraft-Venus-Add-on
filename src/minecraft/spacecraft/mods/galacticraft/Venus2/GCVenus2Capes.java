package spacecraft.mods.galacticraft.Venus2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class GCVenus2Capes
{
    public static Map<String, String> capeMap = new HashMap<String, String>();

    public void init(FMLInitializationEvent event)
    {
        try
        {
            int timeout = 10000;
            URL capeListUrl = new URL("https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes.txt");
            URLConnection connection = capeListUrl.openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            
            String line;
            while ((line = reader.readLine()) != null)
            {
                if ((line.contains(":")))
                {
                    int splitLocation = line.indexOf(":");
                    String username = line.substring(0, splitLocation);
                    String capeUrl = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/" + line.substring(splitLocation + 1) + ".png";
                    GCVenus2Capes.capeMap.put(username, capeUrl);
                }
            }
        }
        catch (Exception e)
        {
            FMLLog.severe("Error while setting up Venus-2 donor capes");
            e.printStackTrace();
        }

    }
}
