package com.freetime.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import com.freetime.item.ModItems;
import com.freetime.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BLOOD_INGOT)
                .add(ModItems.RAW_BLOOD_INGOT)
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.APPLE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BLOOD_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BLOOD_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BLOOD_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BLOOD_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BLOOD_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BLOOD_HELMET)
                .add(ModItems.BLOOD_CHESTPLATE)
                .add(ModItems.BLOOD_LEGGINGS)
                .add(ModItems.BLOOD_BOOTS);
    }
}
