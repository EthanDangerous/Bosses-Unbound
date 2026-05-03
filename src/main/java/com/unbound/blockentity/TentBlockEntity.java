package com.unbound.blockentity;

import com.cmdpro.databank.model.animation.DatabankAnimationReference;
import com.cmdpro.databank.model.animation.DatabankAnimationState;
import com.unbound.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TentBlockEntity extends BlockEntity {
    public DatabankAnimationState animState = new DatabankAnimationState("animation")
            .addAnim(new DatabankAnimationReference("animation", (state, anim) -> {}, (state, anim) -> {}));

    @Override
    public void setLevel(Level level) {
        super.setLevel(level);
        animState.setLevel(level);
    }

    public TentBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TENT.get(), pos, blockState);
    }

    protected TentBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
}
