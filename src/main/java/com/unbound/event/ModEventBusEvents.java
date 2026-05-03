package com.unbound.event;

import com.unbound.BossesUnbound;
import com.unbound.registry.ModBlockEntities;
import com.unbound.registry.ModEntities;
import com.unbound.renderers.GoblinRenderer;
import com.unbound.entities.GoblinEntity;
import com.unbound.entities.GoblinKingEntity;
import com.unbound.renderers.GoblinTentRenderer;
import com.unbound.renderers.TentRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = BossesUnbound.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.GOBLIN.get(), GoblinRenderer::new);

//        event.registerLayerDefinition(GoblinModel.LAYER_LOCATION, GoblinModel::createBodyLayer);
//        event.registerLayerDefinition(GoblinKingModel.LAYER_LOCATION, GoblinKingModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.GOBLIN_TENT.get(), GoblinTentRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.TENT.get(), TentRenderer::new);
    }

        @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOBLIN.get(), GoblinEntity.createAttributes().build());
        event.put(ModEntities.GOBLIN_KING.get(), GoblinKingEntity.createAttributes().build());
    }
}
