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

    FruitType fruitType;

    public enum FruitType {
        BOMU_BOMU,
        GOMU_GOMU,
        GORO_GORO,
        GURA_GURA,
        HIE_HIE,
        HITO_HITO,
        HORO_HORO,
        ITO_ITO,
        JIKI_JIKI,
        KAGE_KAGE,
        KILO_KILO,
        MAGU_MAGU,
        MERA_MERA,
        MOKU_MOKU,
        NEKO_NEKO,
        NIKYU_NIKYU,
        OPE_OPE,
        PIKA_PIKA,
        RYU_RYU,
        SUKE_SUKE,
        TORI_TORI,
        YAMI_YAMI,
        ZUSHI_ZUSHI;
    }

    public FruitItem(int nutrition, float saturation, FruitType fruitType) {
        super(new Item.Properties()
                .stacksTo(64)
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .alwaysEat()
                        .build()
                )
        );
        this.fruitType = fruitType;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide && entity instanceof Player player) {
            if (player.getPersistentData().getBoolean("fruity")) {
                // Kill the player
                player.sendSystemMessage(Component.literal("Le fruit de trop"));
                player.hurt(world.damageSources().genericKill(), Float.MAX_VALUE);

                //Reset fruity state
                PlayerEffect.removeFruity(player);

            } else {
                PlayerEffect.makeFruity(player,this.fruitType);

            }
        }
        return super.finishUsingItem(stack, world, entity);

    }
}

