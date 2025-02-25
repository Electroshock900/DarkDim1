package net.voidless.voidless.entity.render;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.Mo2;
import net.voidless.voidless.entity.model.Mo2_Model;

public class Mo2_Renderer extends MobRenderer<Mo2, Mo2_Model<Mo2>> {
    public Mo2_Renderer(EntityRendererProvider.Context context) {
        super(context, new Mo2_Model<>(context.bakeLayer(Mo2_Model.LAYER_LOCATION)), 1.5F);
    }
       /* private static final Map<Mo2Variant, ResourceLocation> LOCATION_BY_VARIANT =
                Util.make(Maps.newEnumMap(Mo2Variant.class), map -> {
                    map.put(Mo2Variant.SHADOW,
                            ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/mo2/mo2.png"));
                    map.put(Mo2Variant.BONE_VOID,
                            ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/mo2/mo2.png"));
                    map.put(Mo2Variant.VOID,
                            ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/mo2/mo2.png"));

                });*/

    @Override
    public ResourceLocation getTextureLocation(Mo2 cb) {
        return /*LOCATION_BY_VARIANT.get(cb.getVariant());*/ 
                ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/mo2/mo2.png");
    }

    @Override
    public void render(Mo2 cactusBuddy, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        if(cactusBuddy.isBaby()) {
            pStack.scale(1f, 1f, 1f);
        }else{pStack.scale(2f,2f,2f);
        }
        //if(cactusBuddy.has)
        super.render(cactusBuddy, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
