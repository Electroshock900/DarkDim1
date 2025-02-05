package net.voidless.voidless.item.weapons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.voidless.voidless.util.ModMaterials;
import net.voidless.voidless.util.ModParticles;


public class DestroyerAxe extends AxeItem {


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        double posX = player.getX();
        double posY = player.getY();
        double posZ = player.getZ();
        //double posX2 = livingEntity.getX() * livingEntity.getScale();
        level.addParticle(ModParticles.GHOSTLY_FLAME_FX.get(),posX,posY,posZ,6,6,6
        );
        return super.use(level,player,hand);
    }

    public DestroyerAxe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(ModMaterials.DARKNESS, new Properties().fireResistant()
        );
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int p_41415_) {
        super.releaseUsing(itemStack, level, livingEntity, p_41415_);

//livingEntity.addEffect(new MobEffectInstance(EffectsRegistry.ECTO_PYRO.get(), 49));
        //this.canPerformAction(this, ToolActions.SWORD_SWEEP)
    }

}
