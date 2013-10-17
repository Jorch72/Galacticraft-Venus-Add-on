package spacecraft.mods.galacticraft.Venus2;

import spacecraft.mods.galacticraft.Venus2.client.GCVenus2MapPlanet;
import spacecraft.mods.galacticraft.Venus2.dimension.GCVenus2WorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCVenus2Planet implements IPlanet
{
    private final IMapObject Venus2 = new GCVenus2MapPlanet();

    @Override
    public String getName()
    {
        return "Venus 2";
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
        return this.Venus2;
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
        return GCVenus2WorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCVenus2ConfigManager.dimensionIDVenus2;
    }
}
