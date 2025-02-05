package net.voidless.voidless.entity.render;


import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.entity.custom.SeatEntity;

public class SeatRenderer extends EntityRenderer<SeatEntity> {
    public SeatRenderer(EntityRendererProvider.Context context){
        super(context);//, new Cactus_Buddy_Model<>(context.bakeLayer(Cactus_Buddy_Model.LAYER_LOCATION)),0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity cb) {
        return null;//ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"textures/entity/custom/cactus_buddy.png");
    }

    @Override
    public boolean shouldRender(SeatEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }

}
