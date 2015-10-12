package dmf444.RunicBridges.Client.Render;

import dmf444.RunicBridges.Core.Lib.GuiLib;
import dmf444.RunicBridges.Core.blocks.tileentity.TileRunicAltar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by dmf444 on 9/27/2015.
 */
public class RenderRunicAltar extends TileEntitySpecialRenderer {

    private final ModelRunicAltar RAmodel = new ModelRunicAltar();
    private final ModelRunicAltar RAmodel2 = new ModelRunicAltar();

    public RenderRunicAltar(){
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        if(te instanceof TileRunicAltar) {
            if(((TileRunicAltar)te).shouldDisplay()) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);
                int i = te.getBlockMetadata();
                short short1 = 0;

                if (i == 2) {
                    short1 = 360;
                }
                if (i == 3) {
                    short1 = 180;
                }

                if (i == 4) {
                    short1 = 90; //-90
                }
                if (i == 5) {
                    short1 = -90; //90
                }
                GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);

                ResourceLocation textures = (GuiLib.TextureRA);
                Minecraft.getMinecraft().renderEngine.bindTexture(textures);

                    GL11.glPushMatrix();
                        GL11.glScalef(3F, 3F, 3F);
                        GL11.glTranslatef(0.23F, 0F, 0.1F);
                        this.RAmodel.render();
                    GL11.glPopMatrix();

                GL11.glPushMatrix();
                this.colorize(TileRunicAltar.RuneType.getRune(((TileRunicAltar) te).getRuneType()-1));
                Minecraft.getMinecraft().renderEngine.bindTexture(GuiLib.TextureRAc);
                GL11.glScalef(3F, 3F, 3F);
                GL11.glTranslatef(0.23F, 0F, 0.1F);
                this.RAmodel2.render();
                GL11.glPopMatrix();

                GL11.glPopMatrix();
            }
        }
    }


    private void colorize(TileRunicAltar.RuneType rune){
        switch (rune){
            case FIRE:
                GL11.glColor3f(255, 0, 0);
                break;
            case AIR:
                GL11.glColor3f(255, 255, 102);
                break;
            case MIND:
                GL11.glColor3f(204, 102, 0);
                break;
            case WATER:
                GL11.glColor3f(0, 0, 208);
                break;
            case EARTH:
                GL11.glColor3f(134, 128, 105);
                break;
            case BODY:
                GL11.glColor3f(255, 229, 204);
                break;
            default:
                GL11.glColor3f(0, 0, 0);
                break;
        }
    }

}
