package dmf444.RunicBridges.Core.blocks.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.RunicBridges.Core.init.ItemLoader;
import dmf444.RunicBridges.Core.items.RuneEssence;
import dmf444.RunicBridges.Core.utils.Pos;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;


public class TileRunicAltar extends TileEntity{

    private boolean display;
    private int runeType;
    public static boolean animate;
    public static int ticks=0;
    private static int Stacksize;
    private static Pos blockpos;

    public TileRunicAltar(){
        display = false;
        animate = false;
        int carl = new Random().nextInt((6-1)+1);
        if(carl < 0){
            carl = 0;
        }
        runeType = RuneType.getRandomType(carl).typerune;
    }

    public void displayTable(){
        display = true;
    }

    public boolean shouldDisplay(){
        return display;
    }

    public int getRuneType(){return runeType;}

    public boolean syncTo(World world, int x, int y, int z){
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileRunicAltar){
            TileRunicAltar tileRunicAltar = (TileRunicAltar) tile;
            this.runeType = tileRunicAltar.getRuneType();
            blockpos = new Pos(x, y, z);
            return true;
        }
        return false;
    }

    public void createRune(EntityPlayer player){
        ItemStack stack = player.inventory.getCurrentItem();
        if(stack.getItem() instanceof RuneEssence){
            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            Stacksize = stack.stackSize;
            animate = true;
        }
    }

    @Override
    public void updateEntity() {
        if(animate){
            ticks++;
            //System.out.println(ticks);
                if(ticks > 360){
                EntityItem item = new EntityItem(getWorldObj(), blockpos.getX(), blockpos.getY(), blockpos.getZ(), new ItemStack(Items.apple, Stacksize));//ItemStack(ItemLoader.rune, Stacksize, this.runeType)
                System.out.println("X:" + blockpos.getX() + " Y:" + blockpos.getY() + " Z:" + blockpos.getZ() + "STACK:" +Stacksize);
                if(!getWorldObj().isRemote){

                    getWorldObj().spawnEntityInWorld(item);
                }
                Stacksize = 0;
                ticks = 0;
                animate = false;
            }

        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);
        tagCompound.setBoolean("display", display);
        tagCompound.setInteger("rune", runeType);
        tagCompound.setInteger("bpX", blockpos.getX());
        tagCompound.setInteger("bpY", blockpos.getY());
        tagCompound.setInteger("bpZ", blockpos.getZ());
    }


    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        display = tagCompound.getBoolean("display");
        runeType = tagCompound.getInteger("rune");
        blockpos.setX(tagCompound.getInteger("bpX"));
        blockpos.setY(tagCompound.getInteger("bpY"));
        blockpos.setZ(tagCompound.getInteger("bpZ"));

    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound syncData = new NBTTagCompound();
        syncData.setBoolean("Meattype", display);
        syncData.setInteger("rune", runeType);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        display = pkt.func_148857_g().getBoolean("Meattype");
        runeType = pkt.func_148857_g().getInteger("rune");
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return this.INFINITE_EXTENT_AABB;
    }


    public enum RuneType{
        FIRE(0),
        AIR(1),
        MIND(2),
        WATER(3),
        EARTH(4),
        BODY(5),
        COSMIC(6),
        CHAOS(7),
        ASTRAL(8),
        NATURE(9),
        LAW(10),
        DEATH(11),
        BLOOD(12),
        SOUL(13);

        private int typerune;
        RuneType(int type){
            typerune = type;
        }

        public static RuneType getRandomType(int random){
            return RuneType.values()[random];
        }

        public static int getType(RuneType rune){
            return rune.typerune;
        }

        public static RuneType getRune(int type){
            return RuneType.values()[type+1];
        }
    }
}
