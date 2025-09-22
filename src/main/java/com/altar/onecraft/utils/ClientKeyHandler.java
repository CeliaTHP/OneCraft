package com.altar.onecraft.utils;

import com.altar.onecraft.player.PlayerEffect;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "examplemod")
public class ClientKeyHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (Minecraft.getInstance().player == null) return;

        if (KeyBindings.FRUIT_ABILITY_KEY.consumeClick()) {
            PlayerEffect.toggleOverlay();
        }

        if (KeyBindings.SPELL_1_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(1);
        }

        if (KeyBindings.SPELL_2_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(2);
        }
        if (KeyBindings.SPELL_3_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(3);
        }
        if (KeyBindings.SPELL_4_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(4);
        }
        if (KeyBindings.SPELL_5_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(5);
        }
        if (KeyBindings.SPELL_6_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(6);
        }
        if (KeyBindings.SPELL_7_KEY.consumeClick()) {
            PlayerEffect.selectSkillNumber(7);
        }







    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            PlayerEffect.updateCursorAnimation();
        }
    }
}