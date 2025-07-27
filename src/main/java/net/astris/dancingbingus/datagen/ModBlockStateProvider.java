package net.astris.dancingbingus.datagen;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DancingBingus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BINGUS_BLOCK);
        blockWithItem(ModBlocks.BREAD_BLOCK);
        blockWithItem(ModBlocks.STEAK_BLOCK);
        blockWithItem(ModBlocks.PORK_BLOCK);
        blockWithItem(ModBlocks.COOKED_CHICKEN_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
