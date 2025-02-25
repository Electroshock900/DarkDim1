//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.voidless.voidless.worldgen.portal;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.voidless.voidless.util.ModEntities;
import net.voidless.voidless.worldgen.dimension.ModDimensions;
import net.voidless.voidless.worldgen.portal.forcer.VoidPortalForcer;
import net.voidless.voidless.worldgen.portal.shape.VoidPortalShape;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.Optional;

public class VoidPortalBlock extends Block implements Portal {
    public static final MapCodec<DeathPortalBlock_Current> CODEC = simpleCodec(DeathPortalBlock_Current::new);
    public static final EnumProperty<Direction.Axis> AXIS;
    private static final Logger LOGGER;
    protected static final int AABB_OFFSET = 2;
    protected static final VoxelShape X_AXIS_AABB;
    protected static final VoxelShape Z_AXIS_AABB;

    public MapCodec<DeathPortalBlock_Current> codec() {
        return CODEC;
    }

    public VoidPortalBlock(BlockBehaviour.Properties p_54909_) {
        super(p_54909_);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(AXIS, Axis.X));
    }

    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction.Axis)pState.getValue(AXIS)) {
            case Z:
                return Z_AXIS_AABB;
            case X:
            default:
                return X_AXIS_AABB;
        }
    }

    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.dimensionType().natural() && pLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && pRandom.nextInt(2000) < pLevel.getDifficulty().getId()) {
            while(pLevel.getBlockState(pPos).is(this)) {
                pPos = pPos.below();
            }

            if (pLevel.getBlockState(pPos).isValidSpawn(pLevel, pPos, ModEntities.WAR_TORTOISE_HYBRID.get())) {
                Entity $$4 = ModEntities.WAR_TORTOISE_HYBRID.get().spawn(pLevel, pPos.above(), MobSpawnType.STRUCTURE);
                if ($$4 != null) {
                    $$4.setPortalCooldown();
                }
            }
        }

    }

    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        Direction.Axis $$6 = pFacing.getAxis();
        Direction.Axis $$7 = (Direction.Axis)pState.getValue(AXIS);
        boolean $$8 = $$7 != $$6 && $$6.isHorizontal();
        return !$$8 && !pFacingState.is(this) && !(new VoidPortalShape(pLevel, pCurrentPos, $$7)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity.canUsePortal(false)) {
            pEntity.setAsInsidePortal(this, pPos);
        }

    }

    public int getPortalTransitionTime(ServerLevel pLevel, Entity pEntity) {
        if (pEntity instanceof Player $$2) {
            return Math.max(1, pLevel.getGameRules().getInt($$2.getAbilities().invulnerable ? GameRules.RULE_PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.RULE_PLAYERS_NETHER_PORTAL_DEFAULT_DELAY));
        } else {
            return 0;
        }
    }

    @Nullable
    public DimensionTransition getPortalDestination(ServerLevel pLevel, Entity pEntity, BlockPos pPos) {
        ResourceKey<Level> $$3 = pLevel.dimension() == ModDimensions.DEATH_DIM_LEVEL_KEY ? Level.OVERWORLD : ModDimensions.DEATH_DIM_LEVEL_KEY;
        ServerLevel $$4 = pLevel.getServer().getLevel($$3);
        if ($$4 == null) {
            return null;
        } else {
            boolean $$5 = $$4.dimension() == ModDimensions.DEATH_DIM_LEVEL_KEY;
            WorldBorder $$6 = $$4.getWorldBorder();
            double $$7 = DimensionType.getTeleportationScale(pLevel.dimensionType(), $$4.dimensionType());
            BlockPos $$8 = $$6.clampToBounds(pEntity.getX() * $$7, pEntity.getY(), pEntity.getZ() * $$7);
            return this.getExitPortal($$4, pEntity, pPos, $$8, $$5, $$6);
        }
    }

    @Nullable
    private DimensionTransition getExitPortal(ServerLevel pLevel, Entity pEntity, BlockPos pPos, BlockPos pExitPos, boolean pIsDarkside, WorldBorder pWorldBorder) {
        VoidPortalForcer vpf = new VoidPortalForcer(pLevel);
        Optional<BlockPos> $$6 = vpf.findClosestPortalPosition(pExitPos, pIsDarkside, pWorldBorder);
        BlockUtil.FoundRectangle $$13;
        DimensionTransition.PostDimensionTransition $$14;
        if ($$6.isPresent()) {
            BlockPos $$7 = (BlockPos)$$6.get();
            BlockState $$8 = pLevel.getBlockState($$7);
            $$13 = BlockUtil.getLargestRectangleAround($$7, (Direction.Axis)$$8.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Axis.Y, 21, (p_343533_) -> {
                return pLevel.getBlockState(p_343533_) == $$8;
            });
            $$14 = DimensionTransition.PLAY_PORTAL_SOUND.then((p_343530_) -> {
                p_343530_.placePortalTicket($$7);
            });
        } else {
            Direction.Axis $$11 = (Direction.Axis)pEntity.level().getBlockState(pPos).getOptionalValue(AXIS).orElse(Axis.X);
            VoidPortalForcer vpof = new VoidPortalForcer(pLevel);
            Optional<BlockUtil.FoundRectangle> $$12 = vpof.createPortal(pExitPos, $$11);
            if ($$12.isEmpty()) {
                LOGGER.error("Unable to create a portal, likely target out of worldborder");
                return null;
            }

            $$13 = (BlockUtil.FoundRectangle)$$12.get();
            $$14 = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        }

        return getDimensionTransitionFromExit(pEntity, pPos, $$13, pLevel, $$14);
    }

    private static DimensionTransition getDimensionTransitionFromExit(Entity pEntity, BlockPos pPos, BlockUtil.FoundRectangle pRectangle, ServerLevel pLevel, DimensionTransition.PostDimensionTransition pPostDimensionTransition) {
        BlockState $$5 = pEntity.level().getBlockState(pPos);
        Direction.Axis $$9;
        Vec3 $$10;
        if ($$5.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            $$9 = (Direction.Axis)$$5.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            BlockUtil.FoundRectangle $$7 = BlockUtil.getLargestRectangleAround(pPos, $$9, 21, Axis.Y, 21, (p_342174_) -> {
                return pEntity.level().getBlockState(p_342174_) == $$5;
            });
            $$10 = pEntity.getRelativePortalPosition($$9, $$7);
        } else {
            $$9 = Axis.X;
            $$10 = new Vec3(0.5, 0.0, 0.0);
        }

        return createDimensionTransition(pLevel, pRectangle, $$9, $$10, pEntity, pEntity.getDeltaMovement(), pEntity.getYRot(), pEntity.getXRot(), pPostDimensionTransition);
    }

    private static DimensionTransition createDimensionTransition(ServerLevel pLevel, BlockUtil.FoundRectangle pRectangle, Direction.Axis pAxis, Vec3 pOffset, Entity pEntity, Vec3 pSpeed, float pYRot, float pXRot, DimensionTransition.PostDimensionTransition pPostDimensionTransition) {
        BlockPos $$9 = pRectangle.minCorner;
        BlockState $$10 = pLevel.getBlockState($$9);
        Direction.Axis $$11 = (Direction.Axis)$$10.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Axis.X);
        double $$12 = (double)pRectangle.axis1Size;
        double $$13 = (double)pRectangle.axis2Size;
        EntityDimensions $$14 = pEntity.getDimensions(pEntity.getPose());
        int $$15 = pAxis == $$11 ? 0 : 90;
        Vec3 $$16 = pAxis == $$11 ? pSpeed : new Vec3(pSpeed.z, pSpeed.y, -pSpeed.x);
        double $$17 = (double)$$14.width() / 2.0 + ($$12 - (double)$$14.width()) * pOffset.x();
        double $$18 = ($$13 - (double)$$14.height()) * pOffset.y();
        double $$19 = 0.5 + pOffset.z();
        boolean $$20 = $$11 == Axis.X;
        Vec3 $$21 = new Vec3((double)$$9.getX() + ($$20 ? $$17 : $$19), (double)$$9.getY() + $$18, (double)$$9.getZ() + ($$20 ? $$19 : $$17));
        Vec3 $$22 = VoidPortalShape.findCollisionFreePosition($$21, pLevel, pEntity, $$14);
        return new DimensionTransition(pLevel, $$22, $$16, pYRot + (float)$$15, pXRot, pPostDimensionTransition);
    }

    public Portal.Transition getLocalTransition() {
        return Transition.NONE;
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(100) == 0) {
            pLevel.playLocalSound((double)pPos.getX() + 0.5, (double)pPos.getY() + 0.5, (double)pPos.getZ() + 0.5, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, pRandom.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int $$4 = 0; $$4 < 4; ++$$4) {
            double $$5 = (double)pPos.getX() + pRandom.nextDouble();
            double $$6 = (double)pPos.getY() + pRandom.nextDouble();
            double $$7 = (double)pPos.getZ() + pRandom.nextDouble();
            double $$8 = ((double)pRandom.nextFloat() - 0.5) * 0.5;
            double $$9 = ((double)pRandom.nextFloat() - 0.5) * 0.5;
            double $$10 = ((double)pRandom.nextFloat() - 0.5) * 0.5;
            int $$11 = pRandom.nextInt(2) * 2 - 1;
            if (!pLevel.getBlockState(pPos.west()).is(this) && !pLevel.getBlockState(pPos.east()).is(this)) {
                $$5 = (double)pPos.getX() + 0.5 + 0.25 * (double)$$11;
                $$8 = (double)(pRandom.nextFloat() * 2.0F * (float)$$11);
            } else {
                $$7 = (double)pPos.getZ() + 0.5 + 0.25 * (double)$$11;
                $$10 = (double)(pRandom.nextFloat() * 2.0F * (float)$$11);
            }

            pLevel.addParticle(ParticleTypes.PORTAL, $$5, $$6, $$7, $$8, $$9, $$10);
        }

    }

    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return ItemStack.EMPTY;
    }

    protected BlockState rotate(BlockState pState, Rotation pRot) {
        switch (pRot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis)pState.getValue(AXIS)) {
                    case Z -> {
                        return (BlockState)pState.setValue(AXIS, Axis.X);
                    }
                    case X -> {
                        return (BlockState)pState.setValue(AXIS, Axis.Z);
                    }
                    default -> {
                        return pState;
                    }
                }
            default:
                return pState;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AXIS});
    }

    static {
        AXIS = BlockStateProperties.HORIZONTAL_AXIS;
        LOGGER = LogUtils.getLogger();
        X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
        Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);
    }
}
