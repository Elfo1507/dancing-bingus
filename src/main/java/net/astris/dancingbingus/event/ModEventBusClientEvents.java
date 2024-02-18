package net.astris.dancingbingus.event;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.client.BananaModel;
import net.astris.dancingbingus.entity.client.BingusModel;
import net.astris.dancingbingus.entity.client.CurseModel;
import net.astris.dancingbingus.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DancingBingus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BINGUS_LAYER, BingusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CURSE_LAYER, CurseModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BANANA_LAYER, BananaModel::createBodyLayer);
    }
}
