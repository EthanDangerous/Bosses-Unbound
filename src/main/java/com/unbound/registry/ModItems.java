package com.unbound.registry;

import com.unbound.BossesUnbound;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BossesUnbound.MOD_ID);

    public static final DeferredItem<SwordItem> GOBLIN_DAGGER = ITEMS.register("goblin_dagger",
            () -> new SwordItem(Tiers.IRON, (new Item.Properties()).attributes(SwordItem.createAttributes(Tiers.IRON, 3, -2.4F))));
    public static final DeferredItem<AxeItem> GOBLIN_HATCHET = ITEMS.register("goblin_hatchet",
            () -> new AxeItem(Tiers.IRON, (new Item.Properties()).attributes(AxeItem.createAttributes(Tiers.IRON, 6.0F, -3.1F))));

    public static final DeferredItem<SpawnEggItem> GOBLIN_SPAWN_EGG = ITEMS.register("goblin_spawn_egg",
            () -> new SpawnEggItem(ModEntities.GOBLIN.get(), 0xffffff, 0xffffff, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> GOBLIN_KING_SPAWN_EGG = ITEMS.register("goblin_king_spawn_egg",
            () -> new SpawnEggItem(ModEntities.GOBLIN_KING.get(), 0xffffff, 0xffffff, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> HOBGOBLIN_SPAWN_EGG = ITEMS.register("hobgoblin_spawn_egg",
            () -> new SpawnEggItem(ModEntities.HOBGOBLIN.get(), 0xffffff, 0xffffff, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> HOBHOG_SPAWN_EGG = ITEMS.register("hobhog_spawn_egg",
            () -> new SpawnEggItem(ModEntities.HOBHOG.get(), 0xffffff, 0xffffff, new Item.Properties()));

    public static final DeferredItem<BlockItem> GOBLIN_TENT = ITEMS.registerSimpleBlockItem("goblin_tent", ModBlocks.GOBLIN_TENT);
    public static final DeferredItem<BlockItem> BLACK_TENT = ITEMS.registerSimpleBlockItem("black_tent", ModBlocks.BLACK_TENT);
    public static final DeferredItem<BlockItem> GRAY_TENT = ITEMS.registerSimpleBlockItem("gray_tent", ModBlocks.GRAY_TENT);
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TENT = ITEMS.registerSimpleBlockItem("light_gray_tent", ModBlocks.LIGHT_GRAY_TENT);
    public static final DeferredItem<BlockItem> WHITE_TENT = ITEMS.registerSimpleBlockItem("white_tent", ModBlocks.WHITE_TENT);
    public static final DeferredItem<BlockItem> RED_TENT = ITEMS.registerSimpleBlockItem("red_tent", ModBlocks.RED_TENT);
    public static final DeferredItem<BlockItem> ORANGE_TENT = ITEMS.registerSimpleBlockItem("orange_tent", ModBlocks.ORANGE_TENT);
    public static final DeferredItem<BlockItem> YELLOW_TENT = ITEMS.registerSimpleBlockItem("yellow_tent", ModBlocks.YELLOW_TENT);
    public static final DeferredItem<BlockItem> LIME_TENT = ITEMS.registerSimpleBlockItem("lime_tent", ModBlocks.LIME_TENT);
    public static final DeferredItem<BlockItem> GREEN_TENT = ITEMS.registerSimpleBlockItem("green_tent", ModBlocks.GREEN_TENT);
    public static final DeferredItem<BlockItem> CYAN_TENT = ITEMS.registerSimpleBlockItem("cyan_tent", ModBlocks.CYAN_TENT);
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TENT = ITEMS.registerSimpleBlockItem("light_blue_tent", ModBlocks.LIGHT_BLUE_TENT);
    public static final DeferredItem<BlockItem> BLUE_TENT = ITEMS.registerSimpleBlockItem("blue_tent", ModBlocks.BLUE_TENT);
    public static final DeferredItem<BlockItem> PURPLE_TENT = ITEMS.registerSimpleBlockItem("purple_tent", ModBlocks.PURPLE_TENT);
    public static final DeferredItem<BlockItem> MAGENTA_TENT = ITEMS.registerSimpleBlockItem("magenta_tent", ModBlocks.MAGENTA_TENT);
    public static final DeferredItem<BlockItem> PINK_TENT = ITEMS.registerSimpleBlockItem("pink_tent", ModBlocks.PINK_TENT);
    public static final DeferredItem<BlockItem> BROWN_TENT = ITEMS.registerSimpleBlockItem("brown_tent", ModBlocks.BROWN_TENT);


    public static final DeferredItem<MaceItem> KINGS_MACE = ITEMS.register("kings_mace",
            () -> new MaceItem(new Item.Properties().rarity(Rarity.RARE)));
//                    .attributes(MaceItem.createAttributes().withModifierAdded(MaceItem.BASE_ATTACK_SPEED_ID, -4, EquipmentSlotGroup.ANY))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}