package com.unbound.event;

import com.unbound.BossesUnbound;
import com.unbound.registry.ModEntities;
import com.unbound.renderers.GoblinRenderer;
import com.unbound.entities.GoblinEntity;
import com.unbound.entities.GoblinKingEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = BossesUnbound.MODID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.GOBLIN.get(), GoblinRenderer::new);

//        event.registerLayerDefinition(GoblinModel.LAYER_LOCATION, GoblinModel::createBodyLayer);
//        event.registerLayerDefinition(GoblinKingModel.LAYER_LOCATION, GoblinKingModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOBLIN.get(), GoblinEntity.createAttributes().build());
        event.put(ModEntities.GOBLIN_KING.get(), GoblinKingEntity.createAttributes().build());
    }
}
