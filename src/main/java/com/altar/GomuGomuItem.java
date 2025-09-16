package com.altar;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class GomuGomuItem extends Item {

    public GomuGomuItem() {

        super(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build()));


    }
}
