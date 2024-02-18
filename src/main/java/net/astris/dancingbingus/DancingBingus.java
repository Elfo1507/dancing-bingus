package net.astris.dancingbingus;

import com.mojang.logging.LogUtils;
import net.astris.dancingbingus.block.ModBlocks;
import net.astris.dancingbingus.entity.ModEntities;
import net.astris.dancingbingus.entity.client.BananaRenderer;
import net.astris.dancingbingus.entity.client.BingusRenderer;
import net.astris.dancingbingus.entity.client.CurseRenderer;
import net.astris.dancingbingus.item.ModCreativeModTabs;
import net.astris.dancingbingus.item.ModItems;
import net.astris.dancingbingus.loot.ModLootModifiers;
import net.astris.dancingbingus.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DancingBingus.MOD_ID)
public class DancingBingus {
    public static final String MOD_ID = "dancingbingus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DancingBingus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.BINGUS.get(), BingusRenderer::new);
            EntityRenderers.register(ModEntities.CURSE.get(), CurseRenderer::new);
            EntityRenderers.register(ModEntities.BANANA.get(), BananaRenderer::new);
        }
    }
}
