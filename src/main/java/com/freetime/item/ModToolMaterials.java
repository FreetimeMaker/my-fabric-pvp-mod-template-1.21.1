package com.freetime.item;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class ModToolMaterials {
    public static final ToolMaterial BLOOD_INGOT = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 2048;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 9.0f;
        }

        @Override
        public float getAttackDamage() {
            return 4.0f;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return null;
        }

        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 22;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.BLOOD_INGOT);
        }
    };
}