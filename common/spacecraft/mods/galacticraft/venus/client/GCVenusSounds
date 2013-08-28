package spacecraft.mods.galacticraft.venus.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GCVenusSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            event.manager.soundPoolSounds.addSound("music/space_cave_1.ogg", GalacticraftVenus.class.getResource("/micdoodle8/mods/galacticraft/venus/client/sounds/music/space_cave_1.wav"));    
            event.manager.soundPoolSounds.addSound("music/Venus_1.ogg", GalacticraftVenus.class.getResource("/micdoodle8/mods/galacticraft/venus/client/sounds/music/Venus_1.ogg")); 
 
        }
        catch (final Exception e)
        {
            System.err.println("[GCVenus] Failed to register one or more sounds.");
        }
    }
}
