package spacecraft.mods.galacticraft.venus.wgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import spacecraft.mods.galacticraft.venus.wgen.GCVenus2BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class GCVenus2MapGenVillage extends MapGenStructure
{
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { GCVenus2BiomeGenBase.venusFlat });
    private final int terrainType;

//    static
//    {
//        GCVenusMapGenVillage.initiateStructures();
//    }

//    public static void initiateStructures()
//    {
//        MapGenStructureIO.func_143034_b(GCVenusStructureVillageStart.class, "VenusVillage");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageField.class, "VenusField1");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageField2.class, "VenusField2");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageHouse.class, "VenusHouse");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageRoadPiece.class, "VenusRoadPiece");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillagePathGen.class, "VenusPath");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageTorch.class, "VenusTorch");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageStartPiece.class, "VenusWell");
//        MapGenStructureIO.func_143031_a(GCVenusComponentVillageWoodHut.class, "VenusWoodHut");
//    }

    public GCVenus2MapGenVillage()
    {
        this.terrainType = 0;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int i, int j)
    {
        final byte numChunks = 32;
        final byte offsetChunks = 8;
        final int oldi = i;
        final int oldj = j;

        if (i < 0)
        {
            i -= numChunks - 1;
        }

        if (j < 0)
        {
            j -= numChunks - 1;
        }

        int randX = i / numChunks;
        int randZ = j / numChunks;
        final Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
        randX *= numChunks;
        randZ *= numChunks;
        randX += var7.nextInt(numChunks - offsetChunks);
        randZ += var7.nextInt(numChunks - offsetChunks);

        if (oldi == randX && oldj == randZ)
        {
            return true;
        }

        return false;
    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2)
    {
        return new GCVenus2StructureVillageStart(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

//    @Override
//    public String func_143025_a()
//    {
//        return "VenusVillage";
//    }
}
