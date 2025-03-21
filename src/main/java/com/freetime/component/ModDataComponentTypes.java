package com.freetime.component;

import com.freetime.MyFabricPVPMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES =
            register("coordinates", builder -> builder.codec(BlockPos.CODEC));


    public static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(MyFabricPVPMod.MOD_ID, name),
                builderOperator.apply(new ComponentType.Builder<T>()).build());
    }

    public static void registerDataComponentTypes() {
        MyFabricPVPMod.LOGGER.info("Registering data component types for " + MyFabricPVPMod.MOD_ID);
    }
}
