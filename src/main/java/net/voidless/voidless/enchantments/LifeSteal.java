package net.voidless.voidless.enchantments;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.voidless.voidless.util.ModDamageSources;
import org.jetbrains.annotations.NotNull;

public record LifeSteal() implements EnchantmentEntityEffect {
    public static MapCodec<LifeSteal> CODEC = MapCodec.unit(LifeSteal::new);
    @Override
    public void apply(@NotNull ServerLevel serverLevel, int enchantLevel, EnchantedItemInUse pItem, Entity entity, Vec3 vec3) {

            assert pItem.owner() != null;
            pItem.owner().heal(6.5F * (float)enchantLevel);

            entity.hurt(ModDamageSources.LIFE_STEAL, 6.5F * (float)enchantLevel);

    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }


}

