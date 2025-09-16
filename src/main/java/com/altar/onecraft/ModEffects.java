package com.altar.onecraft;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "onecraft");



    public static final RegistryObject<MobEffect> FRUITY = MOB_EFFECTS.register("fruity", () ->
            new MobEffect(MobEffectCategory.NEUTRAL, 0x00FF00) {
                public boolean isVisible() {
                    return true; // ensures HUD shows
                }
            });
}
