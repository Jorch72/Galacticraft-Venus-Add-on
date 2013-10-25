package spacecraft.mods.galacticraft.venus.wgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import spacecraft.mods.galacticraft.venus.wgen.GCVenusBiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import cpw.mods.fml.common.FMLLog;

public class GCVenusMapGenVillage extends MapGenStructure
{
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { GCVenusBiomeGenBase.venusFlat });
    private final int terrainType;
    private static boolean initialized;

    static
    {
        try
        {
            GCVenusMapGenVillage.initiateStructures();
        }
        catch (Throwable e)
        {
            ;
        }
    }

    public static void initiateStructures() throws Throwable
    {
        if (!GCVenusMapGenVillage.initialized)
        {
            MapGenStructureIO.func_143034_b(GCVenusStructureVillageStart.class, "VenusVillage");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageField.class, "VenusField1");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageField2.class, "VenusField2");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageHouse.class, "VenusHouse");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageRoadPiece.class, "VenusRoadPiece");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillagePathGen.class, "VenusPath");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageTorch.class, "VenusTorch");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageStartPiece.class, "VenusWell");
            MapGenStructureIO.func_143031_a(GCVenusComponentVillageWoodHut.class, "VenusWoodHut");
        }

        GCVenusMapGenVillage.initialized = true;
    }

    public GCVenusMapGenVillage()
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
        FMLLog.info("Generating Venus Village at x" + par1 * 16 + " z" + par2 * 16);
        return new GCVenusStructureVillageStart(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

    @Override
    public String func_143025_a()
    {
        return "VenusVillage";
    }
}
