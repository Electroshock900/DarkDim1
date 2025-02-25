package net.voidless.voidless.entity.model;// Made with Blockbench 4.8.3
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
import net.minecraft.world.entity.Entity;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.animations.ModAnimationDefinitions;
import net.voidless.voidless.entity.custom.Cactus_Buddy;

public class Cactus_Buddy_Model<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "cactus_buddy"), "main");

	private final ModelPart Body;
	private final ModelPart Flower;
	private final ModelPart Petals1;
	private final ModelPart Petal1;
	private final ModelPart Petal2;
	private final ModelPart Petal3;
	private final ModelPart Petal4;
	private final ModelPart Petals2;
	private final ModelPart Petal1_2;
	private final ModelPart Petal2_2;
	private final ModelPart Petal3_2;
	private final ModelPart Petal4_2;
	private final ModelPart Face;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public Cactus_Buddy_Model(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Flower = this.Body.getChild("Flower");
		this.Petals1 = this.Flower.getChild("Petals1");
		this.Petal1 = this.Petals1.getChild("Petal1");
		this.Petal2 = this.Petals1.getChild("Petal2");
		this.Petal3 = this.Petals1.getChild("Petal3");
		this.Petal4 = this.Petals1.getChild("Petal4");
		this.Petals2 = this.Petals1.getChild("Petals2");
		this.Petal1_2 = this.Petals2.getChild("Petal1_2");
		this.Petal2_2 = this.Petals2.getChild("Petal2_2");
		this.Petal3_2 = this.Petals2.getChild("Petal3_2");
		this.Petal4_2 = this.Petals2.getChild("Petal4_2");
		this.Face = this.Body.getChild("Face");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.RightLeg = this.Body.getChild("RightLeg");
		this.LeftLeg = this.Body.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Flower = Body.addOrReplaceChild("Flower", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -0.8F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.2F, 0.0F));

		PartDefinition Petals1 = Flower.addOrReplaceChild("Petals1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.2F, 0.0F));

		PartDefinition Petal1 = Petals1.addOrReplaceChild("Petal1", CubeListBuilder.create().texOffs(23, 16).addBox(-1.5F, 0.2F, 0.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.2F, 1.5F));

		PartDefinition Petal2 = Petals1.addOrReplaceChild("Petal2", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, 0.2F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -0.2F, 0.0F));

		PartDefinition Petal3 = Petals1.addOrReplaceChild("Petal3", CubeListBuilder.create().texOffs(17, 22).addBox(-1.5F, 0.2F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.2F, -1.5F));

		PartDefinition Petal4 = Petals1.addOrReplaceChild("Petal4", CubeListBuilder.create().texOffs(21, 3).addBox(-3.0F, 0.2F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -0.2F, 0.0F));

		PartDefinition Petals2 = Petals1.addOrReplaceChild("Petals2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Petal1_2 = Petals2.addOrReplaceChild("Petal1_2", CubeListBuilder.create(), PartPose.offset(0.0F, -0.2F, 1.5F));

		PartDefinition Petal1_2_r1 = Petal1_2.addOrReplaceChild("Petal1_2_r1", CubeListBuilder.create().texOffs(21, 0).addBox(-1.5F, 0.2F, 0.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Petal2_2 = Petals2.addOrReplaceChild("Petal2_2", CubeListBuilder.create(), PartPose.offset(1.5F, -0.2F, 0.0F));

		PartDefinition Petal2_2_r1 = Petal2_2.addOrReplaceChild("Petal2_2_r1", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, 0.2F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Petal3_2 = Petals2.addOrReplaceChild("Petal3_2", CubeListBuilder.create(), PartPose.offset(0.0F, -0.2F, -1.5F));

		PartDefinition Petal3_2_r1 = Petal3_2.addOrReplaceChild("Petal3_2_r1", CubeListBuilder.create().texOffs(17, 19).addBox(-1.5F, 0.2F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Petal4_2 = Petals2.addOrReplaceChild("Petal4_2", CubeListBuilder.create(), PartPose.offset(-1.5F, -0.2F, 0.0F));

		PartDefinition Petal4_2_r1 = Petal4_2.addOrReplaceChild("Petal4_2_r1", CubeListBuilder.create().texOffs(17, 16).addBox(-3.0F, 0.2F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Face = Body.addOrReplaceChild("Face", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -1.75F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(12, 16).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(7, 24).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 5.0F, 0.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(24, 23).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		//this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.CACTUS_BUDDY_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((Cactus_Buddy) entity).idleAnimationState, ModAnimationDefinitions.CACTUS_BUDDY_IDLE, ageInTicks, 1f);
		this.animate(((Cactus_Buddy) entity).attackAnimationState, ModAnimationDefinitions.CACTUS_BUDDY_ATTACK, ageInTicks, 1f);
	}
	/*private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}*/
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return Body;
	}
}