package net.voidless.voidless.world;


import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.world.features.DarkStonePillars;

public class DeathFeatures{
public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, VoidlessMod.MODID);

public static final RegistryObject<DarkStonePillars> DARK_STONE_PILLAR = FEATURES.register("dark_stone_pillar", () -> new DarkStonePillars(SimpleBlockConfiguration.CODEC));

    public static void register(IEventBus eventBus){FEATURES.register(eventBus);}
}