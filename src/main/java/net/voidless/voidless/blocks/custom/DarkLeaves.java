package net.voidless.voidless.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DarkLeaves extends LeavesBlock {
    public DarkLeaves(Properties p_54422_) {
        super(p_54422_);
    }
    public void animateTick(BlockState p_272714_, Level p_272837_, BlockPos p_273218_, RandomSource p_273360_) {
        super.animateTick(p_272714_, p_272837_, p_273218_, p_273360_);
        if (p_273360_.nextInt(10) == 0) {
            BlockPos blockpos = p_273218_.below();
            BlockState blockstate = p_272837_.getBlockState(blockpos);
            if (!isFaceFull(blockstate.getCollisionShape(p_272837_, blockpos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(p_272837_, p_273218_, p_273360_, ParticleTypes.CHERRY_LEAVES);
            }
        }
    }
}
