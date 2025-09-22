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

        // Spell selection keys
        public static final KeyMapping SPELL_1_KEY = new KeyMapping(
                "key.onecraft.spell_1",
                GLFW.GLFW_KEY_1,
                "key.categories.onecraft"
        );

        public static final KeyMapping SPELL_2_KEY = new KeyMapping(
                "key.onecraft.spell_2",
                GLFW.GLFW_KEY_2,
                "key.categories.onecraft"
        );

        public static final KeyMapping SPELL_3_KEY = new KeyMapping(
                "key.onecraft.spell_3",
                GLFW.GLFW_KEY_3,
                "key.categories.onecraft"
        );

        public static final KeyMapping SPELL_4_KEY = new KeyMapping(
                "key.onecraft.spell_4",
                GLFW.GLFW_KEY_4,
                "key.categories.onecraft"
        );

        public static final KeyMapping SPELL_5_KEY = new KeyMapping(
                "key.onecraft.spell_5",
                GLFW.GLFW_KEY_5,
                "key.categories.onecraft"
        );

        public static final KeyMapping SPELL_6_KEY = new KeyMapping(
                "key.onecraft.spell_6",
                GLFW.GLFW_KEY_6,
                "key.categories.onecraft"
        );

        public static final KeyMapping SPELL_7_KEY = new KeyMapping(
                "key.onecraft.spell_7",
                GLFW.GLFW_KEY_7,
                "key.categories.onecraft"
        );


        public static void register(RegisterKeyMappingsEvent event) {
        event.register(FRUIT_ABILITY_KEY);
        event.register(SPELL_1_KEY);
        event.register(SPELL_2_KEY);
        event.register(SPELL_3_KEY);
        event.register(SPELL_4_KEY);
        event.register(SPELL_5_KEY);
        event.register(SPELL_6_KEY);
        event.register(SPELL_7_KEY);
    }

}



