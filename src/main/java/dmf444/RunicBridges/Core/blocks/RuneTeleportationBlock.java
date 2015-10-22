package dmf444.RunicBridges.Core.blocks;

import dmf444.RunicBridges.Core.Lib.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by David on 2015-10-22.
 */
public class RuneTeleportationBlock extends Block {

    public RuneTeleportationBlock(){
        super(Material.snow);
        this.setBlockUnbreakable();
        this.setBlockTextureName(BlockLib.bTeleport);
    }
}
