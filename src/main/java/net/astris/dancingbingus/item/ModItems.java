package net.astris.dancingbingus.item;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.entity.ModEntities;
import net.astris.dancingbingus.item.custom.BingusVortexItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DancingBingus.MOD_ID);

    public static final RegistryObject<Item> BINGUS = ITEMS.register("bingus_item",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLOPPA = ITEMS.register("floppa",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BINGUS_SHARD = ITEMS.register("bingus_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BINGUS_CORE = ITEMS.register("bingus_core",
            () -> new SwordItem(ModToolTiers.BINGUS, 999999999, 9999, new Item.Properties()
    ));
    public static final RegistryObject<Item> BINGUS_VORTEX = ITEMS.register("bingus_vortex",
            () -> new BingusVortexItem(new Item.Properties()));
    public static final RegistryObject<Item> BINGUS_FETUS = ITEMS.register("bingus_fetus",
            () -> new ForgeSpawnEggItem(ModEntities.BINGUS, 0x000000, 0xFFFFFF, new Item.Properties()
    ));
    public static final RegistryObject<Item> BURGUER = ITEMS.register("burguer",
            () -> new Item(new Item.Properties().food(ModFoods.BURGUER)));
    public static final RegistryObject<Item> SANDWICH = ITEMS.register("sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.SANDWICH)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
