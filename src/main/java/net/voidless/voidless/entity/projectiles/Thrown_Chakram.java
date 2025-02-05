package net.voidless.voidless.entity.projectiles;


import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ItemStackMap;
import net.voidless.voidless.util.ModEntities;
import net.voidless.voidless.util.ModItems;
import org.jetbrains.annotations.NotNull;


import javax.annotation.Nullable;

public class Thrown_Chakram extends AbstractArrow {
    /**private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(Thrown_Chakram.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(Thrown_Chakram.class, EntityDataSerializers.BOOLEAN);
**/
    private ItemStack ChakramItem = new ItemStack(ModItems.CHAKRAM.get());

    private boolean dealtDamage;

    public int clientSideReturnChakramTickCount;

    public Thrown_Chakram(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public Thrown_Chakram(LivingEntity shooter, Level level) {
        super(ModEntities.CHAKRAM.get(), shooter, level, new ItemStack(ModItems.CHAKRAM.get()), new ItemStack(ModItems.CHAKRAM.get()));
    }



    @Override
    protected ItemStack getDefaultPickupItem() {return new ItemStack(ModItems.CHAKRAM.get());}

    //this.ChakramItem.copy();}


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(this.damageSources().thrown(this,this.getOwner()),13);
        if (!this.level().isClientSide){
            this.level().broadcastEntityEvent(entity,(byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.level().explode(this,this.getX(),this.getY(),this.getZ(),13.0F, Level.ExplosionInteraction.BLOCK);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        if (this.inGroundTime % 5 == 0) {
            this.makeParticle(13);
        }/**
        Entity entity = this.getOwner();
        int i = this.entityData.get(ID_LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }
                this.makeParticle(13);
                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 vec3 = entity.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015D * (double)i, this.getZ());
                if (this.level().isClientSide) {
                    this.yOld = this.getY();
                }

                double d0 = 0.05D * (double)i;
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d0)));
                if (this.clientSideReturnChakramTickCount == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.clientSideReturnChakramTickCount;
            }
        }**/

        super.tick();
    }

    private void makeParticle(int p_36877_) {
        /**int i = this.getTeamColor();
         if (i != -1 && p_36877_ > 0) {
         double d0 = (double)(i >> 16 & 255) / 255.0D;
         double d1 = (double)(i >> 8 & 255) / 255.0D;
         double d2 = (double)(i >> 0 & 255) / 255.0D;
         **/
        for(int j = 0; j < p_36877_; ++j) {
            this.level().addParticle(ParticleTypes.FLAME, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D),0,0,0);//, d0, d1, d2);
        }

    }
    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayer) || !entity.isSpectator();
        } else {
            return false;
        }
    }
/**
    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }**/


    @Nullable
    protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
        return this.dealtDamage ? null : super.findHitEntity(p_37575_, p_37576_);
    }



    protected boolean tryPickup(Player player) {
        return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    public void playerTouch(Player p_37580_) {
        if (this.ownedBy(p_37580_) || this.getOwner() == null) {
            super.playerTouch(p_37580_);
        }

    }

    /**public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Eternal Flame", 10)) {
            this.ChakramItem = ItemStack.(tag.getCompound("Eternal Flame"));
        }

        this.dealtDamage = tag.getBoolean("DealtDamage");

    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        //tag.put("Eternal Flame", this.ChakramItem.save(new CompoundTag()));
        tag.putBoolean("DealtDamage", this.dealtDamage);
    }**/

    //protected float getWaterInertia() {
      //  return 0.99F;
    //}


    public boolean shouldRender(double x, double y, double z) {
        return true;
    }

    public double getTick(Object o) {
        return 0;
    }

}

