package net.astris.dancingbingus.datagen;

import net.astris.dancingbingus.DancingBingus;
import net.astris.dancingbingus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DancingBingus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BINGUS);
        simpleItem(ModItems.BINGUS_CORE);
        simpleItem(ModItems.BINGUS_SHARD);
        simpleItem(ModItems.BINGUS_FETUS);
        simpleItem(ModItems.BINGUS_VORTEX);
        simpleItem(ModItems.BURGUER);
        simpleItem(ModItems.FLOPPA);
        simpleItem(ModItems.SANDWICH);
        simpleItem(ModItems.CURSE_SPAWN_EGG);

        withExistingParent(ModItems.CURSE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BANANA_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DancingBingus.MOD_ID, "item/" + item.getId().getPath()));
    }



}
