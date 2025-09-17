package com.altar.onecraft.player;

import com.altar.onecraft.ModEffects;
import com.altar.onecraft.fruits.models.FruitItem;
import com.altar.onecraft.utils.CustomLogger;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

public class PlayerEffect {


    //TODO : Class to handle persistend data manipulation

    public static void makeFruity(Player player, FruitItem.FruitType fruitType) {
        CustomLogger.d("MAKE_FRUITY", "fruity = true & fruit type = " + fruitType);

        player.getPersistentData().putBoolean("fruity", true);
        player.getPersistentData().putString("fruit_type", fruitType.name());

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
