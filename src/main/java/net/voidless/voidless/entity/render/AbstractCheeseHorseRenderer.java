//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.voidless.voidless.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.voidless.voidless.entity.custom.CheeseHorse;
import net.voidless.voidless.entity.model.CheeseHorseModel;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractCheeseHorseRenderer<T extends CheeseHorse, M extends CheeseHorseModel<T>> extends MobRenderer<T, M> {
    private final float scale;

    public AbstractCheeseHorseRenderer(EntityRendererProvider.Context pContext, M pModel, float pScale) {
        super(pContext, pModel, 0.75F);
        this.scale = pScale;
    }

    protected void scale(T pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(this.scale, this.scale, this.scale);
        super.scale(pLivingEntity, pPoseStack, pPartialTickTime);
    }
}
