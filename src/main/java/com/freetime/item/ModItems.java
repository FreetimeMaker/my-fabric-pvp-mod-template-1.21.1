package com.freetime.item;

import com.freetime.MyFabricPVPMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLOOD_INGOT = registerItem("blood_ingot", new Item(new Item.Settings()));
    public static final Item RAW_BLOOD_INGOT = registerItem("raw_blood_ingot", new Item(new Item.Settings()));
    public static final Item PVP_MOD_GROUP_ICON = registerItem("pvp_mod_group_icon", new Item(new Item.Settings()));
    public static final Item BLOOD = registerItem("blood", new Item(new Item.Settings().food(ModFoodComponents.BLOOD)));
    public static final Item RAW_BLOOD = registerItem("raw_blood", new Item(new Item.Settings().food(ModFoodComponents.RAW_BLOOD)));
    public static final Item BLOOD_FUEL = registerItem("blood_fuel", new Item(new Item.Settings()));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MyFabricPVPMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyFabricPVPMod.LOGGER.info("Registering Mod Items for " + MyFabricPVPMod.MOD_ID);
    }
}
