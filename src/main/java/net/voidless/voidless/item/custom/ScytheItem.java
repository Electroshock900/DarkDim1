package net.voidless.voidless.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ScytheItem extends SwordItem {
    public ScytheItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43272_);
    }

    @Override
    public int getDefaultMaxStackSize() {
        return super.getDefaultMaxStackSize();
    }



    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity shooter, LivingEntity hurt) {


        //livingEntity.attackAnim;
        return super.hurtEnemy(stack, shooter, hurt);

    }
}
