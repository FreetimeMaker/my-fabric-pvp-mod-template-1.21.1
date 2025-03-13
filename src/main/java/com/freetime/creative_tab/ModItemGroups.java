package com.freetime.creative_tab;

import com.freetime.MyFabricPVPMod;
import com.freetime.block.ModBlocks;
import com.freetime.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PVP_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MyFabricPVPMod.MOD_ID, "pvp_mod_group_icon"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PVP_MOD_GROUP_ICON))
                    .displayName(Text.translatable("itemgroup.my-fabric-pvp-mod.pvp_mod"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.BLOOD_INGOT);
                      entries.add(ModItems.RAW_BLOOD_INGOT);
                      entries.add(ModItems.BLOOD);
                      entries.add(ModItems.RAW_BLOOD);
                      entries.add(ModItems.BLOOD_FUEL);
                      entries.add(ModBlocks.BLOOD_BLOCK);
                      entries.add(ModBlocks.RAW_BLOOD_BLOCK);
                      entries.add(ModBlocks.BLOOD_ORE);
                      entries.add(ModBlocks.BLOOD_DEEPSLATE_ORE);
                      entries.add(ModBlocks.BLOOD_STAIRS);
                      entries.add(ModBlocks.BLOOD_SLAB);
                      entries.add(ModBlocks.BLOOD_BUTTON);
                      entries.add(ModBlocks.BLOOD_PRESSURE_PLATE);
                      entries.add(ModBlocks.BLOOD_FENCE);
                      entries.add(ModBlocks.BLOOD_FENCE_GATE);
                      entries.add(ModBlocks.BLOOD_WALL);
                      entries.add(ModBlocks.BLOOD_DOOR);
                      entries.add(ModBlocks.BLOOD_TRAPDOOR);
                      entries.add(ModBlocks.BLOOD_LAMP);
                    }).build());



    public static void registerItemGroups() {
        MyFabricPVPMod.LOGGER.info("Registering Item Group for " + MyFabricPVPMod.MOD_ID);
    }
}
