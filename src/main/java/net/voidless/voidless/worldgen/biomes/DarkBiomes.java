package net.voidless.voidless.worldgen.biomes;


import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
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
import net.voidless.voidless.VoidlessMod;

public class DarkBiomes {
    public static final ResourceKey<Biome> DARKLANDS = createKey("darklands");

    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(DARKLANDS, darklands(placedFeatures, worldCarvers));
    }

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }

    private static Biome darklands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
//        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.NETHER_CACTUS_BUDDY.get(), 6, 1, 4));
        //mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 11, 3, 6));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 2, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DeathFeatures.DARK_STONE_PILLAR);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(-0.5f)
                .downfall(-0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x6b1325)
                        .waterFogColor(0x521320)
                        .fogColor(0x1c1433)
                        .skyColor(calculateSkyColor(-0.5f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static int calculateSkyColor(float temp) {
        float s = temp / 3f;
        s = Mth.clamp(s, -1, 1);
        return Mth.hsvToRgb(1f,0.62222224f - s * 0.05f, 0.5f + s * 0.1f);
    }

}
