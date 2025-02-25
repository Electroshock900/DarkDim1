package net.voidless.voidless.entity.render;


import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.Cactus_Buddy;
import net.voidless.voidless.entity.model.Cactus_Buddy_Model;
import net.voidless.voidless.entity.variants.CactusBuddyVariant;

import java.util.Map;

public class Cactus_Buddy_Renderer extends MobRenderer<Cactus_Buddy, Cactus_Buddy_Model<Cactus_Buddy>> {
    public Cactus_Buddy_Renderer(EntityRendererProvider.Context context){
        super(context, new Cactus_Buddy_Model<>(context.bakeLayer(Cactus_Buddy_Model.LAYER_LOCATION)),0.4F);
    }
    private static final Map<CactusBuddyVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CactusBuddyVariant.class), map -> {
                map.put(CactusBuddyVariant.REGULAR,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/peary/peary_2.png"));
                map.put(CactusBuddyVariant.BLOOD,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/peary/peary_blood.png"));
                map.put(CactusBuddyVariant.DRY,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/peary/peary_old.png"));

            });

    @Override
    public ResourceLocation getTextureLocation(Cactus_Buddy cb) {
        return LOCATION_BY_VARIANT.get(cb.getVariant()); // ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/capybara/capybara_brown.png");
    }

    @Override
    public void render(Cactus_Buddy cactusBuddy, float p_115456_, float p_115457_, PoseStack pStack, MultiBufferSource p_115459_, int p_115460_) {
        if(cactusBuddy.isBaby()) {
            pStack.scale(0.2f, 0.2f, 0.2f);
        }else{pStack.scale(1f,1f,1f);

        }
        super.render(cactusBuddy, p_115456_, p_115457_, pStack, p_115459_, p_115460_);
    }
}
