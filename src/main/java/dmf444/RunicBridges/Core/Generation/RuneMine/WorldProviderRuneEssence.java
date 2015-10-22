package dmf444.RunicBridges.Core.Generation.RuneMine;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class WorldProviderRuneEssence extends WorldProvider{

    @Override
    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(DimBiomReg.biome, 0f);
        this.dimensionId = -4412;

    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderRuneEssenceMine(worldObj, worldObj.getSeed());
    }

    @Override
    public String getDimensionName() {
        return "Rune Essence Mine";
    }
}
