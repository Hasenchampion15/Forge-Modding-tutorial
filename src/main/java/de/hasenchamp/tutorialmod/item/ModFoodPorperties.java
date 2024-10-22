package de.hasenchamp.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodPorperties {
    public static final FoodProperties KOHLRABI = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400), 0.20f).build();
}
