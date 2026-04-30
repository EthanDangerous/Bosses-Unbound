package com.unbound.renderers;

import com.cmdpro.databank.model.DatabankModel;
import com.cmdpro.databank.model.DatabankModels;
import com.cmdpro.databank.model.entity.DatabankLivingEntityModel;
import com.cmdpro.databank.model.entity.DatabankLivingEntityRenderer;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.unbound.BossesUnbound;
import com.unbound.entities.GoblinVariant;
import com.unbound.entities.GoblinEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec2;

import java.util.Map;

public class GoblinRenderer extends DatabankLivingEntityRenderer<GoblinEntity> {
    public DefaultModel defaultModel;
    public TravelerModel travelerModel;
    public ArmoredModel armoredModel;

//    private static final Map<GoblinVariant, ResourceLocation> LOCATION_BY_VARIANT =
//            Util.make(Maps.newEnumMap(GoblinVariant.class), map -> {
//                map.put(GoblinVariant.DEFAULT,
//                        ResourceLocation.fromNamespaceAndPath(bossesunbound.MODID, "textures/entity/goblin/goblin_default.png"));
//                map.put(GoblinVariant.TRAVELER,
//                        ResourceLocation.fromNamespaceAndPath(bossesunbound.MODID, "textures/entity/goblin/goblin_traveler.png"));
//                map.put(GoblinVariant.ARMORED,
//                        ResourceLocation.fromNamespaceAndPath(bossesunbound.MODID, "textures/entity/goblin/goblin_armored.png"));
//            });
    private static final Map<GoblinVariant, String> LOCATION_BY_VARIANT =
        Util.make(Maps.newEnumMap(GoblinVariant.class), map -> {
            map.put(GoblinVariant.DEFAULT, "textures/entity/goblin/goblin_default.png");
            map.put(GoblinVariant.TRAVELER, "textures/entity/goblin/goblin_traveler.png");
            map.put(GoblinVariant.ARMORED, "textures/entity/goblin/goblin_armored.png");
        });

//        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));

    public GoblinRenderer(EntityRendererProvider.Context context) {
        super(context, new DefaultModel(), 0.25f);

        this.defaultModel = new DefaultModel();
        this.travelerModel = new TravelerModel();
        this.armoredModel = new ArmoredModel();
    }

    @Override
    public DatabankLivingEntityModel<GoblinEntity> getModel(GoblinEntity entity) {
        return defaultModel; // this is to be switched up by variant. you can do that i'm sure ~Esét
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinEntity entity) {
        return BossesUnbound.locate( LOCATION_BY_VARIANT.get(entity.getVariant()) );
    }

    @Override
    public void render(GoblinEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    public static class DefaultModel extends DatabankLivingEntityModel<GoblinEntity> {
        public DatabankModel model;

        public DatabankModel getModel() {
            if (model == null) {
                model = DatabankModels.models.get(BossesUnbound.locate("goblin"));
            }
            return model;
        }

        @Override
        public ResourceLocation getTextureLocation() {
            return BossesUnbound.locate("textures/entity/goblin_default.png");
        }

        @Override
        public void setupModelPose(GoblinEntity pEntity, float partialTick) {
            pEntity.animState.updateAnimDefinitions(getModel());
            animate(pEntity.animState);
            Vec2 rot = new Vec2(Mth.lerp(partialTick, pEntity.xRotO, pEntity.getXRot()), Mth.rotLerp(partialTick, pEntity.yHeadRotO, pEntity.yHeadRot));
            float bodyRot = Mth.rotLerp(partialTick, pEntity.yBodyRotO, pEntity.yBodyRot);
            modelPose.stringToPart.get("head").rotation.x = rot.x * (float) (Math.PI / 180.0);
            modelPose.stringToPart.get("head").rotation.y = (rot.y-bodyRot) * (float) (Math.PI / 180.0);
        }
    }

    public static class TravelerModel extends DefaultModel {
        @Override
        public ResourceLocation getTextureLocation() {
            return BossesUnbound.locate("textures/entity/goblin_traveler.png");
        }
    }

    public static class ArmoredModel extends DefaultModel {
        @Override
        public ResourceLocation getTextureLocation() {
            return BossesUnbound.locate("textures/entity/goblin_armored.png");
        }
    }
}
