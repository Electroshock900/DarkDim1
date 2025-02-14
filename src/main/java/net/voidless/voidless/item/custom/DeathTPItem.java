package net.voidless.voidless.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.voidless.voidless.worldgen.dimension.ModDimensions;
import net.voidless.voidless.worldgen.portal.ModTeleporter;

public class DeathTPItem extends Item {
    private static ResourceKey<Level> cachedOriginDimension;
    public DeathTPItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.level().isClientSide()){
            //pPlayer.changeDimension(this.getPortalDestination(pPlayer.getServer().getLevel(ModDimensions.DEATH_DIM_LEVEL_KEY), pPlayer,pPlayer.getOnPos()));
            getPortalDestination(pLevel.getServer().getLevel(ModDimensions.DEATH_DIM_LEVEL_KEY),pPlayer,pPlayer.getOnPos());
            //pPlayer.changeDimension(ModTeleporter.createTransition(pPlayer,pLevel.getServer().getLevel(ModDimensions.DEATH_DIM_LEVEL_KEY),pPlayer.getOnPos(),false ));
            //pPlayer.teleportTo(ModDimensions.DEATH_DIM_LEVEL_KEY,pPlayer.xOld,pPlayer.yOld,pPlayer.zOld,new HashSet<>(),0,0);
            //pPlayer.
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
//    @Override
    public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
        if (cachedOriginDimension == null) cachedOriginDimension = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("minecraft:overworld"));
        ResourceKey<Level> newDimension = !level.dimension().location().equals(ModDimensions.DEATH_DIM_TYPE) ? ModDimensions.DEATH_DIM_LEVEL_KEY : cachedOriginDimension;
        ServerLevel serverlevel = level.getServer().getLevel(newDimension);
        if (serverlevel == null) {
            return null;
        } else {
            WorldBorder worldborder = serverlevel.getWorldBorder();
            double d0 = DimensionType.getTeleportationScale(level.dimensionType(), serverlevel.dimensionType());
            BlockPos newPos = worldborder.clampToBounds(pos.getX() * d0, pos.getY(), pos.getZ() * d0);
            return ModTeleporter.createTransition(entity, serverlevel, newPos, false);
        }

    }
}
