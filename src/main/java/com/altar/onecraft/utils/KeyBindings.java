package com.altar.onecraft.utils;

import com.altar.onecraft.player.PlayerEffect;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static final KeyMapping FRUIT_ABILITY_KEY = new KeyMapping(
            "key.onecraft.fruit_ability",
            GLFW.GLFW_KEY_R,
            "key.categories.onecraft"
    );
    public static void register(RegisterKeyMappingsEvent event) {
        event.register(FRUIT_ABILITY_KEY);
    }

}



