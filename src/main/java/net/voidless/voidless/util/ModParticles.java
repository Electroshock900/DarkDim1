package net.voidless.voidless.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;

import java.util.function.Function;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, VoidlessMod.MODID);

    public static final RegistryObject<SimpleParticleType> CANDY_CANE_FLAME_PARTICLES =
            PARTICLE_TYPES.register("candy_cane_flame_particles", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> DEATH_SKULLS =
            PARTICLE_TYPES.register("death_skulls", ()->new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GHOSTLY_FLAME_FX =
            PARTICLE_TYPES.register("ghostly_flame", ()-> new SimpleParticleType(false));
    /*public static final RegistryObject<SimpleParticleType> BLOOD_DRIP =
            PARTICLE_TYPES.register("blood_falling")*/
    public static final RegistryObject<SimpleParticleType> DRIPPING_BLOOD =
            PARTICLE_TYPES.register("blood_dripping", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_BLOOD =
            PARTICLE_TYPES.register("blood_falling", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_BLOOD =
            PARTICLE_TYPES.register("blood_landing", ()-> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_DEITY_BLOOD =
            PARTICLE_TYPES.register("deity_blood_dripping", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_DEITY_BLOOD =
            PARTICLE_TYPES.register("deity_blood_falling", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_DEITY_BLOOD =
            PARTICLE_TYPES.register("deity_blood_landing", ()-> new SimpleParticleType(false));

    /**
     public static final ParticleType<GhostlyFlameParticleOption> GHOSTLY_FLAME_OPTION = register("ghostly_flame_option", false, (p_325811_) -> {
        return GhostlyFlameParticleOption.CODEC;
    }, (p_325804_) -> {
        return GhostlyFlameParticleOption.STREAM_CODEC;
    });**/


    public static final Codec<ParticleOptions> CODEC;
    public static final StreamCodec<RegistryFriendlyByteBuf, ParticleOptions> STREAM_CODEC;
    // public static final RegistryObject<SimpleParticleType> CANDY_CANE_SMOKE_PARTICLES =
    //        PARTICLE_TYPES.register("candy_cane_smoke_particles", () -> new SimpleParticleType(true));

    private static <T extends ParticleOptions> ParticleType<T> register(String pName, boolean pOverrideLimitter, final Function<ParticleType<T>, MapCodec<T>> pCodecGetter, final Function<ParticleType<T>, StreamCodec<? super RegistryFriendlyByteBuf, T>> pStreamCodecGetter) {
        return  Registry.register(BuiltInRegistries.PARTICLE_TYPE, pName, new ParticleType<T>(pOverrideLimitter) {
            public MapCodec<T> codec() {
                return pCodecGetter.apply(this);
            }

            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return pStreamCodecGetter.apply(this);
            }
        });
    }

    private static SimpleParticleType register(String pKey, boolean pOverrideLimiter) {
        return (SimpleParticleType)Registry.register(BuiltInRegistries.PARTICLE_TYPE, pKey, new SimpleParticleType(pOverrideLimiter));
    }
    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
    static {
        CODEC = BuiltInRegistries.PARTICLE_TYPE.byNameCodec().dispatch("type", ParticleOptions::getType, ParticleType::codec);
        STREAM_CODEC = ByteBufCodecs.registry(Registries.PARTICLE_TYPE).dispatch(ParticleOptions::getType, ParticleType::streamCodec);
    }

}

