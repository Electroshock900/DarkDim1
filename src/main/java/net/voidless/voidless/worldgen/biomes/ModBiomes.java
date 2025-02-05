package net.voidless.voidless.worldgen.biomes;


import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.world.DeathFeatures;
import net.voidless.voidless.worldgen.ModPlacedFeatures;
import net.voidless.voidless.util.ModEntities;


public class ModBiomes {
    public static final ResourceKey<Biome> DARK_BIOME = register("dark_biome");
    public static final ResourceKey<Biome> BLOOD_BIOME = register("blood_biome");
    public static final ResourceKey<Biome> DARKLANDS = register("darklands");
    public static final ResourceKey<Biome> DARK_OCEAN = register("dark_ocean");


    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(DARKLANDS, darklands(placedFeatures, worldCarvers));

        //context.register(CANDY_CANE_BIOME, candyCaneBiome(context));
        context.register(DARK_BIOME, darkBiome(context));
        context.register(BLOOD_BIOME, bloodBiome(context));

        context.register(DARK_OCEAN, darkOceanBiome(context));

        //context.register(CINNAMON_BIOME, cinnamonBiome(context));
        //context.register(MINT_BIOME, mintBiome(context));
        //context.register(TOOTHPASTE_BIOME, toothpasteBiome(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
    //candy cane
    public static Biome candyCaneBiome(BootstrapContext<Biome> context) {
        //BIOME
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        /**biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_BUSH_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_CARNATION_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_CARNATIONS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_FLOWER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_FLOWER_2_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_FLOWER_3_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_FLOWER_4_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_GRASS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_GRASS_LONG_PLACED_KEY);
        **///biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DARK_TREE_PLACED_KEY);
        globalOverworldGeneration(biomeBuilder);
        //SPAWNING
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        //spawnBuilder.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(ModEntities.CACTUS_BUDDY.get(), 5, 4, 4));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x5ca97e)
                        .skyColor(0x408883)
                        .waterFogColor(0x5ca97e)
                        .fogColor(0x408883)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome darkBiome(BootstrapContext<Biome> context) {
        //BIOME
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_FLOWER_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DARK_TREE_PLACED_KEY);
        //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.DARK_STONE_PILLAR);
        globalOverworldGeneration(biomeBuilder);
        //SPAWNING
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.WAR_TURTLE.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

         //spawnBuilder.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(ModEntities.CACTUS_BUDDY.get(), 15, 14, 14));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .grassColorOverride(0x0e0e0e)
                        .waterColor(0x0e000f)
                        .skyColor(0x834088)
                        .waterFogColor(0x0e000f)
                        .fogColor(0x332438)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome darkOceanBiome(BootstrapContext<Biome> context) {
        //BIOME
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_CANE_FLOWER_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DARK_TREE_PLACED_KEY);
        //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.DARK_STONE_PILLAR);
        globalOverworldGeneration(biomeBuilder);
        //SPAWNING
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        //BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        //BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.WAR_TORTOISE_HYBRID.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 4, 6));
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID,5,3,13));
         //spawnBuilder.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(ModEntities.CACTUS_BUDDY.get(), 15, 14, 14));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .grassColorOverride(0x0e0e0e)
                        .waterColor(0x0e000f)
                        .skyColor(0x834088)
                        .waterFogColor(0x0e000f)
                        .fogColor(0x332438)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome bloodBiome(BootstrapContext<Biome> context) {
        //BIOME
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BLOOD_TREE_PLACED_KEY);
        //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.DARK_STONE_PILLAR);
        globalOverworldGeneration(biomeBuilder);
        //SPAWNING
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 3, 5));
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 5, 4, 4));
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.CACTUS_BUDDY.get(), 5, 4, 4));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .grassColorOverride(0x440206)
                        .waterColor(0x420000)
                        .skyColor(0x408883)
                        .waterFogColor(0x420000)
                        .fogColor(0x883840)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    //mint
    public static Biome mintBiome(BootstrapContext<Biome> context) {
        //BIOME
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        /**biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SNSPlacedFeatures.MINT_BUSH_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SNSPlacedFeatures.MINT_CHOCOLATE_TULIP_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SNSPlacedFeatures.MINT_FLOWER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SNSPlacedFeatures.MINT_IMPEONY_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SNSPlacedFeatures.POLO_PLANT_PLACED_KEY);**/
        globalOverworldGeneration(biomeBuilder);
        //SPAWNING
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x5ca97e)
                        .skyColor(0x408883)
                        .waterFogColor(0x5ca97e)
                        .fogColor(0x408883)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }


public static ResourceKey<Biome> createKey(String name) {
    return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
}

private static Biome darklands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
//        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.NETHER_CACTUS_BUDDY.get(), 6, 1, 4));
    //mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 11, 3, 6));
    mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 2, 1, 200));
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.WAR_TORTOISE.get(), 7, 1, 5));
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.WAR_TURTLE.get(), 4, 3, 13));

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
    //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.DARK_STONE_PILLAR);
    biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DARK_ORE_PLACED_KEY);
    biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BLOOD_TREE_PLACED_KEY);

    BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

    Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
    return (new Biome.BiomeBuilder()).hasPrecipitation(true)

            .temperature(-0.5f)
            .downfall(-0.5f)

            .specialEffects((new BiomeSpecialEffects.Builder())
                    .waterColor(0x6b1325)
                    .grassColorOverride(0x440206)
                    .waterFogColor(0x521320)
                    .fogColor(0x1c1433)
                    .skyColor(calculateSkyColor(-0.5f))
                    .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                    .backgroundMusic(music).build()
                    )

            .mobSpawnSettings(mobSpawnBuilder.build())
            .generationSettings(biomeBuilder.build()).build()//.getAmbientParticle()

            ;
}

private static int calculateSkyColor(float temp) {
    float s = temp / 3f;
    s = Mth.clamp(s, -1, 1);
    return Mth.hsvToRgb(1f,0.62222224f - s * 0.05f, 0.5f + s * 0.1f);
}

    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }
}
