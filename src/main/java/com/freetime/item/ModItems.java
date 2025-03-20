package com.freetime.item;

import com.freetime.MyFabricPVPMod;
import com.freetime.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLOOD_INGOT = registerItem("blood_ingot", new Item(new Item.Settings()));
    public static final Item RAW_BLOOD_INGOT = registerItem("raw_blood_ingot", new Item(new Item.Settings()));
    public static final Item PVP_MOD_GROUP_ICON = registerItem("pvp_mod_group_icon", new Item(new Item.Settings()));
    public static final Item BLOOD = registerItem("blood", new Item(new Item.Settings().food(ModFoodComponents.BLOOD)));
    public static final Item RAW_BLOOD = registerItem("raw_blood", new Item(new Item.Settings().food(ModFoodComponents.RAW_BLOOD)));
    public static final Item BLOOD_FUEL = registerItem("blood_fuel", new Item(new Item.Settings()));
    public static final Item BLOOD_STICK = registerItem("blood_stick", new Item(new Item.Settings()) {
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true; // Makes the item appear enchanted
        }

        @Override
        public ItemStack getDefaultStack() {
            ItemStack stack = super.getDefaultStack();
            stack.addEnchantment((RegistryEntry<Enchantment>) Enchantments.KNOCKBACK, 1000000); // Adds level 2 Knockback
            return stack;
        }
    });

    public static final Item BLOOD_SWORD = registerItem("blood_sword",
            new SwordItem(ModToolMaterials.BLOOD_INGOT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BLOOD_INGOT, 3, -2.4f))));
    public static final Item BLOOD_PICKAXE = registerItem("blood_pickaxe",
            new PickaxeItem(ModToolMaterials.BLOOD_INGOT,  new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BLOOD_INGOT, 1, -2.8f))));
    public static final Item BLOOD_AXE = registerItem("blood_axe",
            new AxeItem(ModToolMaterials.BLOOD_INGOT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BLOOD_INGOT, 6, -3.2f))));
    public static final Item BLOOD_SHOVEL = registerItem("blood_shovel",
            new ShovelItem(ModToolMaterials.BLOOD_INGOT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BLOOD_INGOT, 1.5f, -3.0f))));
    public static final Item BLOOD_HOE = registerItem("blood_hoe",
            new HoeItem(ModToolMaterials.BLOOD_INGOT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BLOOD_INGOT, 0, -3f))));
    public static final Item BLOOD_HAMMER = registerItem("blood_hammer",
            new HammerItem(ModToolMaterials.BLOOD_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BLOOD_INGOT, 7, -3.4f))));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MyFabricPVPMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyFabricPVPMod.LOGGER.info("Registering Mod Items for " + MyFabricPVPMod.MOD_ID);
    }
}
