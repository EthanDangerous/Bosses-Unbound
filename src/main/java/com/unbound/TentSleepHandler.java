package com.unbound;

import com.unbound.blockentity.TentBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;

@EventBusSubscriber(modid = "bossesunbound")
public class TentSleepHandler {
    @SubscribeEvent
    public static void onCanPlayerSleep(CanPlayerSleepEvent event) {
        BlockEntity be = event.getEntity().level().getBlockEntity(event.getPos());

        if (be instanceof TentBlockEntity) {
            event.setProblem(null);
        }
    }
}