package net.voidless.voidless.blocks.custom.signs;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.voidless.voidless.blockentity.ModSignBlockEntity;

public class ModHangingSignBlock extends CeilingHangingSignBlock {
    public ModHangingSignBlock(WoodType pType, Properties pProperties) {
        super(pType,pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModSignBlockEntity(pPos, pState);
    }
}

