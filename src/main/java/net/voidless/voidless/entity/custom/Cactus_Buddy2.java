package net.voidless.voidless.entity.custom;


import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
//import net.voidless.voidless.entity.projectiles.Cactus_Spine;
import net.voidless.voidless.entity.projectiles.Cactus_Spine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Cactus_Buddy2 extends Animal {//implements GeoEntity implements RangedAttackMob {
//    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Cactus_Buddy2.class, EntityDataSerializers.BOOLEAN);
    public Cactus_Buddy2(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void tick(){
        super.tick();
        if(this.level().isClientSide()){

        }
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout<=0){
            this.idleAnimationTimeout = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
       /** if(this.isAttacking()&&attackAnimationTimeout<=0){
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        }else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }**/
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f, 1f);

        }else{f=0f;}
        this.walkAnimation.update(f,0.2f);

    }

    /**public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING,attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }**/

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        //this.entityData.set(ATTACKING,false);
    }


    public static AttributeSupplier.Builder setAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,4D)
                .add(Attributes.ARMOR,1.2D)
                .add(Attributes.ARMOR_TOUGHNESS,1.2D)
                .add(Attributes.ATTACK_DAMAGE,3.0F)
                .add(Attributes.ATTACK_SPEED,1.0F)
                .add(Attributes.ATTACK_KNOCKBACK,1.0F)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED,0.2F);
}

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(2,new CactusBuddyMeleeAttackGoal(this,1.0D,true));
        this.goalSelector.addGoal(3,new BreedGoal(this, 1.12D));
        this.goalSelector.addGoal(3,new TemptGoal(this,2, Ingredient.of(Blocks.CACTUS),false));
        //this.goalSelector.addGoal(2, new MeleeAttackGoal(this,1.2D,false));
        //this.goalSelector.addGoal(1,new RangedAttackGoal(this,3.0D,30,3.0F));
        this.goalSelector.addGoal(2,new RandomStrollGoal(this, 1.0D) );
        this.goalSelector.addGoal(2,new RandomSwimmingGoal(this, 1.0D,1) );
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false, (p_29932_) -> {
            return p_29932_ instanceof Creeper;
        }));

    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel pLevel, @NotNull AgeableMob pMob) {
        return null;//ModEntities.CACTUS_BUDDY.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Blocks.CACTUS.asItem());
    }

    public void performRangedAttack(LivingEntity p_29912_, float p_29913_) {
        Cactus_Spine snowball = new Cactus_Spine(this.level(), this);
        double d0 = p_29912_.getEyeY() - (double)1.1F;
        double d1 = p_29912_.getX() - this.getX();
        double d2 = d0 - snowball.getY();
        double d3 = p_29912_.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        snowball.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(snowball);
    }
    /**private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {

        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.cactus_buddy.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.cactus_buddy.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;

    }
    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState) {
        if(this.swinging){// && tAnimationState.getController().getAnimationState().equals(AnimationState)) {
            //event.getController().markNeedsReload();
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.cactus_buddy.attack", Animation.LoopType.PLAY_ONCE));
        }
            return PlayState.CONTINUE;

    }
**/
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }



    /**
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController<>(this,"attackController",0,this::attackPredicate));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
**/
}
