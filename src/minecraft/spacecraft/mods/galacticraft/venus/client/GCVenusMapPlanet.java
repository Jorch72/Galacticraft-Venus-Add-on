package spacecraft.mods.galacticraft.venus.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCVenusMapPlanet implements IMapObject
{
    @Override
    public float getPlanetSize()
    {
        return 0.53191489361702127659574468085106F;
    }

    @Override
    public float getDistanceFromCenter()
    {
        return 0.72F;
    }

    @Override
    public float getPhaseShift()
    {
        return 950F;
    }

    @Override
    public float getStretchValue()
    {
        return 1.5F;
    }

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCVenusSlotRenderer();
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }
}
