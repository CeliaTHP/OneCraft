package com.altar.onecraft;

import com.altar.onecraft.utils.Config;
import com.altar.onecraft.utils.CreativeTabs;
import com.altar.onecraft.utils.PlayerEffect;
import com.altar.onecraft.utils.ResourceDebug;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.server.TickTask;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OneCraftMod.MODID)
public class OneCraftMod {
    // Define mod id in a common place for everything to reference
    //TODO : Change mod ID
    public static final String MODID = "examplemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public OneCraftMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ModItems.ITEMS.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);
        CreativeTabs.register(modEventBus);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add custom block items to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        for (RegistryObject<Item> fruit : List.of(
                ModItems.GOMU_GOMU, ModItems.BOMU_BOMU, ModItems.GORO_GORO, ModItems.GURA_GURA,
                ModItems.HIE_HIE, ModItems.HITO_HITO, ModItems.HORO_HORO, ModItems.ITO_ITO,
                ModItems.JIKI_JIKI, ModItems.KAGE_KAGE, ModItems.KILO_KILO, ModItems.MAGU_MAGU,
                ModItems.MERA_MERA, ModItems.MOKU_MOKU, ModItems.NEKO_NEKO, ModItems.NIKYU_NIKYU,
                ModItems.OPE_OPE, ModItems.PIKA_PIKA, ModItems.RYU_RYU, ModItems.SUKE_SUKE,
                ModItems.TORI_TORI, ModItems.YAMI_YAMI, ModItems.ZUSHI_ZUSHI)) {
            event.accept(fruit.get());
        }
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        // Only run if this clone happened because of death
        if (!event.isWasDeath()) return;
        var oldPlayer = event.getOriginal();
        var newPlayer = event.getEntity();

        // Copy persistent fruity flag
        boolean wasFruity = oldPlayer.getPersistentData().getBoolean("fruity");
        newPlayer.getPersistentData().putBoolean("fruity", wasFruity);

        if (wasFruity) {
            // Delay the effect application to ensure proper synchronization
            if (!newPlayer.level().isClientSide) {
                newPlayer.level().getServer().execute(() -> {
                    // Add a small delay (1 tick) to ensure the player is fully loaded
                    newPlayer.level().getServer().tell(new TickTask(1, () -> {
                        PlayerEffect.makeFruity(newPlayer);
                    }));
                });
            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            ResourceDebug.checkResource("onecraft", "screens/background.png");


        }
    }
}
