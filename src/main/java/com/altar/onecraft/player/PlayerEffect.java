package com.altar.onecraft.player;

import com.altar.onecraft.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

public class PlayerEffect {


    public static void makeFruity(Player player) {
        // Set the persistent data flag
        player.getPersistentData().putBoolean("fruity", true);

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
        player.removeEffect(ModEffects.FRUITY.get());
    }

}
