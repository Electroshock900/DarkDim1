package net.voidless.voidless.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.model.Chakram_Model;
import net.voidless.voidless.entity.model.TChakram_Model;
import net.voidless.voidless.entity.model.TomahawkProjectileModel;
import net.voidless.voidless.entity.projectiles.ChakramEntity;
import net.voidless.voidless.entity.projectiles.TomahawkProjectileEntity;

public class Chakram_Renderer extends EntityRenderer<ChakramEntity> {
    private TChakram_Model model;

    public Chakram_Renderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new TChakram_Model<>(pContext.bakeLayer(TChakram_Model.LAYER_LOCATION));
    }

    @Override
    public void render(ChakramEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        if(!pEntity.isGrounded()) {
            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.yRotO, pEntity.getYRot())));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.getRenderingRotation() * 15f));
            poseStack.translate(0, -1.0f, 0);
        } else {
            poseStack.mulPose(Axis.YP.rotationDegrees(pEntity.groundedOffset.y));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.groundedOffset.x));
            poseStack.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)),false, false);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ChakramEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "textures/entity/chakram/chakram3.png");
    }
}
