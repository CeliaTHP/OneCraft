package com.altar.onecraft.player;

import com.altar.onecraft.ModEffects;
import com.altar.onecraft.fruits.models.FruitItem;
import com.altar.onecraft.utils.CustomLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

public class PlayerEffect {

    //TODO : Class to handle persistent data manipulation

    public static ResourceLocation CURRENT_OVERLAY = null;
    public static ResourceLocation SPELL_CURSOR = null;

    public static boolean SHOW_OVERLAY = true;

    // Cursor animation variables
    private static int currentSpell = 1;
    private static int targetSpell = 1;
    private static float currentCursorX = 0f;
    private static float targetCursorX = 0f;
    private static long lastUpdateTime = System.currentTimeMillis();

    // Cursor configuration
    private static final float SPELL_BAR_START_X = 1f; // Starting X position of first spell
    private static final float SPELL_BAR_SPACING = 2.6f; // Distance between each spell slot
    private static final float CURSOR_ANIMATION_SPEED = 8f;

    public static void toggleOverlay() {
        Minecraft.getInstance().player.sendSystemMessage(
                Component.literal("Toggle Overlay")
        );
        SHOW_OVERLAY = !SHOW_OVERLAY;
    }

    public static void selectSkillNumber(int spellNumber) {
        if (spellNumber < 1 || spellNumber > 7) return;

        Minecraft.getInstance().player.sendSystemMessage(
                Component.literal("SELECT SKILL n" + spellNumber)
        );

        // Update target spell and cursor position
        targetSpell = spellNumber;
        targetCursorX = SPELL_BAR_START_X + (spellNumber - 1) * SPELL_BAR_SPACING;

        SPELL_CURSOR = getCursorOverlay();
    }

    // Call this method in your render tick or client tick event
    public static void updateCursorAnimation() {
        long currentTime = System.currentTimeMillis();
        float deltaTime = (currentTime - lastUpdateTime) / 1000f; // Convert to seconds
        lastUpdateTime = currentTime;

        // Smooth interpolation towards target position
        if (Math.abs(targetCursorX - currentCursorX) > 0.5f) {
            float difference = targetCursorX - currentCursorX;
            currentCursorX += difference * CURSOR_ANIMATION_SPEED * deltaTime;
        } else {
            currentCursorX = targetCursorX;
            currentSpell = targetSpell;
        }
    }

    public static ResourceLocation getCursorOverlay() {
        return ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/gui_cursor.png");
    }

    // Get current cursor position for rendering
    public static float getCurrentCursorX() {
        return currentCursorX;
    }

    public static float getCurrentCursorY() {
        // Return fixed Y position for horizontal spell bar
        return 90f;
    }

    // Get current selected spell
    public static int getCurrentSpell() {
        return currentSpell;
    }

    public static int getTargetSpell() {
        return targetSpell;
    }

    // Initialize cursor position (call when player gets a fruit ability)
    public static void initializeCursor() {
        currentSpell = 1;
        targetSpell = 1;
        currentCursorX = SPELL_BAR_START_X;
        targetCursorX = SPELL_BAR_START_X;
        lastUpdateTime = System.currentTimeMillis();
        SPELL_CURSOR = getCursorOverlay();

        System.out.println("Cursor initialized at position: " + currentCursorX);
    }


    public static ResourceLocation getFruitOverlay(FruitItem.FruitType fruitType) {
            return switch (fruitType) {
                case BOMU_BOMU -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/gui_spells_bomu_bomu.png");
                case GOMU_GOMU -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_background.png");
                case GORO_GORO -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_goro_goro.png");
                case GURA_GURA -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_gura_gura.png");
                case HIE_HIE -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_hie_hie.png");
                case HITO_HITO -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_hito_hito.png");
                case HORO_HORO -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_horo_horo.png");
                case ITO_ITO -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_ito_ito.png");
                case JIKI_JIKI -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_jiki_jiki.png");
                case KAGE_KAGE -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_kage_kage.png");
                case KILO_KILO -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_kilo_kilo.png");
                case MAGU_MAGU -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_magu_magu.png");
                case MERA_MERA -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_mera_mera.png");
                case MOKU_MOKU -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_moku_moku.png");
                case NEKO_NEKO -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_neko_neko.png");
                case NIKYU_NIKYU -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_nikyu_nikyu.png");
                case OPE_OPE -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_ope_ope.png");
                case PIKA_PIKA -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_pika_pika.png");
                case RYU_RYU -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_ryu_ryu.png");
                case SUKE_SUKE -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_suke_suke.png");
                case TORI_TORI -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_tori_tori.png");
                case YAMI_YAMI -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_yami_yami.png");
                case ZUSHI_ZUSHI -> ResourceLocation.fromNamespaceAndPath("onecraft", "textures/gui/overlay_spells_zushi_zushi.png");
            };
        }

