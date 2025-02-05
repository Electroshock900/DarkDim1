package net.voidless.voidless.blocks.custom;


import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.voidless.voidless.worldgen.dimension.ModDimensions;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

public class DeathPortalBlockS extends Block implements Portal {
    public static final MapCodec<DeathPortalBlockS> CODEC = simpleCodec(DeathPortalBlockS::new);
    public static final EnumProperty<Direction.Axis> AXIS;
    private static final Logger LOGGER;
    protected static final int AABB_OFFSET = 2;
    protected static final VoxelShape X_AXIS_AABB;
    protected static final VoxelShape Z_AXIS_AABB;
    public DeathPortalBlockS(Properties pProperties) {
        super(pProperties.noCollission());
        //this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(AXIS, Direction.Axis.X));

    }
    public MapCodec<DeathPortalBlockS> codec() {
        return CODEC;
    }





    /*protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction.Axis)pState.getValue(AXIS)) {
            case Z:
                return Z_AXIS_AABB;
            case X:
            default:
                return X_AXIS_AABB;
        }
    }*/


    private void handleHerbMayfairPortal(Entity player, BlockPos pPos) {
        if (player.level().getServer()!=null) {
            MinecraftServer minecraftserver = player.level().getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.DEATH_DIM_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.DEATH_DIM_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.DEATH_DIM_LEVEL_KEY) {
                    player.teleportTo(portalDimension,0D,0D,0D,new HashSet<>(),0f,0f);
                            //changeDimension(new DimensionTransition(serverlevel,player,DimensionTransition.PostDimensionTransition));
                } else {
                    //player.changeDimension(portalDimension);
                }
            }
        }
    }
    private void teleportPlayerToDimension(Player player, ResourceLocation dimensionId) {
        ServerLevel world = player.getServer().overworld();
        ServerLevel targetWorld = world.getServer().getLevel(ModDimensions.DEATH_DIM_LEVEL_KEY);   //Level.OVERWORLD); // Replace with your dimension

        // Check if the target dimension is valid
        if (targetWorld != null) {
            player.changeDimension(Objects.requireNonNull(this.getPortalDestination(targetWorld, player, player.blockPosition())));
        }
    }
    @Override
    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity entity) {
        super.entityInside(pState, pLevel, pPos, entity);
        //entity.teleportTo((ServerLevel)pLevel,entity.getX()+5.0D, entity.getBlockY(), entity.getBlockZ(),Set<RelativeMovements>,13.0F,13.0F);
        //entity.

    }

    @Override
    public int getPortalTransitionTime(ServerLevel pLevel, Entity entity) {
        return Portal.super.getPortalTransitionTime(pLevel, entity);
    }

    @Override
    public DimensionTransition getPortalDestination(ServerLevel serverLevel, Entity entity, BlockPos blockPos) {
        ResourceKey<Level> $$3 = serverLevel.dimension() == Level.END ? Level.OVERWORLD : Level.END;
        ServerLevel $$4 = Objects.requireNonNull(entity.level().getServer().getLevel($$3));
        if ($$4 == null) {
            return null;
        } else {
            boolean $$5 = $$4.dimension() == Registries.levelStemToLevel(ModDimensions.DEATH_DIM_KEY);
            WorldBorder $$6 = $$4.getWorldBorder();
            double $$7 = DimensionType.getTeleportationScale(entity.level().dimensionType(), $$4.dimensionType());
            BlockPos $$8 = $$6.clampToBounds(entity.getX() * $$7, entity.getY(), entity.getZ() * $$7);
            return this.getExitPortal($$4, entity, blockPos, $$8, $$5, $$6);
        }
    }
    @javax.annotation.Nullable
    private DimensionTransition getExitPortal(ServerLevel pLevel, Entity pEntity, BlockPos pPos, BlockPos pExitPos, boolean pIsNether, WorldBorder pWorldBorder) {
        Optional<BlockPos> $$6 = pLevel.getPortalForcer().findClosestPortalPosition(pExitPos, pIsNether, pWorldBorder);
        BlockUtil.FoundRectangle $$13;
        DimensionTransition.PostDimensionTransition $$14;
        if ($$6.isPresent()) {
            BlockPos $$7 = (BlockPos)$$6.get();
            BlockState $$8 = pLevel.getBlockState($$7);
            $$13 = BlockUtil.getLargestRectangleAround($$7, (Direction.Axis)$$8.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (p_343533_) -> {
                return pLevel.getBlockState(p_343533_) == $$8;
            });
            $$14 = DimensionTransition.PLAY_PORTAL_SOUND.then((p_343530_) -> {
                p_343530_.placePortalTicket($$7);
            });
        } else {
            Direction.Axis $$11 = (Direction.Axis)pEntity.level().getBlockState(pPos).getOptionalValue(AXIS).orElse(Direction.Axis.X);
            Optional<BlockUtil.FoundRectangle> $$12 = pLevel.getPortalForcer().createPortal(pExitPos, $$11);
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
            BlockUtil.FoundRectangle $$7 = BlockUtil.getLargestRectangleAround(pPos, $$9, 21, Direction.Axis.Y, 21, (p_342174_) -> {
                return pEntity.level().getBlockState(p_342174_) == $$5;
            });
            $$10 = pEntity.getRelativePortalPosition($$9, $$7);
        } else {
            $$9 = Direction.Axis.X;
            $$10 = new Vec3(0.5, 0.0, 0.0);
        }

        return createDimensionTransition(pLevel, pRectangle, $$9, $$10, pEntity, pEntity.getDeltaMovement(), pEntity.getYRot(), pEntity.getXRot(), pPostDimensionTransition);
    }

    private static DimensionTransition createDimensionTransition(ServerLevel pLevel, BlockUtil.FoundRectangle pRectangle, Direction.Axis pAxis, Vec3 pOffset, Entity pEntity, Vec3 pSpeed, float pYRot, float pXRot, DimensionTransition.PostDimensionTransition pPostDimensionTransition) {
        BlockPos $$9 = pRectangle.minCorner;
        BlockState $$10 = pLevel.getBlockState($$9);
        Direction.Axis $$11 = (Direction.Axis)$$10.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
        double $$12 = (double)pRectangle.axis1Size;
        double $$13 = (double)pRectangle.axis2Size;
        EntityDimensions $$14 = pEntity.getDimensions(pEntity.getPose());
        int $$15 = pAxis == $$11 ? 0 : 90;
        Vec3 $$16 = pAxis == $$11 ? pSpeed : new Vec3(pSpeed.z, pSpeed.y, -pSpeed.x);
        double $$17 = (double)$$14.width() / 2.0 + ($$12 - (double)$$14.width()) * pOffset.x();
        double $$18 = ($$13 - (double)$$14.height()) * pOffset.y();
        double $$19 = 0.5 + pOffset.z();
        boolean $$20 = $$11 == Direction.Axis.X;
        Vec3 $$21 = new Vec3((double)$$9.getX() + ($$20 ? $$17 : $$19), (double)$$9.getY() + $$18, (double)$$9.getZ() + ($$20 ? $$19 : $$17));
        Vec3 $$22 = PortalShape.findCollisionFreePosition($$21, pLevel, pEntity, $$14);
        return new DimensionTransition(pLevel, $$22, $$16, pYRot + (float)$$15, pXRot, pPostDimensionTransition);
    }

    public Portal.Transition getLocalTransition() {
        return Transition.CONFUSION;
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

            //pLevel.addParticle(ParticleTypes.PORTAL, $$5, $$6, $$7, $$8, $$9, $$10);
            pLevel.addParticle(ParticleTypes.FLAME, 0, 0, 0, 0.5D, 0.5D, 0.5D);
            pLevel.addParticle(ParticleTypes.FLAME, $$5, $$6, $$7, $$8, $$9, $$10);
        }

    }

    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return ItemStack.EMPTY;
    }

    static {
        AXIS = BlockStateProperties.HORIZONTAL_AXIS;
        LOGGER = LogUtils.getLogger();
        X_AXIS_AABB = Block.box(0.0, 0.0, 13.0, 23.0, 23.0, 130.0);
        Z_AXIS_AABB = Block.box(13.0, 0.0, 0.0, 13.0, 23.0, 23.0);
    }
}
