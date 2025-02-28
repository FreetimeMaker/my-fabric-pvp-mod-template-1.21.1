package com.freetime.datagen;

import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOOD_BLOCK);
        addDrop(ModBlocks.RAW_BLOOD_BLOCK);
        addDrop(ModBlocks.BLOOD_ORE, oreDrops(ModBlocks.BLOOD_ORE, ModItems.RAW_BLOOD_INGOT));
        addDrop(ModBlocks.BLOOD_DEEPSLATE_ORE);
    }
}