    public static void makeFruity(Player player, FruitItem.FruitType fruitType) {
        CustomLogger.d("MAKE_FRUITY", "fruity = true & fruit type = " + fruitType);

        player.getPersistentData().putBoolean("fruity", true);
        player.getPersistentData().putString("fruit_type", fruitType.name());

        CURRENT_OVERLAY = getFruitOverlay(fruitType);
        SHOW_OVERLAY = true;

        // Initialize cursor when player becomes fruity
        initializeCursor();

        // Determine the effect based on fruitType
        MobEffect effect = switch (fruitType) {
            case BOMU_BOMU -> ModEffects.BOMU_BOMU_EFFECT.get();
            case GOMU_GOMU -> ModEffects.GOMU_GOMU_EFFECT.get();
            case GORO_GORO -> ModEffects.GORO_GORO_EFFECT.get();
            case GURA_GURA -> ModEffects.GURA_GURA_EFFECT.get();
            case HIE_HIE -> ModEffects.HIE_HIE_EFFECT.get();
            case HITO_HITO -> ModEffects.HITO_HITO_EFFECT.get();
            case HORO_HORO -> ModEffects.HORO_HORO_EFFECT.get();
            case ITO_ITO -> ModEffects.ITO_ITO_EFFECT.get();
            case JIKI_JIKI -> ModEffects.JIKI_JIKI_EFFECT.get();
            case KAGE_KAGE -> ModEffects.KAGE_KAGE_EFFECT.get();
            case KILO_KILO -> ModEffects.KILO_KILO_EFFECT.get();
            case MAGU_MAGU -> ModEffects.MAGU_MAGU_EFFECT.get();
            case MERA_MERA -> ModEffects.MERA_MERA_EFFECT.get();
            case MOKU_MOKU -> ModEffects.MOKU_MOKU_EFFECT.get();
            case NEKO_NEKO -> ModEffects.NEKO_NEKO_EFFECT.get();
            case NIKYU_NIKYU -> ModEffects.NIKYU_NIKYU_EFFECT.get();
            case OPE_OPE -> ModEffects.OPE_OPE_EFFECT.get();
            case PIKA_PIKA -> ModEffects.PIKA_PIKA_EFFECT.get();
            case RYU_RYU -> ModEffects.RYU_RYU_EFFECT.get();
            case SUKE_SUKE -> ModEffects.SUKE_SUKE_EFFECT.get();
            case TORI_TORI -> ModEffects.TORI_TORI_EFFECT.get();
            case YAMI_YAMI -> ModEffects.YAMI_YAMI_EFFECT.get();
            case ZUSHI_ZUSHI -> ModEffects.ZUSHI_ZUSHI_EFFECT.get();
        };

        // Apply the effect
        player.addEffect(new MobEffectInstance(
                effect,
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

        CURRENT_OVERLAY = null;
        SPELL_CURSOR = null;

        // Remove all fruit effects
        player.removeEffect(ModEffects.BOMU_BOMU_EFFECT.get());
        player.removeEffect(ModEffects.GOMU_GOMU_EFFECT.get());
        player.removeEffect(ModEffects.GORO_GORO_EFFECT.get());
        player.removeEffect(ModEffects.GURA_GURA_EFFECT.get());
        player.removeEffect(ModEffects.HIE_HIE_EFFECT.get());
        player.removeEffect(ModEffects.HITO_HITO_EFFECT.get());
        player.removeEffect(ModEffects.HORO_HORO_EFFECT.get());
        player.removeEffect(ModEffects.ITO_ITO_EFFECT.get());
        player.removeEffect(ModEffects.JIKI_JIKI_EFFECT.get());
        player.removeEffect(ModEffects.KAGE_KAGE_EFFECT.get());
        player.removeEffect(ModEffects.KILO_KILO_EFFECT.get());
        player.removeEffect(ModEffects.MAGU_MAGU_EFFECT.get());
        player.removeEffect(ModEffects.MERA_MERA_EFFECT.get());
        player.removeEffect(ModEffects.MOKU_MOKU_EFFECT.get());
        player.removeEffect(ModEffects.NEKO_NEKO_EFFECT.get());
        player.removeEffect(ModEffects.NIKYU_NIKYU_EFFECT.get());
        player.removeEffect(ModEffects.OPE_OPE_EFFECT.get());
        player.removeEffect(ModEffects.PIKA_PIKA_EFFECT.get());
        player.removeEffect(ModEffects.RYU_RYU_EFFECT.get());
        player.removeEffect(ModEffects.SUKE_SUKE_EFFECT.get());
        player.removeEffect(ModEffects.TORI_TORI_EFFECT.get());
        player.removeEffect(ModEffects.YAMI_YAMI_EFFECT.get());
        player.removeEffect(ModEffects.ZUSHI_ZUSHI_EFFECT.get());
    }
}