package net.voidless.voidless.entity.render;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.entity.custom.MO;
import net.voidless.voidless.entity.model.MO_Model;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MO_Renderer extends GeoEntityRenderer<MO>{
        //MobRenderer<MO, MO_Model<MO>> {
    public MO_Renderer(EntityRendererProvider.Context context){
        super(context, new MO_Model());//(context.bakeLayer(MO_Model.LAYER_LOCATION)),2.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(MO cb) {
        return MO_Model.texture;//ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/eyeball_monster2.png");
    }

    @Override
    public void render(MO pEntity, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        pStack.scale(2f, 2f, 2f);
        if(pEntity.isBaby()) {
            pStack.scale(0.5f,0.5f,0.5f);
        }
        super.render(pEntity, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
