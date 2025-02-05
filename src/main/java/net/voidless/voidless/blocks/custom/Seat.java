package net.voidless.voidless.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.voidless.voidless.entity.custom.SeatEntity;
import net.voidless.voidless.util.ModEntities;

import java.util.List;

public class Seat extends HorizontalDirectionalBlock {
    public static final MapCodec<Seat> CODEC = simpleCodec(Seat::new);

    protected Seat(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if(!pLevel.isClientSide) {
            Entity seatEntity =null;
            List<SeatEntity> seats = pLevel.getEntities(ModEntities.SEAT.get(), new AABB(pPos), seat ->true);
            if(seats.isEmpty()) {
                seatEntity = ModEntities.SEAT.get().spawn((ServerLevel) pLevel, pPos, MobSpawnType.TRIGGERED);
            }else {
                    seatEntity = seats.get(0);
                }

                pPlayer.startRiding(seatEntity);

            }

        return InteractionResult.SUCCESS;//super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
    }


    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
