package com.freetime.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.BLOOD_BLOCK);
        addDrop(ModBlocks.RAW_BLOOD_BLOCK);
        addDrop(ModBlocks.BLOOD_ORE, oreDrops(ModBlocks.BLOOD_ORE, ModItems.RAW_BLOOD_INGOT));
        addDrop(ModBlocks.BLOOD_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.BLOOD_DEEPSLATE_ORE, ModItems.RAW_BLOOD_INGOT, 3, 7));
        addDrop(ModBlocks.BLOOD_STAIRS);
        addDrop(ModBlocks.BLOOD_SLAB, slabDrops(ModBlocks.BLOOD_SLAB));
        addDrop(ModBlocks.BLOOD_BUTTON);
        addDrop(ModBlocks.BLOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.BLOOD_WALL);
        addDrop(ModBlocks.BLOOD_FENCE);
        addDrop(ModBlocks.BLOOD_FENCE_GATE);
        addDrop(ModBlocks.BLOOD_DOOR, doorDrops(ModBlocks.BLOOD_DOOR));
        addDrop(ModBlocks.BLOOD_TRAPDOOR);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
