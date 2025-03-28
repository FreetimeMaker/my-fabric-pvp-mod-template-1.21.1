package com.freetime;

import com.freetime.block.ModBlocks;
import com.freetime.component.ModDataComponentTypes;
import com.freetime.creative_tab.ModItemGroups;
import com.freetime.item.ModItems;
import com.freetime.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
		ModDataComponentTypes.registerDataComponentTypes();
		FuelRegistry.INSTANCE.add(ModItems.BLOOD_FUEL, 680);
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}