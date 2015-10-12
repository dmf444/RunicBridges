package dmf444.RunicBridges;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import dmf444.RunicBridges.Core.CommonProxy;
import dmf444.RunicBridges.Core.Lib.ModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.RunicBridges.Core.Generation.RunicGenerationManager;
import dmf444.RunicBridges.Core.init.BlockLoader;
import dmf444.RunicBridges.Core.init.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = ModInfo.MODID, name=ModInfo.Mname, version = ModInfo.VERSION)
public class RunicBridges
{
    @Mod.Instance(value = "RunicBridges")
    public static RunicBridges instance;

    @SidedProxy(clientSide= ModInfo.Clientproxy, serverSide= ModInfo.Serverproxy)
    public static CommonProxy proxy;



    public static final CreativeTabs tab = CreativeTabs.tabMisc;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        BlockLoader.initiateBlocks();
        ItemLoader.initiateItems();
        GameRegistry.registerWorldGenerator(new RunicGenerationManager(), 0);

    }


    @Mod.EventHandler
    public void load(FMLInitializationEvent event){
        BlockLoader.initTileEntity();

        proxy.registerRenderers();
    }

}
