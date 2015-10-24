package dmf444.RunicBridges.Core.blocks;

import dmf444.RunicBridges.Core.Lib.BlockLib;
import dmf444.RunicBridges.Core.blocks.tileentity.TileRuneTeleportation;
import dmf444.RunicBridges.Core.items.LeaveDimensionToken;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

/**
 * Created by David on 2015-10-22.
 */
public class RuneTeleportationBlock extends BlockContainer {

    public RuneTeleportationBlock(){
        super(Material.snow);
        this.setBlockUnbreakable();
        this.setBlockTextureName(BlockLib.bTeleport);
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if(entity instanceof EntityPlayer){


            if (!(((EntityPlayer) entity).inventory.getCurrentItem().getItem() instanceof LeaveDimensionToken)) {
                ((EntityPlayer) entity).addChatComponentMessage(new ChatComponentText("[Rune Mine Teleporter] Please hold your leave dimension token to leave."));
                return;
            }

            if(entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP){
                EntityPlayerMP thePlayer = (EntityPlayerMP) entity;

                MinecraftServer server = MinecraftServer.getServer();
                if(entity instanceof EntityPlayerMP){
                    if(thePlayer.timeUntilPortal > 0){
                        thePlayer.timeUntilPortal = 10;
                    }else if(thePlayer.dimension == -4412){
                        thePlayer.timeUntilPortal = 10;
                        thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new Teleporter(server.worldServerForDimension(0)));
                    }

                }

            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int side) {
        return new TileRuneTeleportation();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
        return false;
    }
}
