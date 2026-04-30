package com.unbound.registry;

import com.cmdpro.databank.registry.BlockRegistry;
import com.unbound.BossesUnbound;
import com.unbound.blockentity.GoblinTentBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BossesUnbound.MOD_ID);

    public static final Supplier<BlockEntityType<GoblinTentBlockEntity>> GOBLIN_TENT =
            register("goblin_tent", () ->
                    BlockEntityType.Builder.of(GoblinTentBlockEntity::new,
                            ModBlocks.GOBLIN_TENT.get()).build(null));

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }

    private static <T extends BlockEntityType<?>> Supplier<T> register(final String name, final Supplier<T> blockentity) {
        return BLOCK_ENTITIES.register(name, blockentity);
    }
}
