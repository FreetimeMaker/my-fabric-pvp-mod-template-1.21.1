package com.freetime.datagen;

import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryEntryLookup;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.loot.function.ApplyBonusLootFunction.oreDrops;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryEntryLookup<Block>> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    protected void generateBlockLootTables() {
        // Hier definieren wir die Loot-Tabellen für die Blöcke
        addDrop(ModBlocks.BLOOD_BLOCK); // Droppt sich selbst
        addDrop(ModBlocks.RAW_BLOOD_BLOCK); // Droppt sich selbst
        addDrop(ModBlocks.BLOOD_ORE, oreDrops(ModItems.RAW_BLOOD_INGOT)); // Drops mit Fortune
        addDrop(ModBlocks.BLOOD_DEEPSLATE_ORE, multipleOreDrops(ModItems.RAW_BLOOD_INGOT, 3, 7)); // Drops mit Fortune, 3-7
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return List.of(
                ModBlocks.BLOOD_BLOCK,
                ModBlocks.RAW_BLOOD_BLOCK,
                ModBlocks.BLOOD_ORE,
                ModBlocks.BLOOD_DEEPSLATE_ORE
        );
    }

    public LootTable.Builder multipleOreDrops(Item item, float minDrops, float maxDrops) {
        return LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1)) // 1x Drop
                        .entry(ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))) // Zufällige Menge
                                .apply(oreDrops(RegistryWrapper.getEntry(Enchantments.FORTUNE))))); // Mit Fortune-Verzauberung
    }

    /**
     * Diese Methode implementiert die abstrakte Methode 'method_10379' von FabricBlockLootTableProvider.
     * Du kannst hier zusätzlichen Code hinzufügen, wenn erforderlich.
     */
    @Override
    public void method_10379() {
        // Du kannst diese Methode leer lassen, wenn du keine zusätzliche Logik benötigst.
    }
}
