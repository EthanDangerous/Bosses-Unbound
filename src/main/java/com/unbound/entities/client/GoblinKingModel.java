package com.unbound.entities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.unbound.BossesUnbound;
import com.unbound.entities.GoblinKingEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GoblinKingModel<T extends GoblinKingEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BossesUnbound.MODID, "goblin_king"), "main");
    private final ModelPart root;
    private final ModelPart legs;
    private final ModelPart legLeft;
    private final ModelPart legRight;
    private final ModelPart body;
    private final ModelPart arms;
    private final ModelPart armLeft;
    private final ModelPart mace;
    private final ModelPart armRight;
    private final ModelPart torso;
    private final ModelPart belly;
    private final ModelPart head;
    private final ModelPart eyes;
    private final ModelPart eyebrows;
    private final ModelPart nose;
    private final ModelPart jaw;
    private final ModelPart earLeft;
    private final ModelPart earRight;

    public GoblinKingModel(ModelPart root) {
        this.root = root;
        this.legs = root.getChild("legs");
        this.legLeft = this.legs.getChild("legLeft");
        this.legRight = this.legs.getChild("legRight");
        this.body = root.getChild("body");
        this.arms = this.body.getChild("arms");
        this.armLeft = this.arms.getChild("armLeft");
        this.mace = this.armLeft.getChild("mace");
        this.armRight = this.arms.getChild("armRight");
        this.torso = this.body.getChild("torso");
        this.belly = this.torso.getChild("belly");
        this.head = this.body.getChild("head");
        this.eyes = this.head.getChild("eyes");
        this.eyebrows = this.head.getChild("eyebrows");
        this.nose = this.head.getChild("nose");
        this.jaw = this.head.getChild("jaw");
        this.earLeft = this.head.getChild("earLeft");
        this.earRight = this.head.getChild("earRight");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition;

//        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-0.5F, -5.0F, 1.0F));

//        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.5F, 21.0F, -1.0F));
        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));


        PartDefinition legLeft = legs.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(96, 100).addBox(-3.0F, 6.0F, -4.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(96, 29).addBox(-3.0F, 2.0F, -1.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(-0.01F))
                .texOffs(28, 83).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 0.0F, 0.0F));

        PartDefinition legRight = legs.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(96, 40).addBox(-3.0F, 2.0F, -1.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(-0.01F))
                .texOffs(28, 93).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 101).addBox(-3.0F, 6.0F, -4.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 0.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.3333F, 21.0F, -0.6667F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.1667F, -18.0F, -0.3333F));

        PartDefinition armLeft = arms.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(56, 65).addBox(-3.0F, -3.0F, -1.0F, 19.0F, 6.0F, 6.0F, new CubeDeformation(-0.01F))
                .texOffs(78, 100).addBox(8.0F, -3.0F, -1.0F, 2.0F, 7.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offset(8.5F, 0.0F, 0.0F));

        PartDefinition mace = armLeft.addOrReplaceChild("mace", CubeListBuilder.create().texOffs(38, 0).addBox(-1.5F, -1.5F, -4.7F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(74, 29).addBox(0.0F, -7.0F, -21.7F, 0.0F, 14.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -1.0F, -23.7F, 2.0F, 2.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, 1.7F));

        PartDefinition cube_r1 = mace.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(70, 12).addBox(-3.0F, -3.0F, -5.5F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -16.2F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = mace.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(56, 77).addBox(0.0F, -7.0F, -5.5F, 0.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -16.2F, 0.0F, 0.0F, 1.5708F));

        PartDefinition armRight = arms.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(70, 0).addBox(-16.0F, -3.0F, -1.0F, 19.0F, 6.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offset(-8.5F, 0.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 65).addBox(-8.5F, 0.0F, -4.0F, 17.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1667F, -21.0F, -0.3333F));

        PartDefinition belly = torso.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(0, 35).addBox(-10.5F, -7.0F, -8.0F, 21.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(78, 77).addBox(-4.0F, -9.0F, -2.0F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -13.0F, -2.0F, 9.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.3333F, -21.0F, 0.6667F));

        PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(74, 62).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, -5.5F, -1.5F));

        PartDefinition eyebrows = head.addOrReplaceChild("eyebrows", CubeListBuilder.create().texOffs(18, 103).addBox(-4.5F, -1.0F, -2.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.01F))
                .texOffs(54, 102).addBox(1.5F, -1.0F, -2.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, -7.0F, -0.5F));

        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(66, 102).addBox(-1.4F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(70, 29).addBox(-0.4F, 0.0F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4F, -5.0F, -2.0F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(74, 54).addBox(-6.0F, -2.0F, -4.0F, 11.0F, 3.0F, 5.0F, new CubeDeformation(0.01F))
                .texOffs(10, 99).addBox(2.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 0.0F));

        PartDefinition earLeft = head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(30, 103).addBox(0.0F, -1.0F, -1.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(101, 12).addBox(0.0F, -1.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -6.0F, 2.0F));

        PartDefinition earRight = head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(39, 112).addBox(-8.0F, -1.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(104, 16).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(-4.0F, -6.0F, 2.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(GoblinKingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(GoblinKingAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimState, GoblinKingAnimations.idle, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(poseStack, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
