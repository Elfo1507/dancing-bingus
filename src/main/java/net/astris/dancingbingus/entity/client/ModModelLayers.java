package net.astris.dancingbingus.entity.client;

import net.astris.dancingbingus.DancingBingus;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation BINGUS_LAYER = new ModelLayerLocation(
            new ResourceLocation(DancingBingus.MOD_ID, "bingus_layer"), "main"
    );
    public static final ModelLayerLocation CURSE_LAYER = new ModelLayerLocation(
            new ResourceLocation(DancingBingus.MOD_ID, "curse_layer"), "main"
    );
    public static final ModelLayerLocation BANANA_LAYER = new ModelLayerLocation(
            new ResourceLocation(DancingBingus.MOD_ID, "banana_layer"), "main"
    );
}
