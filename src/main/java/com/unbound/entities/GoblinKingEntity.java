package com.unbound.entities;

/*
the main class for the smaller goblins
this is where all of the mod functionality should be, including ai
 */

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

public class GoblinKingEntity extends Monster {

    public static final AnimationState idleAnimState = new AnimationState();
    private int idleAnimTimeout = 0;

    private static final ResourceKey<LootTable> LOOT  = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath("bossesunbound", "entities/goblin_default"));

    public GoblinKingEntity(EntityType<? extends Monster> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    // the method that grabs the correct loot table for any variant
    @Override
    public ResourceKey<LootTable> getDefaultLootTable() {
        return LOOT;
    }

    @Override
    protected void registerGoals(){
        // this is the ai for the entity
        // we are currently using a placeholder ai
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));

        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this)); // retaliate when hit
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // hunt players
    }

    public static AttributeSupplier.Builder createAttributes(){
        // these are just your simple entity attributes, which you can add many of. check the attributes class to see the full list
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60d)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ATTACK_SPEED)
                .add(Attributes.ATTACK_DAMAGE, 16D)
                .add(Attributes.ARMOR, 12D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .add(Attributes.FOLLOW_RANGE, 40D);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new BodyRotationControl(this);
    }

    /*
    ive temporarily disabled animations as we figure that out.
     */

//    private void setupAnimationStates() {
//        if(this.idleAnimTimeout <= 0) {
//            this.idleAnimTimeout = 80;
//            this.idleAnimTimeout.start(this.tickCount);
//        } else {
//            --this.idleAnimTimeout;
//        }
//    }

//    @Override
//    public void tick() {
//        super.tick();
//
//        if(this.level().isClientSide()) {
//            this.setupAnimationStates();
//        }
//    }
}
