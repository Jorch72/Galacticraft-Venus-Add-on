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
//          event.manager.soundPoolSounds.addSound("music/space_cave_1.ogg", GalacticraftVenus.class.getResource("/starcraft/mods/galacticraft/venus/client/sounds/music/space_cave_1.wav"));    
//          event.manager.soundPoolSounds.addSound("music/Venus_1.ogg", GalacticraftVenus.class.getResource("/starcraft/mods/galacticraft/venus/client/sounds/music/Venus_1.ogg")); 
			
//	    event.manager.soundPoolSounds.addSound("boss/boss_death.ogg", GalacticraftVenus.class.getResource("/starcraft/mods/galacticraft/venus/client/sounds/music/boss_death.wav"));    
//          event.manager.soundPoolSounds.addSound("boss/boss_spawn.ogg", GalacticraftVenus.class.getResource("/micdoodle8/mods/galacticraft/venus/client/sounds/music/boss_spawn.ogg")); 
			
//	    event.manager.soundPoolSounds.addSound("volcano/eruption/volcano_large.ogg", GalacticraftVenus.class.getResource("/starcraft/mods/galacticraft/venus/client/sounds/volcano/eruption/volcano_large.wav"));    
//          event.manager.soundPoolSounds.addSound("volcano/eruption/volcano_medium.ogg", GalacticraftVenus.class.getResource("/starcraft/mods/galacticraft/venus/client/sounds/volcano/eruption/volcano_medium.ogg")); 
//	    event.manager.soundPoolSounds.addSound("volcano/eruption/volcano_small.ogg", GalacticraftVenus.class.getResource("/starcraft/mods/galacticraft/venus/client/sounds/volcano/eruption/volcano_small.ogg")); 
 
        }
        catch (final Exception e)
        {
            System.err.println("[GCVenus] Failed to register one or more sounds.");
        }
    }
}
