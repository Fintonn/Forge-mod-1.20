package net.finton.woodarmor.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties WOOD_CHIPS = new FoodProperties.Builder().nutrition(5).saturationMod(2f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 1000), 0.5f)
            .effect( new MobEffectInstance(MobEffects.HARM, 1), 0.2f).build();
}
