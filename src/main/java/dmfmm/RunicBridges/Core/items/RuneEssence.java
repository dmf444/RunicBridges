package dmfmm.RunicBridges.Core.items;

import dmfmm.RunicBridges.Core.Lib.ItemLib;
import dmfmm.RunicBridges.Core.Lib.ModInfo;
import dmfmm.RunicBridges.RunicBridges;
import net.minecraft.item.Item;

/**
 * Created by dmf444 on 10/4/2015.
 */
public class RuneEssence extends Item{

    public RuneEssence(){
        super();
        this.setCreativeTab(RunicBridges.tab);
        this.setUnlocalizedName(ItemLib.runeEssence);
        this.setTextureName(ModInfo.MODID + ":"+ ItemLib.runeEssence);
    }


}
