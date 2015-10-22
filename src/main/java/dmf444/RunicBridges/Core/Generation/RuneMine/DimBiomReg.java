package dmf444.RunicBridges.Core.Generation.RuneMine;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class DimBiomReg {

    public static BiomeGenBase biome;

    public static void registerBiome(){
        biome = new BiomeGenMine(137).setTemperatureRainfall(0.0f, 0.0f);
        BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.COLD);
    }
    public static void registerDimension(){
        DimensionManager.registerProviderType(-4412, WorldProviderRuneEssence.class, true);
        DimensionManager.registerDimension(-4412, -4412);
    }

}
