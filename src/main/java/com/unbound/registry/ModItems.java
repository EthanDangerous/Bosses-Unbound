package com.unbound.registry;

import com.unbound.BossesUnbound;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BossesUnbound.MODID);

    public static final DeferredItem<SwordItem> GOBLIN_DAGGER = ITEMS.register("goblin_dagger",
            () -> new SwordItem(Tiers.IRON, (new Item.Properties()).attributes(SwordItem.createAttributes(Tiers.IRON, 3, -2.4F))));
    public static final DeferredItem<AxeItem> GOBLIN_HATCHET = ITEMS.register("goblin_hatchet",
            () -> new AxeItem(Tiers.IRON, (new Item.Properties()).attributes(AxeItem.createAttributes(Tiers.IRON, 6.0F, -3.1F))));

    public static final DeferredItem<SpawnEggItem> GOBLIN_SPAWN_EGG = ITEMS.register("goblin_spawn_egg",
            () -> new SpawnEggItem(ModEntities.GOBLIN.get(), 0x423a23, 0x3a4223, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> GOBLIN_KING_SPAWN_EGG = ITEMS.register("goblin_king_spawn_egg",
            () -> new SpawnEggItem(ModEntities.GOBLIN_KING.get(), 0x423a23, 0x3a4223, new Item.Properties()));



    public static final DeferredItem<MaceItem> KINGS_MACE = ITEMS.register("kings_mace",
            () -> new MaceItem(new Item.Properties().rarity(Rarity.RARE)));
//                    .attributes(MaceItem.createAttributes().withModifierAdded(MaceItem.BASE_ATTACK_SPEED_ID, -4, EquipmentSlotGroup.ANY))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}