package com.unbound.block;

import com.unbound.blockentity.GoblinTentBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class GoblinTent extends BedBlock implements EntityBlock {
    public GoblinTent(DyeColor color, Properties properties) {
        super(color, properties);
    }

    private static final VoxelShape BASE  = box(0, 0, 0, 16, 16, 16);
    private static final VoxelShape ROOF  = box(2, 16, 0, 14, 32, 16);
    private static final VoxelShape SHAPE = Shapes.or(BASE, ROOF);
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return SHAPE;
    }

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
