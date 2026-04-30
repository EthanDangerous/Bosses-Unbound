package com.unbound.renderers;

import com.cmdpro.databank.model.DatabankModel;
import com.cmdpro.databank.model.DatabankModels;
import com.cmdpro.databank.model.blockentity.DatabankBlockEntityModel;
import com.cmdpro.databank.model.blockentity.DatabankBlockEntityRenderer;
import com.unbound.BossesUnbound;
import com.unbound.blockentity.GoblinTentBlockEntity;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GoblinTentRenderer extends DatabankBlockEntityRenderer<GoblinTentBlockEntity> {
    public GoblinTentRenderer(BlockEntityRendererProvider.Context rendererProvider) {
        super(new Model());
    }

    public static class Model extends DatabankBlockEntityModel<GoblinTentBlockEntity> {
        public DatabankModel model;
        public static AnimationDefinition idle;

        @Override
        public ResourceLocation getTextureLocation() {
            return BossesUnbound.locate("textures/block/dead_makutuin.png");
        }

        @Override
        public void setupModelPose(GoblinTentBlockEntity pEntity, float partialTick) {
            pEntity.animState.updateAnimDefinitions(getModel());
            animate(pEntity.animState);
        }

        public DatabankModel getModel() {
            if (model == null) {
                model = DatabankModels.models.get(BossesUnbound.locate("dead_makutuin"));
            }
            return model;
        }
    }
}
