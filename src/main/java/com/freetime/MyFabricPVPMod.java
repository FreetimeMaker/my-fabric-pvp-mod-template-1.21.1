package com.freetime;

import com.freetime.block.ModBlocks;
import com.freetime.creative_tab.ModItemGroups;
import com.freetime.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFabricPVPMod implements ModInitializer {
	public static final String MOD_ID = "my-fabric-pvp-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}