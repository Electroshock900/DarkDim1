package net.voidless.voidless.worldgen.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.voidless.voidless.worldgen.dimension.ModDimensions;

public class ModPortalBlock extends Block {
    public ModPortalBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        //handleKaupenPortal(pPlayer,pPos);
        return InteractionResult.SUCCESS;
        /*if (pPlayer.canChangeDimensions()) {
            handleKaupenPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }*/
    }

    private void handleKaupenPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.DEATH_DIM_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.DEATH_DIM_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.DEATH_DIM_LEVEL_KEY) {
                    //player.changeDimension(portalDimension, new ModTeleporter(pPos, true));
                    player.changeDimension(ModTeleporter.createTransition(player,minecraftserver.getLevel(Level.OVERWORLD),pPos,true));
                } else {
                    player.changeDimension(ModTeleporter.createTransition(player,minecraftserver.getLevel(ModDimensions.DEATH_DIM_LEVEL_KEY),pPos,true));
                    //player.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                }
            }
        }
    }

}
