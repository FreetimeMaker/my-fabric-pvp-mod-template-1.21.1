package com.freetime.datagen;

import com.freetime.block.custom.BloodLampBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

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
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.BLOOD_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.BLOOD_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLOOD_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(BloodLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLOOD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLOOD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_FUEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PVP_MOD_GROUP_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOOD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOOD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOOD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOOD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOOD_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOOD_HAMMER, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLOOD_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLOOD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLOOD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLOOD_HELMET));
        itemModelGenerator.register(ModItems.BLOOD_HORSE_ARMOR, Models.GENERATED);
    }
}
