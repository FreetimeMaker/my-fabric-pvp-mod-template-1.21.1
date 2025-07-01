package com.freetime.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import com.freetime.MyFabricPVPMod;
import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BLOOD_INGOT_SMELTABLES = List.of(ModItems.RAW_BLOOD_INGOT, ModBlocks.BLOOD_ORE,
                ModBlocks.BLOOD_DEEPSLATE_ORE);

        offerSmelting(exporter, BLOOD_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.BLOOD_INGOT, 0.25f, 200, "my-fabric-pvp-mod-template");
        offerBlasting(exporter, BLOOD_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.BLOOD_INGOT, 0.25f, 100, "my-fabric-pvp-mod-template");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BLOOD_INGOT, RecipeCategory.DECORATIONS, ModBlocks.BLOOD_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_BLOOD_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_BLOOD_INGOT)
                .criterion(hasItem(ModItems.RAW_BLOOD_INGOT), conditionsFromItem(ModItems.RAW_BLOOD_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_BLOOD_INGOT, 9)
                .input(ModBlocks.RAW_BLOOD_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_BLOOD_BLOCK), conditionsFromItem(ModBlocks.RAW_BLOOD_BLOCK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_BLOOD_INGOT, 16)
            .input(ModBlocks.BLOOD_MAGIC_BLOCK)
            .criterion(hasItem(ModBlocks.BLOOD_MAGIC_BLOCK), conditionsFromItem(ModBlocks.BLOOD_MAGIC_BLOCK))
            .offerTo(exporter, Identifier.of(MyFabricPVPMod.MOD_ID, "raw_blood_ingot_from_blood_magic_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLOOD_INGOT, 16)
            .input(ModBlocks.BLOOD_MAGIC_BLOCK)
            .criterion(hasItem(ModBlocks.BLOOD_MAGIC_BLOCK), conditionsFromItem(ModBlocks.BLOOD_MAGIC_BLOCK))
            .offerTo(exporter, Identifier.of(MyFabricPVPMod.MOD_ID, "blood_ingot_from_blood_magic_block"));
    }
}
