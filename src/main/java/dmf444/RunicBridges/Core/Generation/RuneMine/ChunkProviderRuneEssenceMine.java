package dmf444.RunicBridges.Core.Generation.RuneMine;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

import java.util.List;
import java.util.Random;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class ChunkProviderRuneEssenceMine implements IChunkProvider{

    private World worldObj;
    private Random random;

    public ChunkProviderRuneEssenceMine(World p, long a){
        worldObj = p;
        random = new Random(a);
    }

    @Override
    public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
        return true;
    }

    @Override
    public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
        Chunk chunk = new Chunk(this.worldObj, p_73154_1_, p_73154_2_);

        int l;
        if (p_73154_1_ >= -4 && p_73154_1_ <= 4 && p_73154_2_ >= -4 && p_73154_2_ <= 4  ) {
            for (int k = 0; k < 64; ++k) {
                Block block;
                if (k <= 16) {
                    block = Blocks.stone;
                }
                else if (k > 16 && k < 63){
                    block = Blocks.air;
                }
                else {
                    block = Blocks.dirt;
                }
                l = k >> 4;
                ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[l];

                if (extendedblockstorage == null)
                {
                    extendedblockstorage = new ExtendedBlockStorage(k, !this.worldObj.provider.hasNoSky);
                    chunk.getBlockStorageArray()[l] = extendedblockstorage;
                }

                for (int i1 = 0; i1 < 16; ++i1)
                {
                    for (int j1 = 0; j1 < 16; ++j1)
                    {
                        extendedblockstorage.func_150818_a(i1, k & 15, j1, block);
                        extendedblockstorage.setExtBlockMetadata(i1, k & 15, j1, 0);
                    }
                }

            }
        }
        else {
            for (int k = 0; k < 64; ++k) {
                Block block  = Blocks.stone;

                l = k >> 4;
                ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[l];

                if (extendedblockstorage == null)
                {
                    extendedblockstorage = new ExtendedBlockStorage(k, !this.worldObj.provider.hasNoSky);
                    chunk.getBlockStorageArray()[l] = extendedblockstorage;
                }

                for (int i1 = 0; i1 < 16; ++i1)
                {
                    for (int j1 = 0; j1 < 16; ++j1)
                    {
                        extendedblockstorage.func_150818_a(i1, k & 15, j1, block);
                        extendedblockstorage.setExtBlockMetadata(i1, k & 15, j1, 0);
                    }
                }

            }
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
        return provideChunk(p_73158_1_, p_73158_2_);
    }

    @Override
    public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {

    }

    @Override
    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
        return true;
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String makeString() {
        return "RuneEssecenceMineLevelSource";
    }

    @Override
    public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(p_73155_2_, p_73155_4_);
        return biomegenbase.getSpawnableList(p_73155_1_);
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(int p_82695_1_, int p_82695_2_) {

    }

    @Override
    public void saveExtraData() {

    }
}
