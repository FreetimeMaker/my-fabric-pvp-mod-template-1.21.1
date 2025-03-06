package com.freetime.datagen;

import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.loot.function.ApplyBonusLootFunction.oreDrops;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<?> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    protected void generateBlockLootTables() {
        addDrop(ModBlocks.BLOOD_BLOCK);
        addDrop(ModBlocks.RAW_BLOOD_BLOCK);
        add(ModBlocks.BLOOD_ORE, block -> LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1))
                        .entry(ItemEntry.builder(ModItems.RAW_BLOOD_INGOT)
                                .apply(oreDrops(Enchantments.FORTUNE)))));
        add(ModBlocks.BLOOD_DEEPSLATE_ORE, multipleOreDrops(ModItems.RAW_BLOOD_INGOT, 3, 7));
    }

    // 🔥 FIXED: Changed return type from Iterable<Block> to Set<Block>
    @Override
    protected Set<Block> getKnownBlocks() {
        return Set.of(
                ModBlocks.BLOOD_BLOCK,
                ModBlocks.RAW_BLOOD_BLOCK,
                ModBlocks.BLOOD_ORE,
                ModBlocks.BLOOD_DEEPSLATE_ORE
        );
    }

    public LootTable.Builder multipleOreDrops(Item item, float minDrops, float maxDrops) {
        return LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1))
                        .entry(ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                                .apply(oreDrops(Enchantments.FORTUNE))));
    }
}
