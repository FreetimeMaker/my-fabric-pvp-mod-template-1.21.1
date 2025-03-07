package com.freetime.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool bloodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOOD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLOOD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOOD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOOD_DEEPSLATE_ORE);
        bloodPool.stairs(ModBlocks.BLOOD_STAIRS);
        bloodPool.slab(ModBlocks.BLOOD_SLAB);
        bloodPool.button(ModBlocks.BLOOD_BUTTON);
        bloodPool.pressurePlate(ModBlocks.BLOOD_PRESSURE_PLATE);
        bloodPool.fence(ModBlocks.BLOOD_FENCE);
        bloodPool.fenceGate(ModBlocks.BLOOD_FENCE_GATE);
        bloodPool.wall(ModBlocks.BLOOD_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.BLOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BLOOD_TRAPDOOR);
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
