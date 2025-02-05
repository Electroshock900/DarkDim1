package net.voidless.voidless.entity.render;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.CheeseHorse;
import net.voidless.voidless.entity.model.CheeseHorseModel;
import net.voidless.voidless.entity.variants.CheeseHorseVariant;
import net.voidless.voidless.entity.ModModelLayers;

import java.util.Map;

public class CheeseHorseRenderer extends AbstractCheeseHorseRenderer<CheeseHorse, CheeseHorseModel<CheeseHorse>> {
    private static final Map<CheeseHorseVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CheeseHorseVariant.class), map -> {
                map.put(CheeseHorseVariant.SHADOW,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/horse/horse_shadow.png"));
                map.put(CheeseHorseVariant.BONE_VOID,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/horse/horse_bone_void.png"));
                map.put(CheeseHorseVariant.VOID,
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/horse/horse_shadow_void.png"));

            });

    public CheeseHorseRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CheeseHorseModel<>(pContext.bakeLayer(ModModelLayers.CHEESE_HORSE_LAYER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(CheeseHorse capybaraEntity) {
        return LOCATION_BY_VARIANT.get(capybaraEntity.getVariant()); // ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/capybara/capybara_brown.png");
    }

    @Override
    public void render(CheeseHorse pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }else{pPoseStack.scale(2f,2f,2f);
        };

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
