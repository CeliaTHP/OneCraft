package com.altar.onecraft.ui;

import com.altar.onecraft.utils.CustomLogger;
import com.altar.onecraft.utils.ResourceDebug;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.io.IOException;
import java.util.Optional;


public class DisplayOverlay {

    // Define your PNG texture location



    /**
     * Renders a PNG overlay with percentage-based positioning and sizing
     *
     * @param guiGraphics   The graphics context
     * @param mc            Minecraft instance
     * @param texture       The PNG texture resource location
     * @param xPercent      X position as percentage of screen width (0-100)
     * @param yPercent      Y position as percentage of screen height (0-100)
     * @param widthPercent  Width as percentage of screen width (0-100)
     * @param heightPercent Height as percentage of screen height (0-100)
     */
    public static void renderPngOverlay(GuiGraphics guiGraphics, Minecraft mc, ResourceLocation texture,
                                        float xPercent, float yPercent, float widthPercent, float heightPercent) {


        Optional<Resource> resourceOpt;

        resourceOpt = mc.getResourceManager().getResource(texture);
/*
        if (resourceOpt.isEmpty()) {
            CustomLogger.e("DisplayOverlay", "Missing texture: " + texture +
                    " | Expected at: assets/" + texture.getNamespace() + "/textures/" + texture.getPath());
            return;
        } else {
            CustomLogger.d("DisplayOverlay", "Found texture: " + texture +
                    " | Physical path: assets/" + texture.getNamespace() + "/textures/" + texture.getPath());
        }

 */


        // Get screen dimensions
        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        // Calculate actual pixel positions and sizes from percentages
        int x = (int) (screenWidth * (xPercent / 100.0f));
        int y = (int) (screenHeight * (yPercent / 100.0f));
        int width = (int) (screenWidth * (widthPercent / 100.0f));
        int height = (int) (screenHeight * (heightPercent / 100.0f));

        // Ensure minimum size (prevent 0-size renders)
        width = Math.max(width, 1);
        height = Math.max(height, 1);

        // Render the PNG with calculated dimensions

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, x, y, width, height, 0, 0, width, height, width, height);
        RenderSystem.disableBlend();


    }
}

