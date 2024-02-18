package net.astris.dancingbingus.item;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> BINGUS_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DancingBingus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BINGUS_TAB = BINGUS_MOD_TAB.register("bingus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BINGUS.get()))
                    .title(Component.translatable("bingusmodtab.bingus_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BINGUS.get());
                        pOutput.accept(ModItems.FLOPPA.get());
                        pOutput.accept(ModItems.BINGUS_SHARD.get());
                        pOutput.accept(ModItems.BINGUS_CORE.get());
                        pOutput.accept(ModItems.BINGUS_VORTEX.get());
                        pOutput.accept(ModItems.BINGUS_FETUS.get());
                        pOutput.accept(ModItems.BURGUER.get());
                        pOutput.accept(ModItems.SANDWICH.get());
                        pOutput.accept(ModBlocks.BINGUS_BLOCK.get());
                        pOutput.accept(ModBlocks.BREAD_BLOCK.get());
                        pOutput.accept(ModBlocks.STEAK_BLOCK.get());
                        pOutput.accept(ModBlocks.PORK_BLOCK.get());
                        pOutput.accept(ModBlocks.COOKED_CHICKEN_BLOCK.get());
                        pOutput.accept(ModItems.CURSE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BANANA_SPAWN_EGG.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        BINGUS_MOD_TAB.register(eventBus);
    }
}
