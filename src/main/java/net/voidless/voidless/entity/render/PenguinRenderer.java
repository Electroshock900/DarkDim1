package net.voidless.voidless.entity.render;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.PenguinEntity;
import net.voidless.voidless.entity.model.Penguin_Model;

public class PenguinRenderer extends MobRenderer<PenguinEntity, Penguin_Model<PenguinEntity>> {
    public PenguinRenderer(EntityRendererProvider.Context context) {
        super(context, new Penguin_Model<>(context.bakeLayer(Penguin_Model.LAYER_LOCATION)),0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity p_114482_) {
        return ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/penguin.png");
    }
    @Override
    public void render(PenguinEntity penguin, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        if(penguin.isBaby()) {
            pStack.scale(0.5f, 0.5f, 0.5f);
        }else{pStack.scale(1f,1f,1f);

        }
        super.render(penguin, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
