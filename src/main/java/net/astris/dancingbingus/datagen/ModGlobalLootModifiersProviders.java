package net.astris.dancingbingus.datagen;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.item.ModItems;
import net.astris.dancingbingus.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProviders extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProviders(PackOutput output) {
        super(output, DancingBingus.MOD_ID);
    }

    @Override
    protected void start() {
        add("bingus_from_wither", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/wither")).build()
        }, ModItems.BINGUS.get()));

        add("floppa_from_ender_dragon", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/ender_dragon")).build()
        }, ModItems.FLOPPA.get()));
    }
}
