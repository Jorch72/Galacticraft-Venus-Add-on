package spacecraft.mods.galacticraft.venus2.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCVenus2MapPlanet implements IMapObject
{
    @Override
    public float getPlanetSize()
    {
        return 0.53191489361702127659574468085106F;
    }

    @Override
    public float getDistanceFromCenter()
    {
        return 1.52F;
    }

    @Override
    public float getPhaseShift()
    {
        return 480.0F;
    }

    @Override
    public float getStretchValue()
    {
        return 1.88F;
    }

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCVenus2SlotRenderer();
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }
}
