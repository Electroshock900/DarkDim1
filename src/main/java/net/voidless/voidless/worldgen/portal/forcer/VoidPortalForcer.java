package net.voidless.voidless.worldgen.portal.forcer;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalForcer;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.util.ModPoiTypes;
import net.voidless.voidless.worldgen.portal.DeathPortalBlock_Current;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class VoidPortalForcer extends PortalForcer{
        public static final int TICKET_RADIUS = 3;
        private static final int DARKSIDE_PORTAL_RADIUS = 16;
        private static final int OVERWORLD_PORTAL_RADIUS = 128;
        private static final int FRAME_HEIGHT = 5;
        private static final int FRAME_WIDTH = 4;
        private static final int FRAME_BOX = 3;
        private static final int FRAME_HEIGHT_START = -1;
        private static final int FRAME_HEIGHT_END = 4;
        private static final int FRAME_WIDTH_START = -1;
        private static final int FRAME_WIDTH_END = 3;
        private static final int FRAME_BOX_START = -1;
        private static final int FRAME_BOX_END = 2;
        private static final int NOTHING_FOUND = -1;
        protected final ServerLevel level;

    public VoidPortalForcer(ServerLevel pLevel) {
        super(pLevel);
        this.level=pLevel;
    }/*
    @Override
    public Optional<BlockPos> findClosestPortalPosition(BlockPos exitPos, boolean isDarkSide, WorldBorder worldBorder) {
        PoiManager poiManager = this.level.getPoiManager();
        int searchRadius = 164; // isDarkSide ? 16 : 128;
        poiManager.ensureLoadedAndValid(this.level, exitPos, searchRadius);
        Stream<BlockPos> portalPositionsStream = poiManager.getInSquare((poiType) -> {
            return poiType.is(ModPoiTypes.DARKSIDE_PORTAL);
        }, exitPos, searchRadius, PoiManager.Occupancy.ANY).map(PoiRecord::getPos);


        Objects.requireNonNull(worldBorder);
        return portalPositionsStream.filter(worldBorder::isWithinBounds).filter((pos) -> {
            return this.level.getBlockState(pos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
        }).min(Comparator.comparingDouble((pos2) -> {
            return pos2.distSqr(exitPos);
        }));
        //.thenComparingInt(Vec3i::getY));
    }*/
   // @Override
    public Optional<BlockPos> fin2dClosestPortalPosition(BlockPos pExitPos, boolean pIsDarkSide, WorldBorder pWorldBorder) {
        PoiManager $$3 = this.level.getPoiManager();
        int $$4 = pIsDarkSide ? 16 : 100;//pIsDarkSide ? 16 : 128;
        $$3.ensureLoadedAndValid(this.level, pExitPos, $$4);
        Stream<BlockPos> var10000 = $$3.getInSquare((p_230634_) -> {
            return p_230634_.is(ModPoiTypes.DARKSIDE_PORTAL);
        }, pExitPos, $$4, PoiManager.Occupancy.ANY).map(PoiRecord::getPos);

        Objects.requireNonNull(pWorldBorder);
        return var10000.filter(pWorldBorder::isWithinBounds).filter((pos) -> {
            return this.level.getBlockState(pos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
        }).min(Comparator.comparingDouble((pos) -> {
            return pos.distSqr(pExitPos);
        })
                /*.thenComparingInt(Vec3i::getY)*/
        );

    }
@Override
    public Optional<BlockPos>  findClosestPortalPosition(BlockPos pExitPos, boolean pIsDarkSide, WorldBorder pWorldBorder) {
        PoiManager $$3 = this.level.getPoiManager();
        int $$4 = pIsDarkSide ? 16 : 128;
        $$3.ensureLoadedAndValid(this.level, pExitPos, $$4);
        Stream<BlockPos> var10000 = $$3.getInSquare((p_230634_) -> {
            return p_230634_.is(ModPoiTypes.DARKSIDE_PORTAL);
        }, pExitPos, $$4, PoiManager.Occupancy.ANY).map(PoiRecord::getPos);

        Objects.requireNonNull(pWorldBorder);
        return var10000.filter(pWorldBorder::isWithinBounds).filter((pos) -> {
            return this.level.getBlockState(pos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
        }).min(Comparator.comparingDouble((pos) -> {
            return pos.distSqr(pExitPos);
        })
        );
        //.thenComparingInt(Vec3i::getY));
    }
@Override
    public  Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pPos, Direction.Axis pAxis) {
        Direction $$2 = Direction.get(Direction.AxisDirection.POSITIVE, pAxis);
        double $$3 = -1.0;
        BlockPos $$4 = null;
        double $$5 = -1.0;
        BlockPos $$6 = null;
        WorldBorder $$7 = this.level.getWorldBorder();
        int $$8 = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
        int $$9 = 1;
        BlockPos.MutableBlockPos $$10 = pPos.mutable();
        Iterator var14 = BlockPos.spiralAround(pPos, 16, Direction.EAST, Direction.SOUTH).iterator();

        while(true) {
            BlockPos.MutableBlockPos $$11;
            int $$28;
            int $$13;
            int $$21;
            int $$15;
            do {
                do {
                    if (!var14.hasNext()) {
                        if ($$3 == -1.0 && $$5 != -1.0) {
                            $$4 = $$6;
                            $$3 = $$5;
                        }

                        int $$24;
                        int $$27;
                        if ($$3 == -1.0) {
                            $$24 = Math.max(this.level.getMinBuildHeight() - -1, 70);
                            $$27 = $$8 - 9;
                            if ($$27 < $$24) {
                                return Optional.empty();
                            }

                            $$4 = (new BlockPos(pPos.getX() - $$2.getStepX() * 1, Mth.clamp(pPos.getY(), $$24, $$27), pPos.getZ() - $$2.getStepZ() * 1)).immutable();
                            $$4 = $$7.clampToBounds($$4);
                            Direction $$19 = $$2.getClockWise();

                            for($$13 = -1; $$13 < 2; ++$$13) {
                                for($$21 = 0; $$21 < 2; ++$$21) {
                                    for($$15 = -1; $$15 < 3; ++$$15) {
                                        BlockState $$23 = $$15 < 0 ? ModBlocks.BLOOD_STONE.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
                                        $$10.setWithOffset($$4, $$21 * $$2.getStepX() + $$13 * $$19.getStepX(), $$15, $$21 * $$2.getStepZ() + $$13 * $$19.getStepZ());
                                        this.level.setBlockAndUpdate($$10, $$23);
                                    }
                                }
                            }
                        }

                        for($$24 = -1; $$24 < 3; ++$$24) {
                            for($$27 = -1; $$27 < 4; ++$$27) {
                                if ($$24 == -1 || $$24 == 2 || $$27 == -1 || $$27 == 3) {
                                    $$10.setWithOffset($$4, $$24 * $$2.getStepX(), $$27, $$24 * $$2.getStepZ());
                                    this.level.setBlock($$10, ModBlocks.BLOOD_STONE.get().defaultBlockState(), 3);
                                }
                            }
                        }

                        BlockState $$26 = (BlockState)ModBlocks.VOID_PORTAL.get().defaultBlockState().setValue(DeathPortalBlock_Current.AXIS, pAxis);

                        for($$27 = 0; $$27 < 2; ++$$27) {
                            for($$28 = 0; $$28 < 3; ++$$28) {
                                $$10.setWithOffset($$4, $$27 * $$2.getStepX(), $$28, $$27 * $$2.getStepZ());
                                this.level.setBlock($$10, $$26, 18);
                            }
                        }

                        return Optional.of(new BlockUtil.FoundRectangle($$4.immutable(), 2, 3));
                    }

                    $$11 = (BlockPos.MutableBlockPos)var14.next();
                    $$28 = Math.min($$8, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, $$11.getX(), $$11.getZ()));
                } while(!$$7.isWithinBounds($$11));
            } while(!$$7.isWithinBounds($$11.move($$2, 1)));

            $$11.move($$2.getOpposite(), 1);

            for($$13 = $$28; $$13 >= this.level.getMinBuildHeight(); --$$13) {
                $$11.setY($$13);
                if (this.canPortalReplaceBlock($$11)) {
                    for($$21 = $$13; $$13 > this.level.getMinBuildHeight() && this.canPortalReplaceBlock($$11.move(Direction.DOWN)); --$$13) {
                    }

                    if ($$13 + 4 <= $$8) {
                        $$15 = $$21 - $$13;
                        if ($$15 <= 0 || $$15 >= 3) {
                            $$11.setY($$13);
                            if (canHostFrame($$11, $$10, $$2, 0)) {
                                double $$16 = pPos.distSqr($$11);
                                if (this.canHostFrame($$11, $$10, $$2, -1) && this.canHostFrame($$11, $$10, $$2, 1) && ($$3 == -1.0 || $$3 > $$16)) {
                                    $$3 = $$16;
                                    $$4 = $$11.immutable();
                                }

                                if ($$3 == -1.0 && ($$5 == -1.0 || $$5 > $$16)) {
                                    $$5 = $$16;
                                    $$6 = $$11.immutable();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pPos) {
        BlockState $$1 = this.level.getBlockState(pPos);
        return $$1.canBeReplaced() && $$1.getFluidState().isEmpty();
    }

    private boolean canHostFrame(BlockPos pOriginalPos, BlockPos.MutableBlockPos pOffsetPos, Direction pDirection, int pOffsetScale) {
        Direction $$4 = pDirection.getClockWise();

        for(int $$5 = -1; $$5 < 3; ++$$5) {
            for(int $$6 = -1; $$6 < 4; ++$$6) {
                pOffsetPos.setWithOffset(pOriginalPos, pDirection.getStepX() * $$5 + $$4.getStepX() * pOffsetScale, $$6, pDirection.getStepZ() * $$5 + $$4.getStepZ() * pOffsetScale);
                if ($$6 < 0 && !this.level.getBlockState(pOffsetPos).isSolid()) {
                    return false;
                }

                if ($$6 >= 0 && !this.canPortalReplaceBlock(pOffsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }


}
