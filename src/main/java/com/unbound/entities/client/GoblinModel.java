//package com.unbound.entities.client;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import com.unbound.bossesunbound;
//import com.unbound.entities.GoblinEntity;
//import net.minecraft.client.model.ArmedModel;
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.HierarchicalModel;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.PartPose;
//import net.minecraft.client.model.geom.builders.*;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.Mth;
//import net.minecraft.world.entity.HumanoidArm;
//
//import javax.swing.text.html.parser.Entity;
//
//public class GoblinModel<T extends GoblinEntity> extends HierarchicalModel<T> implements ArmedModel {
//    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(bossesunbound.MODID, "goblin"), "main");
//    private final ModelPart goblin;
//    private final ModelPart body;
//    private final ModelPart torso;
//    private final ModelPart head;
//    private final ModelPart helmet;
//    private final ModelPart left_eye;
//    private final ModelPart right_eye;
//    private final ModelPart nose;
//    private final ModelPart right_ear;
//    private final ModelPart left_ear;
//    private final ModelPart left_arm;
//    private final ModelPart right_arm;
//    private final ModelPart left_leg;
//    private final ModelPart right_leg;
//
//    public GoblinModel(ModelPart root) {
//        this.goblin = root.getChild("goblin");
//        this.body = this.goblin.getChild("body");
//        this.torso = this.body.getChild("torso");
//        this.head = this.torso.getChild("head");
//        this.helmet = this.head.getChild("helmet");
//        this.left_eye = this.head.getChild("left_eye");
//        this.right_eye = this.head.getChild("right_eye");
//        this.nose = this.head.getChild("nose");
//        this.right_ear = this.head.getChild("right_ear");
//        this.left_ear = this.head.getChild("left_ear");
//        this.left_arm = this.torso.getChild("left_arm");
//        this.right_arm = this.torso.getChild("right_arm");
//        this.left_leg = this.body.getChild("left_leg");
//        this.right_leg = this.body.getChild("right_leg");
//    }
//
//    public static LayerDefinition createBodyLayer() {
//        MeshDefinition meshdefinition = new MeshDefinition();
//        PartDefinition partdefinition = meshdefinition.getRoot();
//
//        PartDefinition goblin = partdefinition.addOrReplaceChild("goblin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
//
//        PartDefinition body = goblin.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));
//
//        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
//                .texOffs(20, 25).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 1.0F, 0.0F));
//
//        PartDefinition cube_r1 = torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.25F))
//                .texOffs(0, 41).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.5F, -0.1745F, 0.0F, 0.0F));
//
//        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -7.0F, -4.5F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));
//
//        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(15, 40).addBox(-3.5F, -3.5F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offset(-0.5F, -3.5F, -1.5F));
//
//        PartDefinition left_eye = head.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(28, 23).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, -4.51F));
//
//        PartDefinition right_eye = head.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(28, 23).mirror().addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -2.0F, -4.51F));
//
//        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -3.5F));
//
//        PartDefinition cube_r2 = nose.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 33).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
//
//        PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-4.0F, -2.0F, -0.5F));
//
//        PartDefinition cube_r3 = right_ear.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 12).mirror().addBox(-6.0F, -4.0F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));
//
//        PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(4.0F, -2.0F, -0.5F));
//
//        PartDefinition cube_r4 = left_ear.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 12).addBox(-1.0F, -4.0F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
//
//        PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(20, 33).addBox(0.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
//                .texOffs(30, 0).addBox(-0.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(3.0F, -2.5F, 0.0F));
//
//        PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(20, 33).mirror().addBox(-2.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//                .texOffs(30, 0).mirror().addBox(-2.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(-3.0F, -2.5F, 0.0F));
//
//        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.0F, 0.0F));
//
//        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 2.0F, 0.0F));
//
//        return LayerDefinition.create(meshdefinition, 64, 64);
//    }
//
//    @Override
//    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
//        goblin.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
//    }
//
//    @Override
//    public ModelPart root() {
//        return this.goblin;
//    }
//
//    @Override
//    public void setupAnim(GoblinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//        //resets the model position before an animation to ensure the animation doesnt break
//        this.root().getAllParts().forEach(ModelPart::resetPose);
//        //rotate head method so it can look at the player
//        this.applyHeadRotation(netHeadYaw, headPitch);
//
//        this.animateWalk(GoblinAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
//        this.animate(entity.idleAnimState, GoblinAnimations.idle, ageInTicks, 1f);
//    }
//
//    private void applyHeadRotation(float headYaw, float headPitch) {
//        headYaw = Mth.clamp(headYaw, -30f, 30f);
//        headPitch = Mth.clamp(headPitch, -25f, 45);
//
//        this.head.yRot = headYaw * ((float)Math.PI / 180f);
//        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
//    }
//
//    public ModelPart getArm(boolean right) {
//        return right ? this.right_arm : this.left_arm;
//    }
//
//    public ModelPart getArm(net.minecraft.world.entity.HumanoidArm arm) {
//        return arm == net.minecraft.world.entity.HumanoidArm.RIGHT
//                ? this.right_arm
//                : this.left_arm;
//    }
//
//    @Override
//    public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
//        this.root().translateAndRotate(poseStack);
//        this.body.translateAndRotate(poseStack);
//        this.torso.translateAndRotate(poseStack);
//
//        ModelPart modelpart = this.getArm(arm);
//        modelpart.translateAndRotate(poseStack);
//
//        poseStack.translate(-0.0D, -0.3D, -0.1D);
//    }}
