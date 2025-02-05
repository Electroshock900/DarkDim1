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
import net.minecraft.world.entity.Entity;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.animation.WarTortoiseAnimation;
import net.voidless.voidless.entity.animation.WarTurtleAnimation;
import net.voidless.voidless.entity.custom.WarTurtle;

public class War_Turtle_Model<T extends WarTurtle> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "war_turtle"), "main");
	public static final ModelLayerLocation ARMOR_LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "war_turtle_armor"), "main");

	//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "wartutel"), "main");
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart blanky;
	//private final ModelPart chests;
	private final ModelPart tier1;
	private final ModelPart tier2;
	private final ModelPart tier3;
	private final ModelPart head;
	private final ModelPart helmet;
	private final ModelPart mouth;
	//private final ModelPart chests2;
	private final ModelPart legs;
	private final ModelPart legFL;
	private final ModelPart legFR;
	private final ModelPart legBL;
	private final ModelPart legBR;

	public War_Turtle_Model(ModelPart root) {
		this.body = root.getChild("body");
		this.torso = this.body.getChild("torso");
		this.blanky = this.torso.getChild("blanky");
		//this.chests = this.torso.getChild("chests");
		this.tier1 = this.torso.getChild("chests").getChild("tier1");
		this.tier2 = this.torso.getChild("chests").getChild("tier2");
		this.tier3 = this.torso.getChild("chests").getChild("tier3");
		this.head = this.torso.getChild("head");
		this.helmet = this.head.getChild("helmet");
		this.mouth = this.head.getChild("mouth");
		//this.chests2 = this.torso.getChild("chests2");
		this.legs = this.body.getChild("legs");
		this.legFL = this.legs.getChild("legFL");
		this.legFR = this.legs.getChild("legFR");
		this.legBL = this.legs.getChild("legBL");
		this.legBR = this.legs.getChild("legBR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 31).addBox(-11.0F, -23.0F, -12.0F, 22.0F, 17.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(3, 99).addBox(-9.0F, -26.0F, -8.0F, 18.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition blanky = torso.addOrReplaceChild("blanky", CubeListBuilder.create(), PartPose.offset(0.0F, -23.0F, 13.0F));

		PartDefinition blanky_r1 = blanky.addOrReplaceChild("blanky_r1", CubeListBuilder.create().texOffs(43, 97).addBox(-10.0F, -3.0F, -3.0F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chests = torso.addOrReplaceChild("chests", CubeListBuilder.create(), PartPose.offset(12.0F, -25.0F, 2.0F));

		PartDefinition tier1 = chests.addOrReplaceChild("tier1", CubeListBuilder.create(), PartPose.offset(-12.0F, 13.0F, -1.0F));

		PartDefinition chest_r1 = tier1.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(2, 27).mirror().addBox(-4.0F, -3.0F, 0.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 0.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_r2 = tier1.addOrReplaceChild("chest_r2", CubeListBuilder.create().texOffs(2, 27).addBox(-2.0F, -3.0F, 0.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition tier2 = chests.addOrReplaceChild("tier2", CubeListBuilder.create(), PartPose.offset(-12.0F, 7.0F, 7.0F));

		PartDefinition chest_r3 = tier2.addOrReplaceChild("chest_r3", CubeListBuilder.create().texOffs(3, 47).mirror().addBox(-5.0F, -4.0F, 1.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 1.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_r4 = tier2.addOrReplaceChild("chest_r4", CubeListBuilder.create().texOffs(3, 47).mirror().addBox(-5.0F, -4.0F, 1.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 1.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition tier3 = chests.addOrReplaceChild("tier3", CubeListBuilder.create(), PartPose.offset(-12.0F, 6.0F, -7.5F));

		PartDefinition chest_r5 = tier3.addOrReplaceChild("chest_r5", CubeListBuilder.create().texOffs(3, 37).mirror().addBox(-4.0F, -4.0F, 1.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 1.0F, -0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_r6 = tier3.addOrReplaceChild("chest_r6", CubeListBuilder.create().texOffs(3, 37).mirror().addBox(-4.0F, -4.0F, 1.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 1.0F, -0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 8).addBox(-4.5F, -6.5F, -12.0F, 9.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(72, 31).addBox(-4.5F, -0.5F, -12.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, -12.5F, -12.0F));

		PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(91, 67).addBox(-4.5F, 1.0F, -8.5F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.3F))
		.texOffs(72, 35).addBox(-0.5F, -1.6F, -5.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.3F))
		.texOffs(78, 79).addBox(4.8F, 5.3F, -9.2F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(78, 79).mirror().addBox(-4.8F, 5.3F, -9.2F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -9.5F, -1.5F));

		PartDefinition frill_r1 = helmet.addOrReplaceChild("frill_r1", CubeListBuilder.create().texOffs(62, -13).mirror().addBox(0.0F, -11.5F, -12.0F, 0.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.05F, -2.45F, -3.8F, -0.1745F, 0.0F, 0.0F));

		PartDefinition frillsprike_r1 = helmet.addOrReplaceChild("frillsprike_r1", CubeListBuilder.create().texOffs(42, 116).addBox(-10.5F, -0.5F, -7.0F, 12.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.55F, -2.9F, -9.8F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition nosecap_r1 = helmet.addOrReplaceChild("nosecap_r1", CubeListBuilder.create().texOffs(104, 71).addBox(-4.5F, 0.0F, -3.75F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.751F, -8.75F, 0.0873F, 0.0F, 0.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(67, 20).addBox(-4.5F, -3.0F, -7.0F, 9.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -5.0F));

		PartDefinition chests2 = torso.addOrReplaceChild("chests2", CubeListBuilder.create(), PartPose.offset(-12.0F, -25.0F, 2.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legFL = legs.addOrReplaceChild("legFL", CubeListBuilder.create().texOffs(46, 76).mirror().addBox(-4.0F, -2.0F, -5.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -10.0F, -10.0F));

		PartDefinition legFR = legs.addOrReplaceChild("legFR", CubeListBuilder.create().texOffs(46, 76).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -10.0F, -10.0F));

		PartDefinition legBL = legs.addOrReplaceChild("legBL", CubeListBuilder.create().texOffs(0, 76).addBox(-5.0F, -2.0F, -2.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -10.0F, 13.0F));

		PartDefinition legBR = legs.addOrReplaceChild("legBR", CubeListBuilder.create().texOffs(0, 76).mirror().addBox(-3.0F, -2.0F, -2.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-11.0F, -10.0F, 13.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(WarTurtle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(WarTurtleAnimation.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, WarTurtleAnimation.idle, ageInTicks, 1f);
		this.animate(entity.sitDownAnimationState, WarTurtleAnimation.hide, ageInTicks, 1f);
		this.animate(entity.sitPoseAnimationState, WarTurtleAnimation.sitting, ageInTicks, 1f);
		this.animate(entity.sitUpAnimationState, WarTurtleAnimation.emerge, ageInTicks, 1f);
		//this.animate(((WarTortoise) entity).attackAnimationState, ModAnimationDefinitions.CACTUS_BUDDY_ATTACK, ageInTicks, 1f);
		this.tier1.visible= entity.hasTier1Chest();
		this.tier2.visible= entity.hasTier2Chest();
		this.tier3.visible= entity.hasTier3Chest();
		//this.helmet.visible=entity.hasArmorOn();
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color){//float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);//red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.body;
	}
}