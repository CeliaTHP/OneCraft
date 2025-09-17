package com.altar.onecraft;

import com.altar.onecraft.fruits.models.FruitItem;
import com.altar.onecraft.player.PlayerEffect;
import com.altar.onecraft.ui.CreativeTabs;
import com.altar.onecraft.ui.DisplayOverlay;
import com.altar.onecraft.utils.Config;
import com.altar.onecraft.utils.CustomLogger;
import com.altar.onecraft.utils.KeyBindings;
import com.altar.onecraft.utils.ResourceDebug;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.server.TickTask;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
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
import java.util.UUID;

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
        String fruitTypeName = oldPlayer.getPersistentData().getString("fruit_type");

        newPlayer.getPersistentData().putBoolean("fruity", wasFruity);

        // Reset fruity effect if player died being fruity
        if (wasFruity && fruitTypeName != null && !fruitTypeName.isEmpty()) {
            FruitItem.FruitType oldFruit = FruitItem.FruitType.valueOf(oldPlayer.getPersistentData().getString("fruit_type"));

            // Delay the effect so UI loads correctly
            if (!newPlayer.level().isClientSide) {
                newPlayer.level().getServer().execute(() -> {
                    newPlayer.level().getServer().tell(new TickTask(1, () -> {
                        PlayerEffect.makeFruity(newPlayer, oldFruit);
                    }));
                });
            }
        }
    }

    @SubscribeEvent
    public void onTickPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        UUID FRUITY_SWIM_MODIFIER_ID = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");


        boolean isFruity = player.getPersistentData().getBoolean("fruity");

        if (isFruity && player.isInWater()) {

            player.setDeltaMovement(0, -0.8, 0);  // Only sink, no horizontal movement at all

            player.setSwimming(false);

            AttributeInstance swimSpeedAttr = player.getAttribute(ForgeMod.SWIM_SPEED.get());
            if (swimSpeedAttr != null) {
                swimSpeedAttr.removeModifier(FRUITY_SWIM_MODIFIER_ID);

                swimSpeedAttr.addTransientModifier(new AttributeModifier(FRUITY_SWIM_MODIFIER_ID, "fruity_sink", -5.0, AttributeModifier.Operation.ADDITION));

            }

            // Optional: Add drowning damage every 2 seconds
            if (player.tickCount % 40 == 0) {
                player.hurt(player.damageSources().drown(), 2.0F);
            }
        }

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        KeyBindings.register(event);
    }


    @SubscribeEvent
    public void onRenderGui(RenderGuiEvent.Post event) {
        //Disable overlay if no fruit or if fruit overlay key pressed

        if (PlayerEffect.CURRENT_OVERLAY == null || !PlayerEffect.SHOW_OVERLAY) {
            return;
        }

        GuiGraphics guiGraphics = event.getGuiGraphics();

        //Add spellbar if fruit + parameter to display corresponding bar
        DisplayOverlay.renderPngOverlay(guiGraphics, Minecraft.getInstance(), PlayerEffect.CURRENT_OVERLAY,
                01.0f, // X position from left
                90.0f,   // Y position from top
                20.0f,
                10.0f
        );
    }


    @SubscribeEvent
    public static void onLivingTickAdvanced(LivingEvent.LivingTickEvent event) {
        CustomLogger.d("FRUITY_CHECK", "player null = ");

        if (!(event.getEntity() instanceof Player player)) return;

        boolean isFruity = player.getPersistentData().getBoolean("fruity");
        CustomLogger.d("FRUITY_CHECK", "fruity = " + isFruity);
        CustomLogger.d("FRUITY_CHECK", "onWater = " + player.isInWater());
        CustomLogger.d("FRUITY_CHECK", "isSwimming = " + player.isSwimming());


/*
        //Check if walks on water block //script to launch /attribute
        if (isFruity && player.isInWater()) {

            // Strong sinking force - more aggressive than your original
            Vec3 deltaMovement = player.getDeltaMovement();
            player.setDeltaMovement(
                    deltaMovement.x * 0.1,  // Almost stop horizontal movement
                    Math.min(deltaMovement.y, -0.3),  // Stronger downward force
                    deltaMovement.z * 0.1
            );

            // Disable swimming animation and abilities
            player.setSwimming(false);

            // Prevent any upward movement from swimming attempts
            if (deltaMovement.y > -0.1) {
                player.addDeltaMovement(new Vec3(0, -0.2, 0));
            }

            // Add bubble particles (client-side effect)
            if (player.level().isClientSide && player.getRandom().nextFloat() < 0.15F) {
                player.level().addParticle(
                        ParticleTypes.BUBBLE,
                        player.getX() + (player.getRandom().nextDouble() - 0.5) * 0.5,
                        player.getY() + player.getRandom().nextDouble() * 0.5,
                        player.getZ() + (player.gtRandom().nextDouble() - 0.5) * 0.5,
                        0, 0.1, 0
                );
            }

            // Optional: Add drowning damage every 2 seconds
            if (player.tickCount % 40 == 0) {
                player.hurt(player.damageSources().drown(), 1.0F);
            }

            // Optional: Send message to player
            if (player instanceof ServerPlayer serverPlayer && player.tickCount % 60 == 0) {
                serverPlayer.displayClientMessage(
                        Component.literal("§cYou're too fruity to swim! You're sinking!"),
                        true
                );
            }
        }

 */


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
