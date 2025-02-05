package net.voidless.voidless.particles.options;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.voidless.voidless.util.ModParticles;

public class GhostlyFlameParticleOption implements ParticleOptions {
    public static final MapCodec<GhostlyFlameParticleOption> CODEC = RecordCodecBuilder.mapCodec((p_235952_) -> {
        return p_235952_.group(Codec.INT.fieldOf("delay").forGetter((p_235954_) -> {
            return p_235954_.delay;
        })).apply(p_235952_, GhostlyFlameParticleOption::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, GhostlyFlameParticleOption> STREAM_CODEC;
    private final int delay;

    public GhostlyFlameParticleOption(int p_235949_) {
        this.delay = p_235949_;
    }

    public ParticleType<GhostlyFlameParticleOption> getType() {
        return null;//ModParticles.GHOSTLY_FLAME_OPTION;
    }

    public int getDelay() {
        return this.delay;
    }

    static {
        STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, (p_325814_) -> {
            return p_325814_.delay;
        }, GhostlyFlameParticleOption::new);
    }
}