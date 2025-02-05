package net.voidless.voidless.entity.render;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.MantaRayEntity;
import net.voidless.voidless.entity.model.Manta_Ray_Model;

public class Manta_Ray_Renderer extends MobRenderer<MantaRayEntity, Manta_Ray_Model<MantaRayEntity>> {
    public Manta_Ray_Renderer(EntityRendererProvider.Context context){
        super(context, new Manta_Ray_Model<>(context.bakeLayer(Manta_Ray_Model.LAYER_LOCATION)),0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(MantaRayEntity cb) {
        return ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/manta_ray.png");
    }

    @Override
    public void render(MantaRayEntity cactusBuddy, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        if(cactusBuddy.isBaby()) {
            pStack.scale(0.2f, 0.2f, 0.2f);
        }else{pStack.scale(0.6f,0.6f,0.6f);

        }
        super.render(cactusBuddy, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}

