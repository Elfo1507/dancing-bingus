package net.astris.dancingbingus.block;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DancingBingus.MOD_ID);


    public static final RegistryObject<Block> BINGUS_BLOCK = registerBlock("bingus_block",
            () -> new Block(Block.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.DRAGON)
                    .requiresCorrectToolForDrops()
                    .strength(80.0F, 2000.0F)
                    .lightLevel((pState) -> 300)));
    public static final RegistryObject<Block> BREAD_BLOCK = registerBlock("bread_block",
            () -> new Block(Block.Properties.copy(Blocks.HAY_BLOCK)));

    public static final RegistryObject<Block> STEAK_BLOCK = registerBlock("steak_block",
            () -> new Block(Block.Properties.copy(Blocks.NETHER_WART_BLOCK)));

    public static final RegistryObject<Block> PORK_BLOCK = registerBlock("pork_block",
            () -> new Block(Block.Properties.copy(Blocks.NETHER_WART_BLOCK)));

    public static final RegistryObject<Block> COOKED_CHICKEN_BLOCK = registerBlock("cooked_chicken_block",
            () -> new Block(Block.Properties.copy(Blocks.NETHER_WART_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}