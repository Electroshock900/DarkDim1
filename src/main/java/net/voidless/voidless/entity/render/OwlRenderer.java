package net.voidless.voidless.entity.render;


import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.OwlEntity;
import net.voidless.voidless.entity.model.Owl_Model;
import net.voidless.voidless.entity.variants.OwlVariant;

import java.util.Map;

public class OwlRenderer extends MobRenderer<OwlEntity, Owl_Model<OwlEntity>> {
    public OwlRenderer(EntityRendererProvider.Context context) {
        super(context, new Owl_Model<>(context.bakeLayer(Owl_Model.LAYER_LOCATION)),0.4F);
    }

    private static final Map<OwlVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(OwlVariant.class), map -> {
                map.put(OwlVariant.MUD,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/owl/owl_reg.png"));
                map.put(OwlVariant.MUD_HORNED,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/owl/owl_reg_horned.png"));
                map.put(OwlVariant.BONE,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/owl/owl_snow.png"));
                map.put(OwlVariant.BONE_HORNED,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/owl/owl_snow_horned.png"));
            });

    @Override
    public ResourceLocation getTextureLocation(OwlEntity cb) {
        return LOCATION_BY_VARIANT.get(cb.getVariant()); //ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/cactus_buddy.png");
    }
    @Override
    public void render(OwlEntity owl, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        if(owl.isBaby()) {
            pStack.scale(0.5f, 0.5f, 0.5f);
        }else{pStack.scale(1f,1f,1f);

        }
        super.render(owl, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
