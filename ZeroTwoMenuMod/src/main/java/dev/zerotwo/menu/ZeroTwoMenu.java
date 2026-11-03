package dev.zerotwo.menu;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.Component;

public final class ZeroTwoMenu implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof TitleScreen || screen instanceof PauseScreen) {
                int buttonWidth = Math.min(190, scaledWidth - 24);
                int x = (scaledWidth - buttonWidth) / 2;
                int y = screen instanceof TitleScreen ? scaledHeight - 34 : scaledHeight - 58;
                screen.addRenderableWidget(net.minecraft.client.gui.components.Button.builder(
                        Component.literal("ZERO TWO  •  MENU"),
                        button -> client.setScreen(new ZeroTwoMenuScreen(screen))
                ).bounds(x, y, buttonWidth, 22).build());
            }
        });
    }
}
