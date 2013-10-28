package spacecraft.mods.galacticraft.mercury.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMercuryMapPlanet implements IMapObject
{
	@Override
	public float getPlanetSize() 
	{
		return 0.33191489361702127659574468085106F;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 0.38F;
	}

	@Override
	public float getPhaseShift() 
	{
		return 2350F;
	}

	@Override
	public float getStretchValue() 
	{
		return 11.86F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCMercurySlotRenderer();
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }
}
