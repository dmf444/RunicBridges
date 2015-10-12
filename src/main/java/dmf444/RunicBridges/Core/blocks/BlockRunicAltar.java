package dmf444.RunicBridges.Core.blocks;


import dmf444.RunicBridges.Core.utils.Pos;
import dmf444.RunicBridges.RunicBridges;
import dmf444.RunicBridges.Core.blocks.tileentity.TileRunicAltar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockRunicAltar extends BlockContainer{

    public BlockRunicAltar(){
        super(Material.rock);
        this.setCreativeTab(RunicBridges.tab);
    }


    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitx, float hity, float hitz){
        if(player.isSneaking()){
            return false;
        } else if(true){
            if(!world.isRemote) {
                TileRunicAltar te = (TileRunicAltar) world.getTileEntity(x, y, z);
                player.addChatComponentMessage(new ChatComponentText("Render: " + TileRunicAltar.RuneType.values()[te.getRuneType()]));
                te.createRune(player);
            }
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileRunicAltar();
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
