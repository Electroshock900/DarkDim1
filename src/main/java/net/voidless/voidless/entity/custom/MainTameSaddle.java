package net.voidless.voidless.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class MainTameSaddle implements Saddleable, ContainerListener, HasCustomInventoryScreen {
    @Override
    public void containerChanged(Container container) {

    }

    @Override
    public void openCustomInventoryScreen(Player player) {

    }

    @Override
    public boolean isSaddleable() {
        return false;
    }

    @Override
    public void equipSaddle(ItemStack itemStack, @Nullable SoundSource soundSource) {

    }

    @Override
    public SoundEvent getSaddleSoundEvent() {
        return Saddleable.super.getSaddleSoundEvent();
    }

    @Override
    public boolean isSaddled() {
        return false;
    }
}
