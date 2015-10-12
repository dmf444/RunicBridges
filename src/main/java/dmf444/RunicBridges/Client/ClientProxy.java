package dmf444.RunicBridges.Client;


import cpw.mods.fml.client.registry.ClientRegistry;
import dmf444.RunicBridges.Client.Render.RenderRunicAltar;
import dmf444.RunicBridges.Core.CommonProxy;
import dmf444.RunicBridges.Core.blocks.tileentity.TileRunicAltar;

public class ClientProxy extends CommonProxy {


    public void registerRenderers() {

        ClientRegistry.bindTileEntitySpecialRenderer(TileRunicAltar.class, new RenderRunicAltar());
    }


}
