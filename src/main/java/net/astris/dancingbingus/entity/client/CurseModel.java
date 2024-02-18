package net.astris.dancingbingus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.astris.dancingbingus.entity.animations.ModAnimationsDefinition;
import net.astris.dancingbingus.entity.custom.CurseEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class CurseModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart curse;
	private final ModelPart head;

	public CurseModel(ModelPart root) {
		this.curse = root.getChild("curse");
		this.head = curse.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition curse = partdefinition.addOrReplaceChild("curse", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = curse.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -40.7408F, -11.6093F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, -38.0F, -1.5F, 30.0F, 38.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 35.7408F, 9.1093F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 132).addBox(-3.0F, -64.0F, 3.5F, 30.0F, 32.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 35.7408F, 9.1093F, 0.7418F, 0.0F, 0.0F));

		PartDefinition head = curse.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -53.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(14.0F, -28.45F, 2.6607F));

		PartDefinition cube_r3 = jaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(81, 80).addBox(-2.0F, -9.0F, -3.5F, 28.0F, 11.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 8.45F, -15.1607F, 0.3054F, 0.0F, 0.0F));

		PartDefinition teeth = jaw.addOrReplaceChild("teeth", CubeListBuilder.create(), PartPose.offset(-12.0F, 12.45F, -16.6607F));

		PartDefinition cube_r4 = teeth.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(95, 52).addBox(-20.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 52).addBox(-22.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(27, 67).addBox(-18.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 52).addBox(-16.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 52).addBox(-26.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 52).addBox(-24.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 52).addBox(-28.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 52).addBox(-30.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 52).addBox(-10.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(101, 23).addBox(-8.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(101, 0).addBox(-12.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(99, 52).addBox(-14.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(105, 23).addBox(-4.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(105, 0).addBox(-6.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(109, 0).addBox(-2.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(109, 23).addBox(0.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -12.2902F, -4.1129F, 0.2618F, 0.0F, 0.0F));

		PartDefinition teeth2 = jaw.addOrReplaceChild("teeth2", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.3801F, -7.8863F, -6.7751F, 1.0568F, -1.4068F, -1.2784F));

		PartDefinition cube_r5 = teeth2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(129, 23).addBox(-20.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 121).addBox(-22.0F, -12.0F, -1.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(129, 52).addBox(-18.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 121).addBox(-16.0F, -10.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 52).addBox(-26.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 121).addBox(-24.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 121).addBox(-28.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 52).addBox(-30.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(56, 121).addBox(-10.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(60, 121).addBox(-8.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 32).addBox(-12.0F, -9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 32).addBox(-14.0F, -9.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(125, 36).addBox(-4.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(64, 121).addBox(-6.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(68, 121).addBox(-2.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(125, 65).addBox(0.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, 6.1491F, 2.1653F, 0.2618F, 0.0F, 0.0F));

		PartDefinition teeth3 = jaw.addOrReplaceChild("teeth3", CubeListBuilder.create(), PartPose.offsetAndRotation(15.6199F, -7.8863F, -6.7751F, 1.0568F, -1.4068F, -1.2784F));

		PartDefinition cube_r6 = teeth3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(125, 52).addBox(-20.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 121).addBox(-22.0F, -12.0F, -1.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(127, 0).addBox(-18.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 121).addBox(-16.0F, -10.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(113, 0).addBox(-26.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(113, 23).addBox(-24.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 23).addBox(-28.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 52).addBox(-30.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 121).addBox(-10.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(44, 121).addBox(-8.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 32).addBox(-12.0F, -9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 32).addBox(-14.0F, -9.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(76, 121).addBox(-4.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 121).addBox(-6.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(52, 121).addBox(-2.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(123, 75).addBox(0.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, 6.1491F, 2.1653F, 0.2618F, 0.0F, 0.0F));

		PartDefinition jaw2 = head.addOrReplaceChild("jaw2", CubeListBuilder.create(), PartPose.offsetAndRotation(14.1782F, -49.4286F, 3.5801F, 0.0F, -0.0436F, -3.1416F));

		PartDefinition cube_r7 = jaw2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(15.0F, -150.5F, 25.5F, 30.0F, 11.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, 152.1214F, -0.2686F, 0.3054F, 0.0F, 0.0F));

		PartDefinition teeth4 = jaw2.addOrReplaceChild("teeth4", CubeListBuilder.create(), PartPose.offset(-12.0F, 15.5714F, -15.9294F));

		PartDefinition cube_r8 = teeth4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 0).addBox(-20.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-22.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 15).addBox(-18.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-16.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 16).addBox(-26.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 16).addBox(-24.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 0).addBox(-28.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 16).addBox(-30.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-10.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 16).addBox(-8.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 0).addBox(-12.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(27, 16).addBox(-14.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 0).addBox(-4.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(31, 16).addBox(-6.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 0).addBox(-2.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(35, 16).addBox(0.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -12.2902F, -4.1129F, 0.2618F, 0.0F, 0.0F));

		PartDefinition teeth5 = jaw2.addOrReplaceChild("teeth5", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.3801F, -4.7649F, -6.0438F, 1.0568F, -1.4068F, -1.2784F));

		PartDefinition cube_r9 = teeth5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(121, 52).addBox(-20.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 121).addBox(-22.0F, -12.0F, -1.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(125, 23).addBox(-18.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 31).addBox(-16.0F, -10.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 68).addBox(-26.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 68).addBox(-24.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 68).addBox(-28.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(-30.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(107, 75).addBox(-10.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, 75).addBox(-8.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 32).addBox(-12.0F, -9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-14.0F, -9.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(121, 65).addBox(-4.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(115, 75).addBox(-6.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 121).addBox(-2.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(72, 121).addBox(0.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, 6.1491F, 2.1653F, 0.2618F, 0.0F, 0.0F));

		PartDefinition teeth6 = jaw2.addOrReplaceChild("teeth6", CubeListBuilder.create(), PartPose.offsetAndRotation(15.6199F, -4.7649F, -6.0438F, 1.0568F, -1.4068F, -1.2784F));

		PartDefinition cube_r10 = teeth6.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(121, 23).addBox(-20.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 121).addBox(-22.0F, -12.0F, -1.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 121).addBox(-18.0F, -11.0F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 30).addBox(-16.0F, -10.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 68).addBox(-26.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 68).addBox(-24.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 68).addBox(-28.0F, -13.0F, -1.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-30.0F, -14.0F, -1.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 75).addBox(-10.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(95, 75).addBox(-8.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 32).addBox(-12.0F, -9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 32).addBox(-14.0F, -9.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(119, 75).addBox(-4.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(99, 75).addBox(-6.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 75).addBox(-2.0F, -8.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(121, 36).addBox(0.0F, -8.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, 6.1491F, 2.1653F, 0.2618F, 0.0F, 0.0F));

		PartDefinition arm1 = curse.addOrReplaceChild("arm1", CubeListBuilder.create(), PartPose.offsetAndRotation(38.5728F, -70.1063F, -28.718F, 0.0F, -0.3054F, 0.0F));

		PartDefinition back_arm = arm1.addOrReplaceChild("back_arm", CubeListBuilder.create(), PartPose.offset(454.0F, 43.0139F, 14.6554F));

		PartDefinition cube_r11 = back_arm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(178, 0).addBox(-2.0F, -49.0F, 12.5F, 4.0F, 98.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-456.0F, -41.0F, -20.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition front_arm = arm1.addOrReplaceChild("front_arm", CubeListBuilder.create().texOffs(101, 0).addBox(0.0F, 89.7645F, -35.4123F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -41.7645F, 4.4123F));

		PartDefinition cube_r12 = front_arm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(164, 132).addBox(0.0F, -43.0F, -23.5F, 4.0F, 98.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 41.0F, 6.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition arm2 = curse.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5862F, -53.2729F, -35.5115F, 0.0F, 0.3054F, 0.0F));

		PartDefinition back_arm2 = arm2.addOrReplaceChild("back_arm2", CubeListBuilder.create(), PartPose.offset(-2.6667F, 30.4022F, 29.7456F));

		PartDefinition cube_r13 = back_arm2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(142, 132).addBox(-2.0F, -49.0F, 12.5F, 4.0F, 98.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -45.2216F, -27.7569F, 0.1745F, 0.0F, 0.0F));

		PartDefinition front_arm2 = arm2.addOrReplaceChild("front_arm2", CubeListBuilder.create().texOffs(91, 52).addBox(-2.5F, 88.6357F, -32.5014F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.1667F, -56.6371F, 7.1129F));

		PartDefinition cube_r14 = front_arm2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(120, 132).addBox(-4.0F, -43.0F, -23.5F, 4.0F, 98.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 39.8712F, 8.9109F, -0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationsDefinition.curse_walk, limbSwing, limbSwingAmount, 5f, 1f);
		this.animate(((CurseEntity) entity).attackAnimationState ,ModAnimationsDefinition.attack, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -40.0F, 40.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		curse.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return curse;
	}
}