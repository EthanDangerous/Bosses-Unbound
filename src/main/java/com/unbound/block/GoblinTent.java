package com.unbound.block;

import com.unbound.blockentity.GoblinTentBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class GoblinTent extends BedBlock implements EntityBlock {
    public GoblinTent(DyeColor color, Properties properties) {
        super(color, properties);
    }

//    @Override
//    public float getDestroyProgress(BlockState state, Player player, BlockGetter world, BlockPos pos) {
//        if (!player.isShiftKeyDown()) {
//            return 0;
//        }
//        return super.getDestroyProgress(state, player, world, pos);
//    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GoblinTentBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
