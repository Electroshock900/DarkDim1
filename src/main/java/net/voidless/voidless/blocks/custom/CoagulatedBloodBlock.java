package net.voidless.voidless.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.voidless.voidless.util.ModBlocks;

import javax.annotation.Nullable;

public class CoagulatedBloodBlock extends Block {
    public static final MapCodec<CoagulatedBloodBlock> CODEC = simpleCodec(CoagulatedBloodBlock::new);

    public MapCodec<? extends CoagulatedBloodBlock> codec() {
        return CODEC;
    }

    public CoagulatedBloodBlock(BlockBehaviour.Properties p_54155_) {
        super(p_54155_);
    }

    public static BlockState meltsInto() {
        return ModBlocks.BLOOD_BLOCK.get().defaultBlockState();
    }

    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack) {
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pTe, pStack);
        if (!EnchantmentHelper.hasTag(pStack, EnchantmentTags.PREVENTS_ICE_MELTING)) {
            if (pLevel.dimensionType().ultraWarm()) {
                pLevel.removeBlock(pPos, false);
                return;
            }

            BlockState $$6 = pLevel.getBlockState(pPos.below());
            if ($$6.blocksMotion() || $$6.liquid()) {
                pLevel.setBlockAndUpdate(pPos, meltsInto());
            }
        }

    }

    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getBrightness(LightLayer.BLOCK, pPos) > 11 - pState.getLightBlock(pLevel, pPos)) {
            this.melt(pState, pLevel, pPos);
        }

    }

    protected void melt(BlockState pState, Level pLevel, BlockPos pPos) {
        if (pLevel.dimensionType().ultraWarm()) {
            pLevel.removeBlock(pPos, false);
        } else {
            pLevel.setBlockAndUpdate(pPos, meltsInto());
            pLevel.neighborChanged(pPos, meltsInto().getBlock(), pPos);
        }
    }
}
