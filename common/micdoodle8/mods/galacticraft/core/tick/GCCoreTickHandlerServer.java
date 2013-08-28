package micdoodle8.mods.galacticraft.core.tick;

import java.util.EnumSet;
import micdoodle8.mods.galacticraft.api.world.IOrbitDimension;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class GCCoreTickHandlerServer implements ITickHandler
{
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        if (type.equals(EnumSet.of(TickType.WORLD)))
        {
            final WorldServer world = (WorldServer) tickData[0];

            if (world.provider instanceof IOrbitDimension)
            {
                final Object[] entityList = world.loadedEntityList.toArray();

                for (final Object o : entityList)
                {
                    if (o instanceof Entity)
                    {
                        final Entity e = (Entity) o;
                        final IOrbitDimension dimension = (IOrbitDimension) ((Entity) o).worldObj.provider;

                        if (e.posY <= dimension.getYCoordToTeleportToPlanet())
                        {
                            final Integer dim = WorldUtil.getProviderForName(dimension.getPlanetToOrbit()).dimensionId;

                            WorldUtil.transferEntityToDimension(e, dim, world, false);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.WORLD);
    }

    @Override
    public String getLabel()
    {
        return "Galacticraft Core Common";
    }
}
