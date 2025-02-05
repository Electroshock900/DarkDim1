package net.voidless.voidless.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.voidless.voidless.entity.projectiles.ChakramEntity;
import net.voidless.voidless.entity.projectiles.Thrown_Chakram;
import net.voidless.voidless.entity.projectiles.TomahawkProjectileEntity;
import net.voidless.voidless.util.*;

public class ChakramItem extends SwordItem {

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return super.canAttackBlock(pState, pLevel, pPos, pPlayer);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.hurt(new DamageSource(DamageTypes.IN_FIRE.getOrThrow(pTarget.level())),13);

        return super.hurtEnemy(pStack, pTarget, pAttacker);

    }

    public ChakramItem(Tier tier, int attack_damage, float attack_speed, Properties properties) {
        super(tier,
                properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        //builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 8.0D, AttributeModifier.Operation.ADDITION));
        //builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-2.9F, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.3F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            ChakramEntity chakram = new ChakramEntity(pPlayer, pLevel);
            chakram.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0F);
            pLevel.addFreshEntity(chakram);

            pLevel.addParticle(ParticleTypes.FLAME,
                    pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),0,0,13
            );
        }


        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }



    //EntityType<? extends Thrown_Chakram> type;

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.SPEAR;
    }


    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }


/**
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int p_43397_) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack) - p_43397_;
            if (i >= 10) {
                int j = EnchantmentHelper.getRiptide(stack);
                if (j <= 0 || player.isInWaterOrRain()) {
                    if (!level.isClientSide) {
                        //stack.hurtAndBreak(1, player, (p_43388_) -> {
                            //p_43388_.broadcastBreakEvent(entity.getUsedItemHand());
                        //});
                        if (j == 0) {
                            Thrown_Chakram thrownChakram = new Thrown_Chakram(stack.is(ModItems.CHAKRAM.get()) ? ModEntities.CHAKRAM.get() : ModEntities.CHAKRAM.get(), level, player, stack);
                            thrownChakram.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                            if (player.getAbilities().instabuild) {
                                thrownChakram.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            level.addFreshEntity(thrownChakram);
                            //level.playSound((Player)null, entity.getItemthrownChakram, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                            if (!player.getAbilities().instabuild) {
                                player.getInventory().removeItem(stack);
                            }
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (j > 0) {
                        float f7 = player.getYRot();
                        float f = player.getXRot();
                        float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                        float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                        float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
                        f1 *= f5 / f4;
                        f2 *= f5 / f4;
                        f3 *= f5 / f4;
                        player.push((double)f1, (double)f2, (double)f3);
                        player.startAutoSpinAttack(20);
                        //if (player.isOnGround()) {
                        float f6 = 1.1999999F;
                        player.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));
                        //}

                        SoundEvent soundevent;
                        if (j >= 3) {
                            soundevent = SoundEvents.FIRECHARGE_USE;
                        } else if (j == 2) {
                            soundevent = SoundEvents.FIRE_EXTINGUISH;
                        } else {
                            soundevent = SoundEvents.DRAGON_FIREBALL_EXPLODE;
                        }

                        level.playSound((Player)null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

**/


/**

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
        return p_43383_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43383_);
    }**/
}


