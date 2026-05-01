package com.unbound.renderers;

import com.cmdpro.databank.model.DatabankModel;
import com.cmdpro.databank.model.DatabankModels;
import com.cmdpro.databank.model.blockentity.DatabankBlockEntityModel;
import com.cmdpro.databank.model.blockentity.DatabankBlockEntityRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unbound.BossesUnbound;
import com.unbound.block.GoblinTent;
import com.unbound.blockentity.GoblinTentBlockEntity;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.Vec3;

public class GoblinTentRenderer extends DatabankBlockEntityRenderer<GoblinTentBlockEntity> {
    public GoblinTentRenderer(BlockEntityRendererProvider.Context rendererProvider) {
        super(new Model());
    }

    @Override
    public void render(GoblinTentBlockEntity goblinTent, float pPartialTick, PoseStack poseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        if (goblinTent.getBlockState().getValue(GoblinTent.PART) != BedPart.FOOT) {
            return;
        }

        Direction facing = goblinTent.getBlockState().getValue(GoblinTent.FACING);
        Vec3 rotateAround = new Vec3(0.5, 0.5, 0.5);

        if (facing.equals(Direction.NORTH)) {
            poseStack.rotateAround(Axis.YP.rotationDegrees(180), (float) rotateAround.x, (float) rotateAround.y, (float) rotateAround.z);
        }else if (facing.equals(Direction.SOUTH)) {
            poseStack.rotateAround(Axis.YP.rotationDegrees(0), (float) rotateAround.x, (float) rotateAround.y, (float) rotateAround.z);
        }else if (facing.equals(Direction.EAST)) {
            poseStack.rotateAround(Axis.YP.rotationDegrees(90), (float) rotateAround.x, (float) rotateAround.y, (float) rotateAround.z);
        }else if(facing.equals(Direction.WEST)) {
            poseStack.rotateAround(Axis.YP.rotationDegrees(-90), (float) rotateAround.x, (float) rotateAround.y, (float) rotateAround.z);
        }
        poseStack.translate(0, 0, 0.5);

        super.render(goblinTent, pPartialTick, poseStack, pBufferSource, pPackedLight, pPackedOverlay);
    }

    public static class Model extends DatabankBlockEntityModel<GoblinTentBlockEntity> {
        public DatabankModel model;
        public static AnimationDefinition animation;

        @Override
        public ResourceLocation getTextureLocation() {
            return BossesUnbound.locate("textures/block/goblin_tent.png");
        }

        @Override
        public void setupModelPose(GoblinTentBlockEntity pEntity, float partialTick) {
            pEntity.animState.updateAnimDefinitions(getModel());
            animate(pEntity.animState);
        }

        public DatabankModel getModel() {
            if (model == null) {
                model = DatabankModels.models.get(BossesUnbound.locate("tent"));
            }
            return model;
        }
    }
}
