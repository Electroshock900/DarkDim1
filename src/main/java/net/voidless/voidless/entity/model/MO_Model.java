package net.voidless.voidless.entity.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.MO;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class MO_Model extends GeoModel<MO> {

    public ResourceLocation model = ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"geo/mo.geo.json");
    public ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"animations/animation.mo.json");
    public static ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/mo/mo.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "mo_model"), "main");
    @Override
    public ResourceLocation getModelResource(MO eyeballMonster, @Nullable GeoRenderer<MO> renderer) {
        return this.model;
    }

    @Override
    public ResourceLocation getModelResource(MO mo) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(MO animatable, @Nullable GeoRenderer<MO> renderer) {
        return this.texture;
        //super.getTextureResource(animatable, renderer);
    }

    @Override
    public ResourceLocation getTextureResource(MO mo) {
        return this.texture;
    }


    @Override
    public ResourceLocation getAnimationResource(MO eyeballMonster) {
        return this.animations;
    }
}
