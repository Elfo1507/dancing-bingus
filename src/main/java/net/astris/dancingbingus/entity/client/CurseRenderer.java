package net.astris.dancingbingus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.custom.CurseEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CurseRenderer extends MobRenderer<CurseEntity, CurseModel<CurseEntity>> {

    public CurseRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CurseModel<>(pContext.bakeLayer(ModModelLayers.CURSE_LAYER)), 3F);
    }

    @Override
    public ResourceLocation getTextureLocation(CurseEntity CurseEntity) {
        return new ResourceLocation(DancingBingus.MOD_ID, "textures/entity/curse.png");
    }

    @Override
    public void render(CurseEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.5F, 0.5F, 0.5F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
