package net.voidless.voidless.world;



import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_TREE_KEY = registerKey("dark_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOD_TREE_KEY = registerKey("blood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_TREE_KEY = registerKey("void_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_ORE_KEY = registerKey("dark_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_DARK_ORE_KEY = registerKey("deepslate_dark_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_DARK_ORE_KEY = registerKey("nether_dark_ore");


    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_STONE_PILLAR = registerKey("dark_stone_pillar");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stonereplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatereplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest netherrackreplacables = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldDarkOres = List.of(
                OreConfiguration.target(stonereplacables, ModBlocks.DARK_SHARD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslatereplacables,ModBlocks.DEEPSLATE_DARK_SHARD_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherDarkOres = List.of(
                OreConfiguration.target(netherrackreplacables,ModBlocks.NETHER_DARK_SHARD_ORE.get().defaultBlockState()));

        register(context, DARK_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.DARK_LOG.get()),
                new StraightTrunkPlacer(6, 6, 6),

                BlockStateProvider.simple(ModBlocks.DARK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 4),

                new TwoLayersFeatureSize(1, 0, 13)).build());
        register(context, BLOOD_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLOOD_LOG.get()),
                new StraightTrunkPlacer(6, 6, 6),

                BlockStateProvider.simple(ModBlocks.BLOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),

                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, VOID_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.VOID_LOG.get()),
                new StraightTrunkPlacer(6, 6, 6),

                BlockStateProvider.simple(ModBlocks.VOID_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),

                new TwoLayersFeatureSize(1, 0, 2)).build());


        register(context, DARK_ORE_KEY,Feature.ORE,new OreConfiguration(overworldDarkOres,9));
        register(context, DEEPSLATE_DARK_ORE_KEY,Feature.ORE,new OreConfiguration(netherrackreplacables,ModBlocks.DEEPSLATE_DARK_SHARD_ORE.get().defaultBlockState(),13));
        register(context, NETHER_DARK_ORE_KEY,Feature.ORE,new OreConfiguration(netherrackreplacables,ModBlocks.NETHER_DARK_SHARD_ORE.get().defaultBlockState(),10));

        //FeatureUtils.register(context, DARK_STONE_PILLAR, DeathFeatures.DARK_STONE_PILLAR.get());
        /*register(context, DARK_STONE_PILLAR,
                Feature.BLOCK_PILE, new BlockPileConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.DARK_SHARD_ORE.get().defaultBlockState(), 13)
                        .add(ModBlocks.DARKNESS_BLOCK.get().defaultBlockState(), 7)
        )));*/
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {

        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
