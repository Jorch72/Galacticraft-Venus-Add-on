package spacecraft.mods.galacticraft.devVenus.tile;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySkeleton;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityDungeonSpawner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class GCMarsTileEntityDungeonSpawner extends GCCoreTileEntityDungeonSpawner
{
    public GCMarsTileEntityDungeonSpawner()
    {
//        super(GCMarsEntityCreeperBoss.class);
    }

    @Override
    public List<Class<? extends EntityLiving>> getDisabledCreatures()
    {
        List<Class<? extends EntityLiving>> list = new ArrayList<Class<? extends EntityLiving>>();
        list.add(GCCoreEntitySkeleton.class);
        list.add(GCCoreEntityZombie.class);
        list.add(GCCoreEntitySpider.class);
        return list;
    }

    @Override
    public void playSpawnSound(Entity entity)
    {
        this.worldObj.playSoundAtEntity(entity, "galacticraft.ambience.scaryscape", 9.0F, 1.4F);
    }
}
