package com.unbound.registry;

/*
this is for the registration of entities
any time we want to tell the game that we are adding a new mob, we would do so here
 */

import com.unbound.BossesUnbound;
import com.unbound.entities.GoblinEntity;
import com.unbound.entities.GoblinKingEntity;
import com.unbound.entities.HobgoblinEntity;
import com.unbound.entities.HobhogEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    // this is the creation of the new registry category as an object
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BossesUnbound.MOD_ID);

    public static final Supplier<EntityType<GoblinEntity>> GOBLIN =
            ENTITY_TYPES.register("goblin", () -> EntityType.Builder.of((EntityType.EntityFactory<GoblinEntity>) GoblinEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 0.9f).build(BossesUnbound.MOD_ID + ":" + "goblin"));



    // this is where each entity we want to register will be instantiated. we specify the entity type, as well as a couple of other details like hitbox
//    public static final Supplier<EntityType<GoblinEntity>> GOBLIN =
//            ENTITY_TYPES.register("goblin", () -> EntityType.Builder.of(GoblinEntity::new, MobCategory.CREATURE)
//                    .sized(0.7f, 0.9f).build("goblin"));

    public static final Supplier<EntityType<GoblinKingEntity>> GOBLIN_KING =
            ENTITY_TYPES.register("goblin_king", () -> EntityType.Builder.of(GoblinKingEntity::new, MobCategory.MONSTER)
                    .sized(1.3f, 2.2f).build("goblin_king"));

    public static final Supplier<EntityType<HobgoblinEntity>> HOBGOBLIN =
            ENTITY_TYPES.register("hobgoblin", () -> EntityType.Builder.of(HobgoblinEntity::new, MobCategory.MONSTER)
                    .sized(1.0f, 2.0f).build("hobgoblin"));

    public static final Supplier<EntityType<HobhogEntity>> HOBHOG =
            ENTITY_TYPES.register("hobhog", () -> EntityType.Builder.of(HobhogEntity::new, MobCategory.MONSTER)
                    .sized(1.4f, 1.4f).build("hobhog"));


    // all of the entities that are created above will be registered in one action with the method below
    public static void register(IEventBus bus){
        ENTITY_TYPES.register(bus);
    }
}
