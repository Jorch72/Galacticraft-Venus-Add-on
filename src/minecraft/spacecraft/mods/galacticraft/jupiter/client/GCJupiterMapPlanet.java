package spacecraft.mods.galacticraft.jupiter.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCJupiterMapPlanet implements IMapObject
{
	@Override
	public float getPlanetSize() 
	{
		return 0.53191489361702127659574468085106F;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 5.78F;
	}

	@Override
	public float getPhaseShift() 
	{
		return 2.8F;
	}

	@Override
	public float getStretchValue() 
	{
		return 11.86F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCJupiterSlotRenderer();
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }
}
