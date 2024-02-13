package net.astris.dancingbingus.event;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.ModEntities;
import net.astris.dancingbingus.entity.custom.BingusEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DancingBingus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BINGUS.get(), BingusEntity.createAttributes().build());
    }
}
