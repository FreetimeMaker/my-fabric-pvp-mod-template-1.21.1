package com.freetime;

import com.freetime.datagen.ModLootTableProvider;
import com.freetime.datagen.ModModelProvider;
import com.freetime.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MyFabricPVPModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
			FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

			pack.addProvider(ModLootTableProvider::new);
			pack.addProvider(ModModelProvider::new);
			pack.addProvider(ModRecipeProvider::new);
	}
}
