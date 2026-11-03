package dev.zerotwo.menu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ZeroTwoMenuScreen extends Screen {
    private final Screen parent;
    private String status = "WELCOME BACK, DARLING.";

    public ZeroTwoMenuScreen(Screen parent) {
        super(Component.literal("ZERO TWO"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int buttonWidth = Math.min(220, this.width - 32);
        int left = (this.width - buttonWidth) / 2;
        int top = Math.max(72, this.height / 2 - 66);
        addRenderableWidget(Button.builder(Component.literal("RETURN TO GAME / MENU"),
                button -> Minecraft.getInstance().setScreen(parent))
                .bounds(left, top, buttonWidth, 24).build());
        addRenderableWidget(Button.builder(Component.literal("SINGLEPLAYER"),
                button -> status = "Choose Singleplayer from the vanilla menu to load your worlds.")
                .bounds(left, top + 30, buttonWidth, 22).build());
        addRenderableWidget(Button.builder(Component.literal("MULTIPLAYER"),
                button -> status = "Choose Multiplayer from the vanilla menu to join a server.")
                .bounds(left, top + 57, buttonWidth, 22).build());
        addRenderableWidget(Button.builder(Component.literal("MODS  •  RESOURCE PACKS"),
                button -> status = "Manage installed mods and resource packs from the game menu.")
                .bounds(left, top + 84, buttonWidth, 22).build());
        addRenderableWidget(Button.builder(Component.literal("CLOSE"),
                button -> Minecraft.getInstance().setScreen(parent))
                .bounds(left, top + 116, buttonWidth, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        graphics.fill(0, 0, this.width, this.height, 0xE9140912);
        graphics.fill(0, 0, this.width, 5, 0xFFFF2F78);
        graphics.drawCenteredString(this.font, Component.literal("ZERO TWO"), this.width / 2, Math.max(18, this.height / 2 - 112), 0xFFFF4F91);
        graphics.drawCenteredString(this.font, Component.literal("MINECRAFT  •  ANDROID EDITION"), this.width / 2, Math.max(36, this.height / 2 - 92), 0xFFE9DCE3);
        graphics.drawCenteredString(this.font, Component.literal(status), this.width / 2, this.height - 28, 0xFFFFB5CE);
        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    public void onClose() {
        Minecraft.getInstance().setScreen(parent);
    }
}
