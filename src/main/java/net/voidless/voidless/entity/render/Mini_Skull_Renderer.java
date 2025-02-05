package net.voidless.voidless.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.ModModelLayers;
import net.voidless.voidless.entity.custom.Mini_Skull_Entity;
import net.voidless.voidless.entity.model.Mini_Skull_Entity_Model;

public class Mini_Skull_Renderer extends MobRenderer<Mini_Skull_Entity, Mini_Skull_Entity_Model<Mini_Skull_Entity>> {
    public Mini_Skull_Renderer(EntityRendererProvider.Context context){
        super(context, new Mini_Skull_Entity_Model<>(context.bakeLayer(Mini_Skull_Entity_Model.LAYER_LOCATION)),0.4F);
    }


    @Override
    public ResourceLocation getTextureLocation(Mini_Skull_Entity cb) {
        return ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/skull.png");
    }

    @Override
    public void render(Mini_Skull_Entity skull, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        //if(skull.isBaby()) {
            pStack.scale(0.25f, 0.25f, 0.25f);
        //}else{pStack.scale(4f,4f,4f);

        //}
        super.render(skull, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
