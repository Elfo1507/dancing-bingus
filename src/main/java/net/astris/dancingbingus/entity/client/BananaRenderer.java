package net.astris.dancingbingus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.custom.BananaEntity;
import net.astris.dancingbingus.entity.custom.BingusEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BananaRenderer extends MobRenderer<BananaEntity, BananaModel<BananaEntity>> {

    public BananaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BananaModel<>(pContext.bakeLayer(ModModelLayers.BANANA_LAYER)), 1F);
    }

    @Override
    public ResourceLocation getTextureLocation(BananaEntity bananaEntity) {
        return new ResourceLocation(DancingBingus.MOD_ID, "textures/entity/banana.png");
    }

    @Override
    public void render(BananaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
