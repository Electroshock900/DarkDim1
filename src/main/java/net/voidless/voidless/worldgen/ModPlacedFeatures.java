package net.voidless.voidless.worldgen;



import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.world.ModConfiguredFeatures;
import net.voidless.voidless.world.ModOrePlacement;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> DARK_TREE_PLACED_KEY = createKey("dark_tree_placed");
    public static final ResourceKey<PlacedFeature> BLOOD_TREE_PLACED_KEY = createKey("blood_tree_placed");
    public static final ResourceKey<PlacedFeature> VOID_TREE_PLACED_KEY = createKey("void_tree_placed");

    public static final ResourceKey<PlacedFeature> DARK_ORE_PLACED_KEY = createKey("dark_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_DARK_ORE_PLACED_KEY = createKey("nether_dark_ore_placed");
    public static final ResourceKey<PlacedFeature> END_DARK_ORE_PLACED_KEY = createKey("end_dark_ore_placed");

    public static final ResourceKey<PlacedFeature> DARK_STONE_PILLAR = createKey("dark_stone_pillar");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        /*HolderGetter<ConfiguredFeature<?, ?>>*/
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, DARK_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.DARK_SAPLING.get()));
        register(context, BLOOD_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1f, 2), ModBlocks.BLOOD_SAPLING.get()));
        register(context, VOID_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VOID_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(13, 0.1f, 2), ModBlocks.VOID_SAPLING.get()));



        register(context,DARK_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_ORE_KEY),
                ModOrePlacement.commonOrePlacement(13, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-13),VerticalAnchor.absolute(130))));
        register(context,NETHER_DARK_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_DARK_ORE_KEY),
                ModOrePlacement.commonOrePlacement(13, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-13),VerticalAnchor.absolute(80))));
        register(context,END_DARK_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_DARK_ORE_KEY),
                ModOrePlacement.commonOrePlacement(13, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-13),VerticalAnchor.absolute(80))));

/*
        register(context, DARK_STONE_PILLAR, configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_STONE_PILLAR),
                countPlacement(4, PlacementUtils.FULL_RANGE));
*/
    }


    private static List<PlacementModifier> countPlacement(int attempts, PlacementModifier heightRange) {
        return modifiedPlacement(CountPlacement.of(attempts), heightRange);
    }
    private static List<PlacementModifier> modifiedPlacement(PlacementModifier count, PlacementModifier heightRange) {
        return List.of(count, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    /*private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }*/
}