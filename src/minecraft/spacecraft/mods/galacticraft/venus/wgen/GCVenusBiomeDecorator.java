package spacecraft.mods.galacticraft.venus.wgen;

import java.util.Random;

import spacecraft.mods.galacticraft.venus.GalacticraftVenus;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreWorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class GCVenusBiomeDecorator
{
    protected World worldObj;
    protected Random randomGenerator;

    protected int chunkX;
    protected int chunkZ;

    protected WorldGenerator dirtGen;
    protected WorldGenerator gemGen;
    protected WorldGenerator sulferGen;
    protected WorldGenerator meteorGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator coalGen;

    public GCVenusBiomeDecorator(BiomeGenBase par1BiomeGenBase)
    {
        this.gemGen = new GCCoreWorldGenMinableMeta(GalacticraftVenus.VenusGemOre.blockID, 4, 0, true, GalacticraftVenus.VenusGemOre.blockID, 4);
        this.sulferGen = new GCCoreWorldGenMinableMeta(GalacticraftVenus.VenusSulferOre.blockID, 4, 1, true, GalacticraftVenus.VenusSulferOre.blockID, 4);
        this.meteorGen = new GCCoreWorldGenMinableMeta(GalacticraftVenus.VenusMeteorOre.blockID, 3, 2, true, GalacticraftVenus.VenusMeteorOre.blockID, 4);
        this.dirtGen = new GCCoreWorldGenMinableMeta(GalacticraftVenus.VenusDirt.blockID, 32, 3, true, GalacticraftVenus.VenusDirt.blockID, 4); 
        this.ironGen = new GCCoreWorldGenMinableMeta(GalacticraftVenus.VenusIronOre.blockID, 32, 3, true, GalacticraftVenus.VenusIronOre.blockID, 4);  
        this.coalGen = new GCCoreWorldGenMinableMeta(GalacticraftVenus.VenusCoalOre.blockID, 32, 3, true, GalacticraftVenus.VenusCoalOre.blockID, 4);      
    }

    public void decorate(World worldObj, Random rand, int chunkX, int chunkZ)
    {
        if (this.worldObj != null)
        {
            throw new RuntimeException("Already decorating!!");
        }
        else
        {
            this.worldObj = worldObj;
            this.randomGenerator = rand;
            this.chunkX = chunkX;
            this.chunkZ = chunkZ;
            this.generateVenus();
            this.worldObj = null;
            this.randomGenerator = null;
        }
    }

    protected void genStandardOre1(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY)
    {
        for (int var5 = 0; var5 < amountPerChunk; ++var5)
        {
            final int var6 = this.chunkX + this.randomGenerator.nextInt(16);
            final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
            final int var8 = this.chunkZ + this.randomGenerator.nextInt(16);
            worldGenerator.generate(this.worldObj, this.randomGenerator, var6, var7, var8);
        }
    }

    protected void generateVenus()
    {
        MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
        this.genStandardOre1(20, this.dirtGen, 0, 200);
        this.genStandardOre1(26, this.gemGen, 0, 60);
        this.genStandardOre1(23, this.sulferGen, 0, 60);
        this.genStandardOre1(12, this.meteorGen, 0, 128);
        this.genStandardOre1(35, this.ironGen, 0, 128);
        this.genStandardOre1(36, this.coalGen, 0, 128);
        MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
    }
}