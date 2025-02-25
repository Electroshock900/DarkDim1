package net.voidless.voidless.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MO extends PathfinderMob implements RangedAttackMob,GeoAnimatable {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(MO.class, EntityDataSerializers.BOOLEAN);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);



    public MO(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void tick(){
        super.tick();
        if(this.level().isClientSide()){
            this.level().addParticle(ParticleTypes.ASH,this.lerpX,this.lerpY,this.lerpZ, this.lerpXRot*2,this.lerpYRot,0.3);

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
        pBuilder.define(ATTACKING, false);
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

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1,new RangedAttackGoal(this,3.0D,30,3.0F));
        this.goalSelector.addGoal(2,new RandomStrollGoal(this, 1.0D) );
        this.goalSelector.addGoal(2,new RandomSwimmingGoal(this, 1.0D,1) );
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class,
                10, true, false, (p_29932_) -> {
            return p_29932_ instanceof LivingEntity;
        }));
    }

    public static AttributeSupplier.Builder setAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH,3.0D)
                .add(Attributes.MOVEMENT_SPEED,3.0F)
                .add(Attributes.ATTACK_DAMAGE,3.0F);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "idle", 5, state -> state.setAndContinue(DefaultAnimations.IDLE)));
        controllerRegistrar.add(new AnimationController<>(this, "walk", 5, state -> state.setAndContinue(DefaultAnimations.WALK)));

    }
    protected int getJumpDelay() {
        return this.random.nextInt(20) + 10;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {

    }

    /*
        private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
            if(tAnimationState.isMoving()) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.tiger.walk", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.tiger.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }*/
    static class MOMoveControl extends MoveControl {
        
        private float yRot;
        private int jumpDelay;
        private final MO eyeball_monster;
        private boolean isAggressive;

        public MOMoveControl(MO pEyeball_Monster) {
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
