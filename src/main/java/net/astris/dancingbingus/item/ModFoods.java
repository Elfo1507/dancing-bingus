package net.astris.dancingbingus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BURGUER = new FoodProperties.Builder()
            .nutrition(999)
            .saturationMod(999f)
            .alwaysEat()
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 999999, 999), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 999999, 999), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, 999), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 999), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 999999, 999), 1.0F)
            .build();

    public static final FoodProperties SANDWICH = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1), 1.0F)
            .build();
}
