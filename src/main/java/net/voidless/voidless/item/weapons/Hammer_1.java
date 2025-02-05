package net.voidless.voidless.item.weapons;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Hammer_1 extends Item {
    public Hammer_1(Properties properties) {
        super(properties);
    }

    //Use an axisalignedBB and then poll for the intersecting blocks within the box to get a list of things to break


    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        final int PosX = pos.getX();
        final int PosY = pos.getY();
        final int PosZ = pos.getZ();
        //final Block XU = pos.relative(Direction.UP,3);
        //final Block XD = pos.relative(Direction.DOWN,3);
        //final Block XR = pos.relative(Direction.NORTH,3);
       // final Block XL = pos.relative(Direction.SOUTH,3).;
        return super.mineBlock(stack, level, state, pos, entity);
    }
}
