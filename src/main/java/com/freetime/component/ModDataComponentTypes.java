package com.freetime.component;

import com.freetime.MyFabricPVPMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    // Corrected register method
    public static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(MyFabricPVPMod.MOD_ID, name),
                builderOperator.apply(new ComponentType.Builder<T>()).build());
    }

    public static void registerDataComponentTypes() {
        MyFabricPVPMod.LOGGER.info("Registering data component types for " + MyFabricPVPMod.MOD_ID);

        // Example registration (Modify as needed)
        // register("example_component", builder -> builder);
    }
}
