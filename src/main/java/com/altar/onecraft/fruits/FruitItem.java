package com.altar.onecraft.fruits;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
        ;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide && entity instanceof Player player) {
            if (player.getPersistentData().getBoolean("fruity")) {
                // Kill the player
                player.sendSystemMessage(Component.literal("Le fruit de trop"));
                player.hurt(world.damageSources().genericKill(), Float.MAX_VALUE);

                //Reset fruity state
                player.getPersistentData().putBoolean("fruity", false);

            } else {
                player.getPersistentData().putBoolean("fruity", true);
                // Spawn particle FX around player
                for (int i = 0; i < 20; i++) {
                    double offsetX = (world.random.nextDouble() - 0.5);
                    double offsetY = world.random.nextDouble() + 0.5;
                    double offsetZ = (world.random.nextDouble() - 0.5);

                    // ENTITY_EFFECT particle with custom color (blue)
                    world.addParticle(ParticleTypes.ENTITY_EFFECT,
                            player.getX() + offsetX,
                            player.getY() + offsetY,
                            player.getZ() + offsetZ,
                            0, 0.1, 1.0 // RGB offset: mostly blue
                    );
                }
            }
        }
            return super.finishUsingItem(stack, world, entity);

    }
}

