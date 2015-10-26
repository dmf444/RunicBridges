package dmf444.RunicBridges.Core.Generation.WizardTower;

import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by David on 10/25/2015.
 */
public class EntityWizard extends EntityVillager{

    public EntityWizard(World world) {
        super(world, 4412);
    }

    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;

        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !player.isSneaking())
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(player);
                player.displayGUIMerchant(this, this.getCustomNameTag());
            }

            return true;
        }
        else
        {
            return super.interact(player);
        }
    }

    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);

    }

    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
    }
    public void useRecipe(MerchantRecipe merchRecipe)
    {
        super.useRecipe(merchRecipe);


    }

    public static class TradeHandler implements VillagerRegistry.IVillageTradeHandler {

        @Override
        public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList r, Random random) {
                r.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), null, null));

        }

        public final static TradeHandler INSTANCE = new TradeHandler();

    }
}
