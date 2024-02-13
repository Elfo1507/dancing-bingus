package net.astris.dancingbingus.entity;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.custom.BingusEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DancingBingus.MOD_ID);

    public static final RegistryObject<EntityType<BingusEntity>> BINGUS =
            ENTITY_TYPES.register("bingus", () -> EntityType.Builder.of(BingusEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.5F).build("bingus"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
