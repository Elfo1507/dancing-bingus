package net.astris.dancingbingus.sound;

import net.astris.dancingbingus.DancingBingus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DancingBingus.MOD_ID);

    public static final RegistryObject<SoundEvent> BINGUS_AMBIENT = registerSoundEvents("bingus_ambient");
    public static final RegistryObject<SoundEvent> BINGUS_HURT = registerSoundEvents("bingus_hurt");
    public static final RegistryObject<SoundEvent> BINGUS_DEATH = registerSoundEvents("bingus_death");
    public static final RegistryObject<SoundEvent> RICKROLL = registerSoundEvents("rickroll");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DancingBingus.MOD_ID, name)));
    }
    public static void register(IEventBus eventbus) {
        SOUND_EVENTS.register(eventbus);
    }
}
