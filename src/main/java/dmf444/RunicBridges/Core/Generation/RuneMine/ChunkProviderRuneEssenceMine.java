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

    private void makeWall(int x, int z, Chunk c, Block b){
        int l;
        for (int i = 8; i < 32; i++){
            l = i >> 4;
            ExtendedBlockStorage e = c.getBlockStorageArray()[l];

            if (e == null)
            {
                e = new ExtendedBlockStorage(i, !this.worldObj.provider.hasNoSky);
                c.getBlockStorageArray()[l] = e;
            }
            e.func_150818_a(x, i & 15, z, b);
            e.setExtBlockMetadata(x, i & 15, z, 0);
        }
    }

    @Override
    public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
        return true;
    }

    public void makeWall(int x, int z, Chunk c){
        makeWall(Math.abs(x) % 15, Math.abs(z) % 15, c, Blocks.stone);
    }

    public boolean insideChunk(int cx, int cy, int px, int pz){
        int c = (int)px / 16;
        int abc = (int)pz / 16;
        if (c == cx && abc == cy){
            return true;
        }
        return false;
    }

    @Override
    public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
        Chunk chunk = new Chunk(this.worldObj, p_73154_1_, p_73154_2_);

        int l;
        if (p_73154_1_ >= -4 && p_73154_1_ <= 4 && p_73154_2_ >= -4 && p_73154_2_ <= 4  ) {

            for (int wall1x = -17; wall1x < 19; wall1x++){
                for (int wall1y = -19; wall1y < 20; wall1y++){
                    if (insideChunk(p_73154_1_, p_73154_2_, wall1x, wall1y)){
                        this.makeWall(Math.abs(wall1x) % 15, Math.abs(wall1y) % 15, chunk);
                    }
                }
            }
            for (int wall1x = -16; wall1x < 18; wall1x++){
                for (int wall1y = -18; wall1y < 19; wall1y++){
                    if (insideChunk(p_73154_1_, p_73154_2_, wall1x, wall1y)){
                        this.makeWall(wall1x, wall1y, chunk, Blocks.air);
                    }
                }
            }

            for (int k = 0; k < 32; ++k) {
                Block block;
                if (k <= 8) {
                    block = Blocks.stone;
                }
                else if (k > 8 && k < 31){
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
            for (int k = 0; k < 32; ++k) {
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
