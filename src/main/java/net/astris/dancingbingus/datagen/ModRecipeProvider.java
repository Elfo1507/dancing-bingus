package net.astris.dancingbingus.datagen;

import net.astris.dancingbingus.block.ModBlocks;
import net.astris.dancingbingus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.BREAD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.BREAD.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.STEAK_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.COOKED_BEEF.asItem())
                .unlockedBy(getHasName(Items.COOKED_BEEF.asItem()), has(Items.COOKED_BEEF.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.PORK_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.COOKED_PORKCHOP.asItem())
                .unlockedBy(getHasName(Items.COOKED_PORKCHOP.asItem()), has(Items.COOKED_PORKCHOP.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.COOKED_CHICKEN_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.COOKED_CHICKEN.asItem())
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SANDWICH.get())
                .pattern("BBB")
                .pattern("CPS")
                .pattern("BBB")
                .define('B', ModBlocks.BREAD_BLOCK.get())
                .define('C', ModBlocks.COOKED_CHICKEN_BLOCK.get())
                .define('P', ModBlocks.PORK_BLOCK.get())
                .define('S', ModBlocks.STEAK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BREAD_BLOCK.get()), has(ModBlocks.BREAD_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BURGUER.get())
                .requires(ModItems.SANDWICH.get())
                .requires(ModItems.BINGUS_SHARD.get())
                .unlockedBy(getHasName(ModItems.SANDWICH.get()), has(ModItems.SANDWICH.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BINGUS_BLOCK.get(), 1)
                .requires(ModItems.BINGUS.get(), 1)
                .requires(ModItems.FLOPPA.get(), 1)
                .unlockedBy(getHasName(ModItems.BINGUS.get()), has(ModItems.BINGUS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BINGUS_SHARD.get(), 1)
                .requires(ModBlocks.BINGUS_BLOCK.get(), 9)
                .unlockedBy(getHasName(ModBlocks.BINGUS_BLOCK.get()), has(ModBlocks.BINGUS_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BINGUS_CORE.get())
                .pattern("BNB")
                .pattern("NBN")
                .pattern("BNB")
                .define('B', ModItems.BINGUS_SHARD.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BINGUS_VORTEX.get())
                .pattern("NNN")
                .pattern("NBN")
                .pattern("NNN")
                .define('B', ModItems.BINGUS_SHARD.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BINGUS_FETUS.get())
                .pattern(" E ")
                .pattern("EBE")
                .pattern(" E ")
                .define('E', Items.EGG)
                .define('B', ModItems.BINGUS.get())
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(consumer);

    }
}
