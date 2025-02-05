package net.voidless.voidless.worldgen.dimension;


import com.mojang.datafixers.util.Pair;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.TickRateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.WorldDimensions;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.saveddata.maps.MapId;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.ticks.LevelTickAccess;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModTags;
import net.voidless.voidless.worldgen.biomes.ModBiomes;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceLocation DEATH_LEVEL_ID = ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "death_dim");

    //LEVEL STEMS
    public static final ResourceKey<LevelStem> DEATH_DIM_KEY = ResourceKey.create(Registries.LEVEL_STEM, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"death_dim"));
    //LEVELS
    public static final ResourceKey<Level> DEATH_DIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "death_dim"));
    //DIMENSION TYPES
    public static final ResourceKey<DimensionType> DEATH_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,/*DEATH_LEVEL_ID);*/ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "death_dim_type"));
    //public static final ResourceKey<> DEATH_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,/*DEATH_LEVEL_ID);*/ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "death_dim_type"));
    //public static final

    /*What is the missing method to register the Level?*/
    /*public static void bootstrapDimension(BootstrapContext<Level> context){
        HolderGetter<Level> levelRegistry = context.lookup(Registries.DIMENSION);

        context.register(DEATH_DIM_LEVEL_KEY, );

    }*/
    public static void bootstrapType(BootstrapContext<DimensionType> context) {
        context.register(DEATH_DIM_TYPE, new DimensionType(
                OptionalLong.of(00000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                13.0, // coordinateScale
                true, // bedWorks
                true, // respawnAnchorWorks
                -208, // minY
                2032, // height
                2032, // logicalHeight
                ModTags.Blocks.VOIDLESS_INFINIBURN, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(true, false, ConstantInt.of(0), 11)));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

         NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                 new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.DARK_BIOME)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DARK_BIOME)),
                                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BLOOD_BIOME)),
                                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DARKLANDS)),
                                //Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DARKLAND_DESERT)),
                                Pair.of(Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.2F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
                                Pair.of(Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.5F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.7F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.7F, 0.0F), biomeRegistry.getOrThrow(Biomes.SUNFLOWER_PLAINS))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        //LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.DEATH_DIM_TYPE), wrappedChunkGenerator);
        LevelStem stem = new LevelStem(dimTypes.getOrThrow(DEATH_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(DEATH_DIM_KEY, stem);
    }


    //public static void booststrapDimension(BootstrapContext<Level> context){context.register(DEATH_DIM_LEVEL_KEY,DEATH_DIM_LEVEL_KEY.getOrThrow(RegistryAccess.fromRegistryOfRegistries()))}
}


