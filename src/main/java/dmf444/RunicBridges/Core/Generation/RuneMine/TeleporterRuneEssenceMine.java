package dmf444.RunicBridges.Core.Generation.RuneMine;

import net.minecraft.entity.Entity;
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

            par1.setLocationAndAngles(0.0d, 18.0d, 0.0d, par1.rotationYaw, 0.0F);
            par1.motionX = par1.motionY = par1.motionZ = 0.0D;

    }
}
