package net.astris.dancingbingus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.astris.dancingbingus.entity.animations.ModAnimationsDefinition;
import net.astris.dancingbingus.entity.custom.BananaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class BananaModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart banana;
	private final ModelPart face;

	public BananaModel(ModelPart root) {
		this.banana = root.getChild("banana_cat");
		this.face = this.banana.getChild("face");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition banana_cat = partdefinition.addOrReplaceChild("banana_cat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition banana = banana_cat.addOrReplaceChild("banana", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -18.0F, -1.0F, 9.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 19).addBox(0.0F, -23.0F, 0.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(2.0F, -27.0F, 0.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 14).addBox(4.0F, -30.0F, 1.0F, 9.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(0.0F, -10.0F, 0.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 28).addBox(10.0F, -33.0F, 2.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition face = banana_cat.addOrReplaceChild("face", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, -17.0F, -2.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 9).addBox(1.0F, -14.0F, -3.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm1 = banana_cat.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(22, 0).addBox(-0.25F, -1.25F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 31).addBox(-1.25F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.75F, -11.75F, 2.5F));

		PartDefinition leg1 = banana_cat.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, 0.25F, -1.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 2).addBox(-0.5F, -1.75F, -0.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -3.494F, -0.0218F));

		PartDefinition leg2 = banana_cat.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.25F, -1.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-0.5F, -1.75F, -0.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -3.25F, 2.25F));

		PartDefinition arm2 = banana_cat.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(20, 14).addBox(-1.75F, -1.25F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(0.25F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.75F, -11.75F, 2.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationsDefinition.bananaWalk, limbSwing, limbSwingAmount, 5f, 1f);

	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -40.0F, 40.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -40.0F, 45.0F);

		this.face.yRot = pNetHeadYaw * ((float)Math.PI / 5F);
		this.face.xRot = pHeadPitch * ((float)Math.PI / 5F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		banana.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return banana;
	}
}