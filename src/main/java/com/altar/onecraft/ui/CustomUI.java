package com.altar.onecraft.ui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class CustomUI extends Screen {

    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("onecraft", "screens/background.png");

    public CustomUI() {
        super(Component.literal("Custom UI"));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        // Optional default dark background
        this.renderBackground(guiGraphics);

        // Draw your texture
        guiGraphics.blit(BACKGROUND, 0, 0, 0, 0, width, height, width, height);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }
}
