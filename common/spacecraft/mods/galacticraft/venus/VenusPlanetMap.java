package spacecraft.mods.galacticraft.venus;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class VenusPlanetMap implements IMapObject 
{

	@Override
	public float getPlanetSize() 
	{
		return 2.0F;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 0.8F;
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
		return new CGVenusSlotRenderer();
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

}
