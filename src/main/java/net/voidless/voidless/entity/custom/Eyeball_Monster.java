package net.voidless.voidless.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.level.Level;

public class Eyeball_Monster extends Mob {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Eyeball_Monster.class, EntityDataSerializers.BOOLEAN);


    public Eyeball_Monster(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void aiStep() {
        super.aiStep();
        for(int $$0 = 0; $$0 < 2; ++$$0) {
            this.level().addParticle(ParticleTypes.ASH, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
        }

    }

    @Override
    public void tick(){
        super.tick();
        if(this.level().isClientSide()){
            //this.level().addParticle(ParticleTypes.ASH,this.lerpX,this.lerpY,this.lerpZ, this.lerpXRot*2,this.lerpYRot,0.3);

        }

    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout<=0){
            this.idleAnimationTimeout = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
        if(this.isAttacking()&&attackAnimationTimeout<=0){
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        }else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f, 1f);

        }else{f=0f;}
        this.walkAnimation.update(f,0.2f);

    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(ATTACKING,false);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(ATTACKING, isAttacking());

    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.getBoolean("Attacking");
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING,attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    protected int getJumpDelay() {
        return this.random.nextInt(20) + 10;
    }

    public static AttributeSupplier.Builder setAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH,3.0D)
                .add(Attributes.MOVEMENT_SPEED,3.0F)
                .add(Attributes.ATTACK_DAMAGE,3.0F);
    }

    static class MOMoveControl extends MoveControl {
        
        private float yRot;
        private int jumpDelay;
        private final Eyeball_Monster eyeball_monster;
        private boolean isAggressive;

        public MOMoveControl(Eyeball_Monster pEyeball_Monster) {
            super(pEyeball_Monster);
            this.eyeball_monster = pEyeball_Monster;
            this.yRot = 180.0F * pEyeball_Monster.getYRot() / 3.1415927F;
        }

        public void setDirection(float pYRot, boolean pAggressive) {
            this.yRot = pYRot;
            this.isAggressive = pAggressive;
        }

        public void setWantedMovement(double pSpeed) {
            this.speedModifier = pSpeed;
            this.operation = Operation.MOVE_TO;
        }

        public void tick() {
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
            this.mob.yHeadRot = this.mob.getYRot();
            this.mob.yBodyRot = this.mob.getYRot();
            if (this.operation != Operation.MOVE_TO) {
                this.mob.setZza(0.0F);
            } else {
                this.operation = Operation.WAIT;
                if (this.mob.onGround()) {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.eyeball_monster.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.eyeball_monster.getJumpControl().jump();
                        /*if (this.eyeball_monster.doPlayJumpSound()) {
                            this.eyeball_monster.playSound(this.eyeball_monster.getJumpSound(), this.eyeball_monster.getSoundVolume(), this.eyeball_monster.getSoundPitch());
                        }*/
                    } else {
                        this.eyeball_monster.xxa = 0.0F;
                        this.eyeball_monster.zza = 0.0F;
                        this.mob.setSpeed(0.0F);
                    }
                } else {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }
            }

        }
    }
}
