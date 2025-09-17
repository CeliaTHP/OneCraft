package com.altar.onecraft.player;

import com.altar.onecraft.ModEffects;
import com.altar.onecraft.fruits.models.FruitItem;
import com.altar.onecraft.utils.CustomLogger;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

public class PlayerEffect {


    //Class to handle persistend data manipulation

    //Add fruit param
    public static void makeFruity(Player player, FruitItem.FruitType fruitType) {
        // Set the persistent data flag

        CustomLogger.d("MAKE_FRUITY","fruity = true & fruit type = " + fruitType);

        player.getPersistentData().putBoolean("fruity", true);
        player.getPersistentData().putString("fruit_type", fruitType.name());

        // Apply the permanent effect
        player.addEffect(new MobEffectInstance(
                ModEffects.FRUITY.get(),
                Integer.MAX_VALUE,
                0,
                false,
                true,
                true
        ));
    }

    public static void removeFruity(Player player) {
        player.getPersistentData().putBoolean("fruity", false);
        player.getPersistentData().remove("fruit_type");
        player.removeEffect(ModEffects.FRUITY.get());
    }

}
