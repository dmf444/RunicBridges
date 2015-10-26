package dmf444.RunicBridges.Core.Generation.WizardTower;

import cpw.mods.fml.common.registry.VillagerRegistry;

/**
 * Created by David on 2015-10-26.
 */
public class WizardInit {

    public static void init(){
        //EntityRegistry.registerGlobalEntityID(EntityWizard.class, "teleportWizard",EntityRegistry.findGlobalUniqueEntityId());
        VillagerRegistry.instance().registerVillageTradeHandler(4412, EntityWizard.TradeHandler.INSTANCE);
    }
}
