package com.altar.onecraft;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "onecraft");


    public static final RegistryObject<MobEffect> BOMU_BOMU_EFFECT = MOB_EFFECTS.register("bomu_bomu_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> GOMU_GOMU_EFFECT = MOB_EFFECTS.register("gomu_gomu_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> GORO_GORO_EFFECT = MOB_EFFECTS.register("goro_goro_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> GURA_GURA_EFFECT = MOB_EFFECTS.register("gura_gura_effect", () ->
            new MobEffect(MobEffectCategory.HARMFUL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> HIE_HIE_EFFECT = MOB_EFFECTS.register("hie_hie_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> HITO_HITO_EFFECT = MOB_EFFECTS.register("hito_hito_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> HORO_HORO_EFFECT = MOB_EFFECTS.register("horo_horo_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> ITO_ITO_EFFECT = MOB_EFFECTS.register("ito_ito_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> JIKI_JIKI_EFFECT = MOB_EFFECTS.register("jiki_jiki_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> KAGE_KAGE_EFFECT = MOB_EFFECTS.register("kage_kage_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> KILO_KILO_EFFECT = MOB_EFFECTS.register("kilo_kilo_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> MAGU_MAGU_EFFECT = MOB_EFFECTS.register("magu_magu_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> MERA_MERA_EFFECT = MOB_EFFECTS.register("mera_mera_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> MOKU_MOKU_EFFECT = MOB_EFFECTS.register("moku_moku_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> NEKO_NEKO_EFFECT = MOB_EFFECTS.register("neko_neko_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> NIKYU_NIKYU_EFFECT = MOB_EFFECTS.register("nikyu_nikyu_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> OPE_OPE_EFFECT = MOB_EFFECTS.register("ope_ope_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> PIKA_PIKA_EFFECT = MOB_EFFECTS.register("pika_pika_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> RYU_RYU_EFFECT = MOB_EFFECTS.register("ryu_ryu_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> SUKE_SUKE_EFFECT = MOB_EFFECTS.register("suke_suke_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> TORI_TORI_EFFECT = MOB_EFFECTS.register("tori_tori_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> YAMI_YAMI_EFFECT = MOB_EFFECTS.register("yami_yami_effect", () ->
            new MobEffect(MobEffectCategory.HARMFUL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });
    public static final RegistryObject<MobEffect> ZUSHI_ZUSHI_EFFECT = MOB_EFFECTS.register("zushi_zushi_effect", () ->
            new MobEffect(MobEffectCategory.BENEFICIAL, 0x0000FF) {
                public boolean isVisible() { return true; }
            });

}
