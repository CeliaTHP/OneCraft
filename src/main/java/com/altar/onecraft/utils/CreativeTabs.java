package com.altar.onecraft.utils;


import com.altar.onecraft.ModItems;
import com.altar.onecraft.OneCraftMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CreativeTabs {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OneCraftMod.MODID);

    // List of all devil fruits for easy management
    private static final List<RegistryObject<Item>> DEVIL_FRUITS = List.of(
            ModItems.GOMU_GOMU, ModItems.BOMU_BOMU, ModItems.GORO_GORO, ModItems.GURA_GURA,
            ModItems.HIE_HIE, ModItems.HITO_HITO, ModItems.HORO_HORO, ModItems.ITO_ITO,
            ModItems.JIKI_JIKI, ModItems.KAGE_KAGE, ModItems.KILO_KILO, ModItems.MAGU_MAGU,
            ModItems.MERA_MERA, ModItems.MOKU_MOKU, ModItems.NEKO_NEKO, ModItems.NIKYU_NIKYU,
            ModItems.OPE_OPE, ModItems.PIKA_PIKA, ModItems.RYU_RYU, ModItems.SUKE_SUKE,
            ModItems.TORI_TORI, ModItems.YAMI_YAMI, ModItems.ZUSHI_ZUSHI
    );

    public static final RegistryObject<CreativeModeTab> DEVIL_FRUITS_TAB = CREATIVE_MODE_TABS.register("devil_fruits",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CREATIVE_TAB_ICON.get()))
                    .title(Component.translatable("creativetab.onecraft.devil_fruits"))
                    .displayItems((pParameters, pOutput) -> {
                        // Add all devil fruits using the loop
                        DEVIL_FRUITS.forEach(fruit -> pOutput.accept(fruit.get()));
                    })
                    .build());

    public static void register( IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}