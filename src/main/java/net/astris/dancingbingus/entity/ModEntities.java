package net.astris.dancingbingus.entity;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.custom.BananaEntity;
import net.astris.dancingbingus.entity.custom.BingusEntity;
import net.astris.dancingbingus.entity.custom.CurseEntity;
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
    public static final RegistryObject<EntityType<BananaEntity>> BANANA =
            ENTITY_TYPES.register("banana", () -> EntityType.Builder.of(BananaEntity::new, MobCategory.CREATURE)
                    .sized(1F, 1F).build("banana"));
    public static final RegistryObject<EntityType<CurseEntity>> CURSE =
            ENTITY_TYPES.register("curse", () -> EntityType.Builder.of(CurseEntity::new, MobCategory.MONSTER)
                    .sized(3F, 3F).build("curse"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
