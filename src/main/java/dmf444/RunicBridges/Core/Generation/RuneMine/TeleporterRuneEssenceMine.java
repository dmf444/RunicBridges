package dmf444.RunicBridges.Core.Generation.RuneMine;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class TeleporterRuneEssenceMine extends Teleporter {

    private final WorldServer worldServerInstance;

    private final Random random;

    /** Stores successful portal placement locations for rapid lookup. */
    /** Stores successful portal placement locations for rapid lookup. */
    private final LongHashMap destinationCoordinateCache = new LongHashMap();

    /**
     * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
     * location.
     */
    @SuppressWarnings("rawtypes")
    private final List destinationCoordinateKeys = new ArrayList();



    public TeleporterRuneEssenceMine(WorldServer p_i1963_1_) {
        super(p_i1963_1_);
        this.worldServerInstance = p_i1963_1_;
        this.random = new Random(p_i1963_1_.getSeed());
    }

    @Override
    public void placeInPortal(Entity par1, double par2, double par4, double par6, float par7) {
        if (this.worldServerInstance.provider.dimensionId == -4412) {
            par1.setLocationAndAngles(0.0d, 18.0d, 0.0d, par1.rotationYaw, 0.0F);
            par1.motionX = par1.motionY = par1.motionZ = 0.0D;
        }
        else{
            EntityPlayer entityPlayer = (EntityPlayer)par1;

            ItemStack leaveToken = entityPlayer.inventory.getCurrentItem();
            NBTTagCompound position = leaveToken.getTagCompound();

            double x = (double)position.getInteger("X");
            double y = (double)position.getInteger("Y");
            double z = (double)position.getInteger("Z");
            entityPlayer.inventory.decrStackSize(entityPlayer.inventory.currentItem, leaveToken.stackSize);

            par1.setLocationAndAngles(x, y, z, par1.rotationYaw, 0.0F);
            par1.motionX = par1.motionY = par1.motionZ = 0.0D;

        }


    }

    @Override
    public boolean placeInExistingPortal(Entity p_77184_1_, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_) {
        placeInPortal(p_77184_1_, p_77184_2_, p_77184_4_, p_77184_6_, p_77184_8_);
        return true;
    }
}
