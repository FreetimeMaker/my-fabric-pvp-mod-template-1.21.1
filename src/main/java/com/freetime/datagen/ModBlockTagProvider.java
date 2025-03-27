package com.freetime.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import com.freetime.block.ModBlocks;
import com.freetime.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLOOD_BLOCK)
                .add(ModBlocks.RAW_BLOOD_BLOCK)
                .add(ModBlocks.BLOOD_ORE)
                .add(ModBlocks.BLOOD_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOOD_DEEPSLATE_ORE, ModBlocks.BLOOD_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.BLOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.BLOOD_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.BLOOD_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_BLOOD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
