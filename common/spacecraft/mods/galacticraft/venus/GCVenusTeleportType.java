package spacecraft.mods.galacticraft.venus;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import micdoodle8.mods.galacticraft.api.vector.Vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.GCCorePlayerMP;

public class GCVenusTeleportType implements ITeleportType 
{

	@Override
	public boolean useParachute() 
	{
		return true;
	}

	@Override
	public Vector3 getPlayerSpawnLocation(WorldServer world, EntityPlayerMP player) 
	{
        if (player instanceof GCCorePlayerMP)
        {
            return new Vector3(((GCCorePlayerMP) player).getCoordsTeleportedFromX(), 250.0, ((GCCorePlayerMP) player).getCoordsTeleportedFromZ());
        }
		return null;
	}

	@Override
	public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) 
	{
        return new Vector3(entity.posX, 250, entity.posZ);
	}

	@Override
	public Vector3 getParaChestSpawnLocation(WorldServer world, EntityPlayerMP player, Random rand) 
	{
        return new Vector3(player.posX, 250, player.posZ);

	}

	@Override
	public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player) 
	{
	}

}
