package net.astris.dancingbingus.util;

import net.astris.dancingbingus.DancingBingus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey <Block> BINGUS_BLOCKS = tag("bingus_blocks");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DancingBingus.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BINGUS_VALUABLES = tag("bingus_valuables");
        public static final TagKey<Item> BINGUS_UTILITY_ITEMS = tag("bingus_ingots");

        public static final TagKey<Item> FISHES = tag("fishes");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DancingBingus.MOD_ID, name));
        }
    }
}
