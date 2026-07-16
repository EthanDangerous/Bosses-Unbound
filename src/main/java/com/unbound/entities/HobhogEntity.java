package com.unbound.entities;

import com.cmdpro.databank.model.animation.DatabankAnimationReference;
import com.cmdpro.databank.model.animation.DatabankAnimationState;
import com.cmdpro.databank.model.animation.DatabankEntityAnimationState;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

public class HobhogEntity extends Hoglin {

    public DatabankAnimationState animState = new DatabankEntityAnimationState("idle", this)
            .addAnim(new DatabankAnimationReference("attack", (state, anim) -> {}, (state, anim) -> {}))
            .addAnim(new DatabankAnimationReference("walk", (state, anim) -> {}, (state, anim) -> {}))
            .addAnim(new DatabankAnimationReference("idle", (state, anim) -> {}, (state, anim) -> {}));

    private static final ResourceKey<LootTable> LOOT  = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath("bossesunbound", "entities/goblin_default"));

    public HobhogEntity(EntityType<? extends Hoglin> entityType, Level level) {
        super(entityType, level);
        animState.setLevel(level);

    }

    // the method that grabs the correct loot table for any variant
    @Override
    public ResourceKey<LootTable> getDefaultLootTable() {
        return LOOT;
    }

    //for now we ignore this because its just pulling from hoglin ai
//    @Override
//    protected void registerGoals(){
//        // this is the ai for the entity
//        // we are currently using a placeholder ai
//        this.goalSelector.addGoal(0, new FloatGoal(this));
//
//        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, true));
//
//        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0));
//        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
//        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
//
//        this.targetSelector.addGoal(1, new HurtByTargetGoal(this)); // retaliate when hit
//        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // hunt players
//    }

    public static AttributeSupplier.Builder createAttributes(){
        // these are just your simple entity attributes, which you can add many of. check the attributes class to see the full list
        return Hoglin.createAttributes();
//                .add(Attributes.MAX_HEALTH, 22d)
//                .add(Attributes.MOVEMENT_SPEED, 0.10D)
//                .add(Attributes.ATTACK_SPEED)
//                .add(Attributes.ATTACK_DAMAGE, 5D)
//                .add(Attributes.ARMOR, 0D)
//                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1D)
//                .add(Attributes.FOLLOW_RANGE, 25D);
    }

    @Override
    protected void setLevel(Level level) {
        super.setLevel(level);
        animState.setLevel(level);
    }

    @Override
    public boolean isConverting() {
        return false;
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new BodyRotationControl(this);
    }

}
