package net.astris.dancingbingus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.astris.dancingbingus.entity.animations.ModAnimationsDefinition;
import net.astris.dancingbingus.entity.custom.BingusEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class BingusModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart bingus;
	private final ModelPart head;

	public BingusModel(ModelPart root) {
		this.bingus = root.getChild("bingus");
		this.head = bingus.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bingus = partdefinition.addOrReplaceChild("bingus", CubeListBuilder.create(), PartPose.offset(2.0F, 20.0F, 0.0F));

		PartDefinition body = bingus.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-6.0F, -14.0F, -2.0F, 9.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -8.0F, -6.0F, 7.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(26, 10).addBox(-3.0F, -5.0F, -7.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg = bingus.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(24, 35).addBox(6.0F, -8.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 41).addBox(7.0F, -6.0F, -3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(43, 0).addBox(7.0F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition leg2 = bingus.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(28, 23).addBox(5.0F, -8.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 31).addBox(6.0F, -6.0F, -3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(6.0F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.0F, 0.0F, 0.0F));

		PartDefinition tail = bingus.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(0.0F, -5.0F, 3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-1.0F, -10.0F, 2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(-3.0F, -11.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition arm = bingus.addOrReplaceChild("arm", CubeListBuilder.create().texOffs(16, 44).addBox(2.0F, -12.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 37).addBox(3.0F, -11.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 27).addBox(3.0F, -10.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition arm2 = bingus.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(40, 23).addBox(2.0F, -12.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(2.0F, -11.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 15).addBox(2.0F, -10.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 0.0F, 0.0F));

		PartDefinition head = bingus.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -19.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(-3.0F, -16.0F, -4.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition oreia2_r1 = head.addOrReplaceChild("oreia2_r1", CubeListBuilder.create().texOffs(18, 37).addBox(-6.0F, -25.0F, 1.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1298F, 0.017F, -0.0425F));

		PartDefinition oreia1_r1 = head.addOrReplaceChild("oreia1_r1", CubeListBuilder.create().texOffs(40, 10).addBox(-1.0F, -25.0F, 1.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0873F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	    this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationsDefinition.floating, limbSwing, limbSwingAmount, 0.5f, 0.5f);
		this.animate(((BingusEntity) entity).idleAnimationState, ModAnimationsDefinition.floating, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bingus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return bingus;
	}
}