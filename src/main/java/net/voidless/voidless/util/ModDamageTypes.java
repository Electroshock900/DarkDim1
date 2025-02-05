package net.voidless.voidless.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.voidless.voidless.VoidlessMod;

public interface ModDamageTypes {

    /*
     * Store the RegistryKey of our DamageType into a new constant called CUSTOM_DAMAGE_TYPE
     * The Identifier in use here points to our JSON file we created earlier.
     */
    ResourceKey<DamageType> LIFE_STEAL = ResourceKey.create(Registries.DAMAGE_TYPE,ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"life_steal"));

    private static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }
    static void bootstrap(BootstrapContext<DamageType> pContext) {
        pContext.register(LIFE_STEAL, new DamageType("life_steal", 0.1F, DamageEffects.HURT));
    }
    }
/**
    public static DamageSource of(Level world, ResourceKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(Registries.DAMAGE_TYPE).entryOf(key));
    }**/

