package com.unbound.datagen;

import com.unbound.BossesUnbound;
import com.unbound.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BossesUnbound.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.KINGS_MACE);
        handheldItem(ModItems.GOBLIN_HATCHET);
        handheldItem(ModItems.GOBLIN_DAGGER);
        basicItem(ModItems.GOBLIN_SPAWN_EGG.asItem());
        basicItem(ModItems.GOBLIN_KING_SPAWN_EGG.asItem());
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BossesUnbound.MODID,"item/" + item.getId().getPath()));
    }
}