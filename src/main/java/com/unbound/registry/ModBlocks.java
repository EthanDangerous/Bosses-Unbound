package com.unbound.registry;

import com.unbound.BossesUnbound;
import com.unbound.block.GoblinTent;
import com.unbound.block.Tent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK,
            BossesUnbound.MOD_ID);

    public static final Supplier<Block> GOBLIN_TENT = registerBlock("goblin_tent",
            () -> new GoblinTent(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));

    public static final Supplier<Block> BLACK_TENT = registerBlock("black_tent",
            () -> new Tent(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> GRAY_TENT = registerBlock("gray_tent",
            () -> new Tent(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> LIGHT_GRAY_TENT = registerBlock("light_gray_tent",
            () -> new Tent(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> WHITE_TENT = registerBlock("white_tent",
            () -> new Tent(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> RED_TENT = registerBlock("red_tent",
            () -> new Tent(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> ORANGE_TENT = registerBlock("orange_tent",
            () -> new Tent(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> YELLOW_TENT = registerBlock("yellow_tent",
            () -> new Tent(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> LIME_TENT = registerBlock("lime_tent",
            () -> new Tent(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> GREEN_TENT = registerBlock("green_tent",
            () -> new Tent(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> CYAN_TENT = registerBlock("cyan_tent",
            () -> new Tent(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> LIGHT_BLUE_TENT = registerBlock("light_blue_tent",
            () -> new Tent(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> BLUE_TENT = registerBlock("blue_tent",
            () -> new Tent(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> PURPLE_TENT = registerBlock("purple_tent",
            () -> new Tent(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> MAGENTA_TENT = registerBlock("magenta_tent",
            () -> new Tent(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> PINK_TENT = registerBlock("pink_tent",
            () -> new Tent(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));
    public static final Supplier<Block> BROWN_TENT = registerBlock("brown_tent",
            () -> new Tent(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }

    private static <T extends Block> Supplier<T> registerBlock(final String name,
                                                               final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }


//    private static <T extends Block> Supplier<T> register(final String name, final Supplier<? extends T> block,
//                                                          Function<Supplier<T>, Supplier<? extends Item>> item) {
//        Supplier<T> obj = registerBlock(name, block);
//        ITEMS.register(name, item.apply(obj));
//        return obj;
//    }

}
