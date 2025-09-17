package com.altar.onecraft.fruits.models;

import com.altar.onecraft.player.PlayerEffect;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide && entity instanceof Player player) {
            if (player.getPersistentData().getBoolean("fruity")) {
                // Kill the player
                player.sendSystemMessage(Component.literal("Le fruit de trop"));
                player.hurt(world.damageSources().genericKill(), Float.MAX_VALUE);

                //Reset fruity state
                //Add parameter to identify the consumed fruit ?
                PlayerEffect.removeFruity(player);

            } else {
                player.getPersistentData().putBoolean("fruity", true);
                PlayerEffect.makeFruity(player);

            }
        }
            return super.finishUsingItem(stack, world, entity);

    }
}

