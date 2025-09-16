package com.altar.onecraft.fruits;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FruitItem extends Item {

    public FruitItem(int nutrition, float saturation) {
        super(new Item.Properties()
                .stacksTo(64)
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .alwaysEat()
                        .build()
                )
        );
    }
}

