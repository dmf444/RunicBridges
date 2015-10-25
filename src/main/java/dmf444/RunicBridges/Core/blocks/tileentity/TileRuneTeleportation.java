package dmf444.RunicBridges.Core.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by David on 2015-10-22.
 */
public class TileRuneTeleportation extends TileEntity{


    public int ticks, scot;

    public TileRuneTeleportation(){
        //DO NOTHING FOR THINGS
    }

    public void updateEntity(){
        ticks++;

        if(ticks > 20){
            scot++;
            ticks = 0;
        }
        if(scot > 3){
            scot = 0;
        }
    }
}
