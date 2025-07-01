package com.freetime.block;

import com.freetime.MyFabricPVPMod;
import com.freetime.block.custom.BloodLampBlock;
import com.freetime.block.custom.BloodMagicBlock;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block BLOOD_BLOCK = registerBlock("blood_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool()));
    public static final Block RAW_BLOOD_BLOCK = registerBlock("raw_blood_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLOOD_ORE = registerBlock("blood_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block BLOOD_DEEPSLATE_ORE = registerBlock("blood_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block BLOOD_STAIRS = registerBlock("blood_stairs",
            new StairsBlock(ModBlocks.BLOOD_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOOD_SLAB = registerBlock("blood_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOOD_BUTTON = registerBlock("blood_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block BLOOD_PRESSURE_PLATE = registerBlock("blood_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOOD_FENCE = registerBlock("blood_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOOD_FENCE_GATE = registerBlock("blood_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOOD_WALL = registerBlock("blood_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOOD_DOOR = registerBlock("blood_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block BLOOD_TRAPDOOR = registerBlock("blood_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block BLOOD_LAMP = registerBlock("blood_lamp",
            new BloodLampBlock(AbstractBlock.Settings.create()
                    .strength(1).requiresTool().luminance(state -> state.get(BloodLampBlock.CLICKED) ? 15 : 0)));
    public static final Block BLOOD_MAGIC_BLOCK = registerBlock("blood_magic_block",
            new BloodMagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MyFabricPVPMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MyFabricPVPMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MyFabricPVPMod.LOGGER.info("Registering Mod Blocks for " + MyFabricPVPMod.MOD_ID);
    }
}
