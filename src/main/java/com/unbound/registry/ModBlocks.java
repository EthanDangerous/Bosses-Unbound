package com.unbound.registry;

import com.unbound.BossesUnbound;
import com.unbound.block.GoblinTent;
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

    public static final Supplier<Block> GOBLIN_TENT = registerBlock("arekko",
            () -> new GoblinTent(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion().noCollission()));

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
