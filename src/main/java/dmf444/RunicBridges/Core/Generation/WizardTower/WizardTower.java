package dmf444.RunicBridges.Core.Generation.WizardTower;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

/**
 * Created by David on 10/27/2015.
 */
public class WizardTower extends StructureVillagePieces.Village  {

    private int grdlvl =-1;
    private boolean hasdone = true;
    private int randomNum;
    private int randomNum1;

    public WizardTower(){}

    public WizardTower(StructureVillagePieces.Start villagePiece, int par2, Random par3Random, StructureBoundingBox sbb, int coordBaseMode) {
        super();
        this.coordBaseMode = coordBaseMode;
        this.boundingBox = sbb;
    }

    public static WizardTower buildComponent(StructureVillagePieces.Start villagePiece, List pieces, Random random, int x, int y, int z, int coordBaseMode, int p5) {
        StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 29, 40, 29, coordBaseMode);
        return canVillageGoDeeper(box) && StructureComponent.findIntersecting(pieces, box) == null ? new WizardTower(villagePiece, p5, random, box, coordBaseMode) : null;
    }


    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        if (this.grdlvl < 0) {
            this.grdlvl = this.getAverageGroundLevel(world, sbb);

            if (this.grdlvl < 0)
                return true;

            this.boundingBox.offset(0, this.grdlvl - this.boundingBox.maxY + 6, 0);//4
        }
        // int x = this.boundingBox.minX;
        // int y = this.boundingBox.minY;
        // int z = this.boundingBox.minZ;

        //Clear Everything
        fillWithBlocks(world, sbb, 0, 0, 0, 28, 40, 28, Blocks.air, Blocks.air, false);

        fillWithBlocks(world, sbb, 0, 0, 0, 28, 40, 20, Blocks.coal_block, Blocks.coal_block, false);
        return true;
    }
}
