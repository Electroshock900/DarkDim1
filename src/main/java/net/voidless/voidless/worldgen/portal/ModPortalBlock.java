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
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.worldgen.dimension.ModDimensions;

public class ModPortalBlock extends Block {
    public ModPortalBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        handleKaupenPortal(pPlayer,pPos);
        if (pPlayer.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
        //if (pPlayer.canChangeDimensions(pLevel,)) {
            handleKaupenPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            VoidlessMod.LOGGER.error("FAILED");
            return InteractionResult.CONSUME;
            //return InteractionResult.SUCCESS;
        }
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
                    player.changeDimension(ModTeleporter.createTransition(player,portalDimension,pPos,true));
                    //player.teleportTo(portalDimension,0,164,0, Set.of(new RelativeMovement[]{}),0.0F,0.0F);

                //player.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                }
            }
        }
    }

}
