package net.voidless.voidless.datagen;

import net.minecraft.world.effect.MobEffects;
import net.voidless.voidless.util.ModDamageTypes;
import net.voidless.voidless.util.ModEffects;
import net.voidless.voidless.util.ModEnchantments;
import net.voidless.voidless.worldgen.ModBiomeModifiers;
import net.voidless.voidless.world.ModConfiguredFeatures;
import net.voidless.voidless.worldgen.ModPlacedFeatures;
//import net.voidless.voidless.worldgen.biomes.*;
import net.voidless.voidless.worldgen.biomes.ModBiomes;
import net.voidless.voidless.worldgen.dimension.ModDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.voidless.voidless.VoidlessMod;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
            //.add(ForgeRegistries.)
//            .add(Registries.DIMENSION, ModDimensions::bootstrapDimension)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap)
            //.add(Registries.BIOME, DarkBiomes::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap)
            .add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap);
            //.add(Registries.MOB_EFFECT, ModEffects::register)

    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(VoidlessMod.MODID));
    }
}