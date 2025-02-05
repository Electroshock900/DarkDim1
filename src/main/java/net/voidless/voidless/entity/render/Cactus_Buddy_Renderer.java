package net.voidless.voidless.entity.render;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.Cactus_Buddy2;
import net.voidless.voidless.entity.model.Cactus_Buddy_Model;

public class Cactus_Buddy_Renderer extends MobRenderer<Cactus_Buddy2, Cactus_Buddy_Model<Cactus_Buddy2>> {
    public Cactus_Buddy_Renderer(EntityRendererProvider.Context context){
        super(context, new Cactus_Buddy_Model<>(context.bakeLayer(Cactus_Buddy_Model.LAYER_LOCATION)),0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(Cactus_Buddy2 cb) {
        return ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/cactus_buddy.png");
    }

    @Override
    public void render(Cactus_Buddy2 cactusBuddy, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        if(cactusBuddy.isBaby()) {
            pStack.scale(2f, 2f, 2f);
        }else{pStack.scale(4f,4f,4f);

        }
        super.render(cactusBuddy, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
