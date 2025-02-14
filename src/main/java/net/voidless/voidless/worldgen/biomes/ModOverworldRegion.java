package net.voidless.voidless.worldgen.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, ModBiomes.DARK_BIOME);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, ModBiomes.BLOOD_BIOME);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, ModBiomes.DARKLANDS);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.COLD_OCEAN, ModBiomes.DARK_OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OCEAN, ModBiomes.DARK_OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.WARM_OCEAN, ModBiomes.DARK_OCEAN);
            //modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, ModBiomes.BLOOD_BIOME);
            //modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, ModBiomes.BLOOD_BIOME);

        });
    }
}
