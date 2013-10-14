package spacecraft.mods.galacticraft.devVenus;

import spacecraft.mods.galacticraft.devVenus.client.GCMarsMapPlanet;
import spacecraft.mods.galacticraft.devVenus.dimension.GCMarsWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCMarsPlanet implements IPlanet
{
    private final IMapObject mars = new GCMarsMapPlanet();

    @Override
    public String getName()
    {
        return "Mars";
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.mars;
    }

    @Override
    public boolean autoRegister()
    {
        return true;
    }

    @Override
    public boolean addToList()
    {
        return false;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return GCMarsWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCMarsConfigManager.dimensionIDMars;
    }
}
