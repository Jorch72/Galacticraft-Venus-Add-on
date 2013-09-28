package spacecraft.mods.galacticraft.venus;

import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import net.minecraft.world.WorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class VenusPlanet implements IPlanet {

	@Override
	public String getName() 
	{
		return "Venus";
	}

	@Override
	public boolean isReachable() 
	{
		return true;
	}

	@Override
	public IMapObject getMapObject() 
	{
		return new VenusPlanetMap();
	}

	@Override
	public boolean addToList() 
	{
		return true;
	}

	@Override
	public boolean autoRegister() 
	{
		return true;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider() {
		return GCVenusWorldProvider.class;
	}

	@Override
	public int getDimensionID() {
		return GCVenusConfigManager.dimensionIDVenus;
	}

	@Override
	public IGalaxy getParentGalaxy() {
		return GalacticraftCore.galaxyMilkyWay;
	}

}
