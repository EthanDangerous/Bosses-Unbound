package com.unbound.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.unbound.BossesUnbound;
import com.unbound.entities.GoblinKingEntity;
import com.unbound.entities.client.GoblinKingModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoblinKingRenderer extends MobRenderer<GoblinKingEntity, GoblinKingModel<GoblinKingEntity>> {

    public GoblinKingRenderer(EntityRendererProvider.Context context) {
        super(context, new GoblinKingModel<>(context.bakeLayer(GoblinKingModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinKingEntity goblinKingEntity) {
        return ResourceLocation.fromNamespaceAndPath(BossesUnbound.MODID, "textures/entity/goblin_king/goblin_king.png");
    }


    @Override
    public void render(GoblinKingEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(1f, 1f, 1f);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
