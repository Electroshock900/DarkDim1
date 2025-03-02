package net.voidless.voidless.blocks.types;


import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.voidless.voidless.util.ModParticles;

public class BloodDripBlock extends Block {


    public BloodDripBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        pLevel.addParticle(ModParticles.DRIPPING_BLOOD.get()
                ,pPos.getX(),pPos.getY()+1,pPos.getZ()
                , (float) Math.random(),-0.3F,((float) Math.random()));
    }
}
