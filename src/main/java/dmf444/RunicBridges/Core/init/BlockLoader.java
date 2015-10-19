package dmf444.RunicBridges.Core.init;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.RunicBridges.Core.Lib.BlockLib;
import dmf444.RunicBridges.Core.blocks.BlockRunicAltar;
import dmf444.RunicBridges.Core.blocks.RuneEssenceBlock;
import dmf444.RunicBridges.Core.blocks.tileentity.TileRunicAltar;
import net.minecraft.block.Block;

/**
 * Created by dmf444 on 9/27/2015.
 */
public class BlockLoader {

        public static Block runicAltar;
        public static Block runeBlock;


        public static boolean Register=false;

        public static void initiateBlocks() {
            runicAltar = new BlockRunicAltar().setBlockName(BlockLib.bRunicAltar);
            runeBlock = new RuneEssenceBlock().setBlockName(BlockLib.bRuneEssence);


            registerBlocks();
        }
        private static void registerBlocks() {
            if(!Register){
                GameRegistry.registerBlock(runicAltar, BlockLib.bRunicAltar);
                GameRegistry.registerBlock(runeBlock, BlockLib.bRuneEssence);


            }
            Register=true;
        }

        public static void initTileEntity() {
            GameRegistry.registerTileEntity(TileRunicAltar.class, BlockLib.bRunicAltar);

        }

}
