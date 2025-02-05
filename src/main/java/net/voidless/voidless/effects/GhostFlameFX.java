package net.voidless.voidless.effects;

import net.minecraft.client.particle.SmokeParticle;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class GhostFlameFX extends MobEffect{
    public GhostFlameFX(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory,color);


    }

    public boolean applyEffectTick(@NotNull LivingEntity plivingEntity, int pAmplifier) {
        if (!plivingEntity.level().isClientSide()) {

            Double x = plivingEntity.getX();
            Double y = plivingEntity.getY();
            Double z = plivingEntity.getZ();

            //plivingEntity.animateHurt();
            plivingEntity.teleportTo(x,y,z);
            plivingEntity.setSpeed(0.2F);
            plivingEntity.isInvertedHealAndHarm();
            plivingEntity.isOnFire();
            plivingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS,50, 30), plivingEntity);
            plivingEntity.invulnerableTime+=50;

        }
        return super.applyEffectTick(plivingEntity, pAmplifier);

        //plivingEntity.level.addParticle(SmokeParticle,2,2,2,2,2,2);
    }


}
