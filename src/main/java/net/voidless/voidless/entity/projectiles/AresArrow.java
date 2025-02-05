package net.voidless.voidless.entity.projectiles;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.voidless.voidless.util.ModEntities;

public class AresArrow extends AbstractArrow {

    public AresArrow(EntityType<? extends AresArrow> p_36858_, Level p_36859_) {
        super(p_36858_, p_36859_);
    }



    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            if (this.inGround) {

                if (this.inGroundTime % 5 == 0) {
                    this.makeParticle(3);
                    this.makeParticle2(7);
                }
            }
                    else {
                this.makeParticle(3);
                this.makeParticle2(7);
            }
        } else if (this.inGround && this.inGroundTime != 0 && /**!this.effects.isEmpty() &&**/ this.inGroundTime >= 600) {
            this.level().broadcastEntityEvent(this, (byte)0);
            this.discard();
            /**this.potion = Potions.EMPTY;
            this.effects.clear();
            this.entityData.set(ID_EFFECT_COLOR, -1);**/
        }

    }

    private void makeParticle(int p_36877_) {
        /**int i = this.getColor();
        if (i != -1 && p_36877_ > 0) {
            double d0 = (double)(i >> 16 & 255) / 255.0D;
            double d1 = (double)(i >> 8 & 255) / 255.0D;
            double d2 = (double)(i >> 0 & 255) / 255.0D;
**/
            for(int j = 0; j < p_36877_; ++j) {
                this.level().addParticle(ParticleTypes.LAVA, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D),0,0,0);//, d0, d1, d2);
                //this.level().addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.9D),0, Mth.sin(7),0);//, d0, d1, d2);
            }

        }
    private void makeParticle2(int p_36877_) {
        /**int i = this.getColor();
        if (i != -1 && p_36877_ > 0) {
            double d0 = (double)(i >> 16 & 255) / 255.0D;
            double d1 = (double)(i >> 8 & 255) / 255.0D;
            double d2 = (double)(i >> 0 & 255) / 255.0D;
**/
            for(int j = 0; j < p_36877_; ++j) {
                //this.level().addParticle(ParticleTypes.CRIT, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D),0,0,0);//, d0, d1, d2);
                this.level().addParticle(ParticleTypes.FALLING_LAVA, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.9D),0,
                        Mth.sin(7)
                        ,0);//, d0, d1, d2);
            }

        }
        //}

    @Override
    protected void onHitEntity(EntityHitResult p_36757_) {
        //p_36757_.getEntity().setSecondsOnFire(15);
        super.onHitEntity(p_36757_);
    }

    protected ItemStack getDefaultPickupItem() {
            //if (this.effects.isEmpty() && this.potion == Potions.EMPTY) {
            return ItemStack.EMPTY;//new ItemStack(ModItems.ARESARROW.get());


    }

    /**else {
            ItemStack itemstack = new ItemStack(Items.TIPPED_ARROW);
            PotionUtils.setPotion(itemstack, this.potion);
            PotionUtils.setCustomEffects(itemstack, this.effects);
            if (this.fixedColor) {
                itemstack.getOrCreateTag().putInt("CustomPotionColor", this.getColor());
            }

            return itemstack;
        }
    }**/

}
