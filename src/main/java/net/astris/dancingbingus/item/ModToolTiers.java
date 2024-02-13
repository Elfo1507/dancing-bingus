package net.astris.dancingbingus.item;

import net.astris.dancingbingus.DancingBingus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier BINGUS = TierSortingRegistry.registerTier(
            new ForgeTier( 999, 999999999, 99999999f, 999999999999999f, 999999,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.BINGUS_SHARD.get())),
            new ResourceLocation(DancingBingus.MOD_ID, "bingus_tier"), List.of(Tiers.NETHERITE), List.of());
}
