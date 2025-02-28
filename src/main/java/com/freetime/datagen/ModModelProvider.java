package com.freetime.datagen;

import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOOD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLOOD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOOD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOOD_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLOOD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLOOD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_FUEL, Models.GENERATED);
    }
}