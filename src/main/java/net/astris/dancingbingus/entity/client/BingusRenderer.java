package net.astris.dancingbingus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.custom.BingusEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BingusRenderer extends MobRenderer<BingusEntity, BingusModel<BingusEntity>> {

    public BingusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BingusModel<>(pContext.bakeLayer(ModModelLayers.BINGUS_LAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(BingusEntity bingusEntity) {
        return new ResourceLocation(DancingBingus.MOD_ID, "textures/entity/bingus.png");
    }

    @Override
    public void render(BingusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.5F, 0.5F, 0.5F);

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
