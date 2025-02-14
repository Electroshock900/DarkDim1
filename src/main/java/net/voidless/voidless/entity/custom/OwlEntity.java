package net.voidless.voidless.entity.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.voidless.voidless.entity.variants.OwlVariant;
import net.voidless.voidless.util.ModEntities;
import org.jetbrains.annotations.Nullable;

public class OwlEntity extends Animal implements FlyingAnimal {

    /*private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(OwlEntity.class, EntityDataSerializers.BOOLEAN);*/
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(OwlEntity.class, EntityDataSerializers.INT);


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
        /**if(this.isAttacking()&&attackAnimationTimeout<=0){
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

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public OwlVariant getVariant() {
        return OwlVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(OwlVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(VARIANT, pCompound.getInt("Variant"));
    }
    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getTypeVariant());
    }
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANT,0);
    }
    public OwlEntity(EntityType<? extends Animal> pType, Level level) {
        super(pType, level);
        this.moveControl = new FlyingMoveControl(this, 10, false);
        //this.moveControl = new OwlEntity.FishMoveControl(this);
    }


    public static AttributeSupplier.Builder setAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,9D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED,0.2F)
                .add(Attributes.FLYING_SPEED, 0.47F);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(2,new CactusBuddyMeleeAttackGoal(this,1.0D,true));
        this.goalSelector.addGoal(2,new OwlEntity.OwlWanderGoal(this, 2.0D));
        this.goalSelector.addGoal(2,new RandomStrollGoal(this, 1.0D) );
        this.goalSelector.addGoal(3,new BreedGoal(this, 1.12D));
        this.goalSelector.addGoal(3,new TemptGoal(this,2, Ingredient.of(Tags.Items.SEEDS), false));

        //this.goalSelector.addGoal(2, new MeleeAttackGoal(this,1.2D,false));
        //this.goalSelector.addGoal(1,new RangedAttackGoal(this,3.0D,30,3.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //this.goalSelector.addGoal(2,new RandomSwimmingGoal(this, 2.0D,14) );
        //this.goalSelector.addGoal(2, new FishSwimGoal(this));
        /**
         this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

         this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false, (p_29932_) -> {
            return p_29932_ instanceof Creeper;
        //this.goalSelector.addGoal(3, new );
        }));**/

    }
    @Override
    public boolean canBeLeashed(){
        return false;
    }
    public boolean isFood(ItemStack itemStack)
    {if(itemStack== Items.SWEET_BERRIES.getDefaultInstance()){
        return true;//super.canBeLeashed(p_27406_);
    }else{return false;}
    }
    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.OWL.get().create(serverLevel);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
                                        MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        OwlVariant variant = Util.getRandom(OwlVariant.values(), this.random);
        this.setVariant(variant);
        //this.resetLastPoseChangeTickToFullStand(pLevel.getLevel().getGameTime());
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    static class OwlWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public OwlWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @Nullable
        protected Vec3 getPosition() {
            Vec3 vec3 = null;
            if (this.mob.isInWater()) {
                vec3 = LandRandomPos.getPos(this.mob, 15, 15);
            }

            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3 = this.getTreePos();
            }

            return vec3 == null ? super.getPosition() : vec3;
        }

        @Nullable
        private Vec3 getTreePos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

            for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 3.0D), Mth.floor(this.mob.getY() - 6.0D), Mth.floor(this.mob.getZ() - 3.0D), Mth.floor(this.mob.getX() + 3.0D), Mth.floor(this.mob.getY() + 6.0D), Mth.floor(this.mob.getZ() + 3.0D))) {
                if (!blockpos.equals(blockpos1)) {
                    BlockState blockstate = this.mob.level().getBlockState(blockpos$mutableblockpos1.setWithOffset(blockpos1, Direction.DOWN));
                    boolean flag = blockstate.getBlock() instanceof LeavesBlock || blockstate.is(BlockTags.LOGS);
                    if (flag && this.mob.level().isEmptyBlock(blockpos1) && this.mob.level().isEmptyBlock(blockpos$mutableblockpos.setWithOffset(blockpos1, Direction.UP))) {
                        return Vec3.atBottomCenterOf(blockpos1);
                    }
                }
            }

            return null;
        }
    }


}
