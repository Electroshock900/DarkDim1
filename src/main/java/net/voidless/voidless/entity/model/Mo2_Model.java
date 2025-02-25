package net.voidless.voidless.entity.model;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.animation.Mo2Animation;
import net.voidless.voidless.entity.custom.Mo2;

public class Mo2_Model<T extends Mo2> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "mo2"), "main");
	private final ModelPart Mo_EntityModel;
	private final ModelPart Body_Main;
	private final ModelPart Body_Lower;
	private final ModelPart Body_Upper;
	private final ModelPart Tail;
	private final ModelPart Tail_2;
	private final ModelPart Left_Leg;
	private final ModelPart Right_Leg;
	private final ModelPart Heads;
	private final ModelPart Head_C;
	private final ModelPart Head_R;
	private final ModelPart Head_L;

	public Mo2_Model(ModelPart root) {
		this.Mo_EntityModel = root.getChild("Mo_EntityModel");
		this.Body_Main = this.Mo_EntityModel.getChild("Body_Main");
		this.Body_Lower = this.Body_Main.getChild("Body_Lower");
		this.Body_Upper = this.Body_Lower.getChild("Body_Upper");
		this.Tail = this.Body_Lower.getChild("Tail");
		this.Tail_2 = this.Tail.getChild("Tail_2");
		this.Left_Leg = this.Body_Lower.getChild("Left_Leg");
		this.Right_Leg = this.Body_Lower.getChild("Right_Leg");
		this.Heads = this.Body_Lower.getChild("Heads");
		this.Head_C = this.Heads.getChild("Head_C");
		this.Head_R = this.Heads.getChild("Head_R");
		this.Head_L = this.Heads.getChild("Head_L");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Mo_EntityModel = partdefinition.addOrReplaceChild("Mo_EntityModel", CubeListBuilder.create(), PartPose.offset(0.0F, 22.5F, 0.0F));

		PartDefinition Body_Main = Mo_EntityModel.addOrReplaceChild("Body_Main", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_Lower = Body_Main.addOrReplaceChild("Body_Lower", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 0.0F));

		PartDefinition Body_Upper = Body_Lower.addOrReplaceChild("Body_Upper", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Tail = Body_Lower.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 1.0F));

		PartDefinition Tail_2 = Tail.addOrReplaceChild("Tail_2", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.5F));

		PartDefinition Left_Leg = Body_Lower.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(5, 23).addBox(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 3.5F, 0.0F));

		PartDefinition Right_Leg = Body_Lower.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(24, 6).addBox(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 3.5F, 0.0F));

		PartDefinition Heads = Body_Lower.addOrReplaceChild("Heads", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition Head_C = Heads.addOrReplaceChild("Head_C", CubeListBuilder.create().texOffs(16, 18).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition Head_R = Heads.addOrReplaceChild("Head_R", CubeListBuilder.create().texOffs(18, 9).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.5F, 0.0F));

		PartDefinition Head_L = Heads.addOrReplaceChild("Head_L", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Mo2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(Mo2Animation.mo2walk,limbSwing,limbSwingAmount,2f,1.0f);
		this.animate(((Mo2) entity).idleAnimationState,Mo2Animation.mo2idle,2.5f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.Head_L.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Head_L.xRot = pHeadPitch * ((float)Math.PI / 180F);
		this.Head_C.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Head_C.xRot = pHeadPitch * ((float)Math.PI / 180F);
		this.Head_R.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Head_R.xRot = -pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Mo_EntityModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return Body_Main;
	}

}