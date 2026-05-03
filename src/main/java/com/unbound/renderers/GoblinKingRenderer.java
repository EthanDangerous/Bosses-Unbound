package com.unbound.renderers;

import com.cmdpro.databank.model.DatabankModel;
import com.cmdpro.databank.model.DatabankModels;
import com.cmdpro.databank.model.animation.DatabankAnimationState;
import com.cmdpro.databank.model.entity.DatabankLivingEntityModel;
import com.cmdpro.databank.model.entity.DatabankLivingEntityRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.unbound.BossesUnbound;
import com.unbound.entities.GoblinEntity;
import com.unbound.entities.GoblinKingEntity;
//import com.unbound.entities.client.GoblinKingModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec2;

public class GoblinKingRenderer extends DatabankLivingEntityRenderer<GoblinKingEntity> {

    public GoblinKingRenderer(EntityRendererProvider.Context context) {
        super(context, new Model(), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinKingEntity goblinKingEntity) {
        return ResourceLocation.fromNamespaceAndPath(BossesUnbound.MOD_ID, "textures/entity/goblin_king/goblin_king.png");
    }


    @Override
    public void render(GoblinKingEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(1f, 1f, 1f);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    public static class Model extends DatabankLivingEntityModel<GoblinKingEntity> {
        public DatabankModel model;

        public DatabankModel getModel() {
            if (model == null) {
                model = DatabankModels.models.get(BossesUnbound.locate("goblin_king"));
            }
            return model;
        }

        @Override
        public ResourceLocation getTextureLocation() {
            return BossesUnbound.locate("textures/entity/goblin_king/goblin_king.png");
        }

        @Override
        public void setupModelPose(GoblinKingEntity pEntity, float partialTick) {
            pEntity.animState.updateAnimDefinitions(getModel());
            DatabankAnimationState state = pEntity.animState;

            double speed = pEntity.getDeltaMovement().horizontalDistanceSqr();

            if (speed > 0) {
                state.setAnim("walk");
            } else {
                state.setAnim("idle");
            }

            animate(state);

            Vec2 rot = new Vec2(Mth.lerp(partialTick, pEntity.xRotO, pEntity.getXRot()), Mth.rotLerp(partialTick, pEntity.yHeadRotO, pEntity.yHeadRot));
            float bodyRot = Mth.rotLerp(partialTick, pEntity.yBodyRotO, pEntity.yBodyRot);
            modelPose.stringToPart.get("head").rotation.x = rot.x * (float) (Math.PI / 180.0);
            modelPose.stringToPart.get("head").rotation.y = (rot.y-bodyRot) * (float) (Math.PI / 180.0);
        }
    }

}
