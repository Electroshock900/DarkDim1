package net.voidless.voidless.effects;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.voidless.voidless.util.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class VampireDrainEffect extends InstantenousMobEffect {
    public VampireDrainEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        if (!pSource.level().isClientSide()) {

            if (pIndirectSource.level().isNight()) {
                pLivingEntity.addEffect(new MobEffectInstance(ModEffects.DRAIN.getHolder().get(),7));
                //plivingEntity.addEffect(MobEffects.GLOWING.,plivingEntity);
                pLivingEntity.heal((float)pHealth);

                pIndirectSource.hurt(pIndirectSource.damageSources().magic(), (float)pHealth);

            }
        }

        super.applyInstantenousEffect(pSource, pIndirectSource, pLivingEntity, pAmplifier, pHealth);
    }

    @Override
    public boolean applyEffectTick(LivingEntity plivingEntity, int pAmplifier) {
        double x = plivingEntity.getX();
        double y = plivingEntity.getY();
        double z = plivingEntity.getZ();
        if (!plivingEntity.level().isClientSide()) {

            if (plivingEntity.level().isNight()) {
                //plivingEntity.addEffect(MobEffects.GLOWING.,plivingEntity);

                plivingEntity.hurt(plivingEntity.damageSources().magic(),13.0F);
                //plivingEntity.heal(13.0F);


                //plivingEntity.
                //AttributeModifier.Operation.ULTIPLY_TOTAL
                //plivingEntity.animateHurt();
                //plivingEntity.teleportTo(x,y,z);
                //plivingEntity.


            }
        }
        //super.applyEffectTick(plivingEntity, pAmplifier);
    return true;
    }
}
