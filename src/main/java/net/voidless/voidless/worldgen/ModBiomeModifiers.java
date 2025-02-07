package net.voidless.voidless.worldgen;


import io.netty.bootstrap.Bootstrap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModEntities;
import net.voidless.voidless.util.ModTags;
import net.voidless.voidless.world.DeathFeatures;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_DARK_ORE = registerKey("add_dark_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_DARK_ORE = registerKey("add_nether_dark_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_DARK_ORE = registerKey("add_end_dark_ore");
    public static final ResourceKey<BiomeModifier> ADD_DARK_TREE = registerKey("add_dark_tree");
    public static final ResourceKey<BiomeModifier> ADD_BLOOD_TREE = registerKey("add_blood_tree");
    public static final ResourceKey<BiomeModifier> ADD_VOID_TREE = registerKey("add_void_tree");
    public static final ResourceKey<BiomeModifier> ADD_DARK_PILLARS = registerKey("add_dark_pillar");
    public static final ResourceKey<BiomeModifier> ADD_TORTOISE_HYBRID = registerKey("add_tortoise_hybrid");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


        context.register(ADD_DARK_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DARK_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_DARK_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_DARK_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_DARK_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_DARK_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DARK_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DARK_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLOOD_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLOOD_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_VOID_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_BEACH),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VOID_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TORTOISE_HYBRID, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.DARK_BIOMES),
                List.of(
                        new MobSpawnSettings.SpawnerData(ModEntities.WAR_TORTOISE_HYBRID.get(), 13, 3, 13),
                        new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 7, 3, 7)

                )

        ));

        /**context.register(ADD_DARK_PILLARS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(placedFeatures.getOrThrow(DeathFeatures.DARK_STONE_PILLAR.getKey()))
        ));**/

        /**context.register(ADD_BLOOD_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLOOD_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));**/
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }
}

