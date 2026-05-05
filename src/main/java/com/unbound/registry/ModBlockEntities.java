package com.unbound.registry;

import com.unbound.BossesUnbound;
import com.unbound.blockentity.GoblinTentBlockEntity;
import com.unbound.blockentity.TentBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final Supplier<BlockEntityType<TentBlockEntity>> TENT =
            register("tent", () ->
                    BlockEntityType.Builder.of(TentBlockEntity::new,
                            ModBlocks.BLACK_TENT.get(),
                            ModBlocks.GRAY_TENT.get(),
                            ModBlocks.LIGHT_GRAY_TENT.get(),
                            ModBlocks.WHITE_TENT.get(),
                            ModBlocks.RED_TENT.get(),
                            ModBlocks.ORANGE_TENT.get(),
                            ModBlocks.YELLOW_TENT.get(),
                            ModBlocks.LIME_TENT.get(),
                            ModBlocks.GREEN_TENT.get(),
                            ModBlocks.CYAN_TENT.get(),
                            ModBlocks.LIGHT_BLUE_TENT.get(),
                            ModBlocks.BLUE_TENT.get(),
                            ModBlocks.PURPLE_TENT.get(),
                            ModBlocks.MAGENTA_TENT.get(),
                            ModBlocks.PINK_TENT.get(),
                            ModBlocks.BROWN_TENT.get()
                    ).build(null));

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }

    private static <T extends BlockEntityType<?>> Supplier<T> register(final String name, final Supplier<T> blockentity) {
        return BLOCK_ENTITIES.register(name, blockentity);
    }
}
