package dev.zerotwo.menu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;

/** ZeroTwo-themed navigation hub; all game actions use Minecraft's native screens. */
public final class ZeroTwoMenuScreen extends Screen {
    private final Screen parent;

    public ZeroTwoMenuScreen(Screen parent) {
        super(Component.literal("ZERO TWO"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int buttonWidth = Math.min(236, Math.max(150, this.width - 40));
        int left = (this.width - buttonWidth) / 2;
        int buttonHeight = 22;
        int gap = 7;
        int total = buttonHeight * 4 + gap * 3;
        int top = Math.max(48, (this.height - total) / 2 + 12);
        addRenderableWidget(Button.builder(Component.literal("RESUME / RETURN"), button ->
                Minecraft.getInstance().setScreen(parent))
                .bounds(left, top, buttonWidth, buttonHeight).build());
        addRenderableWidget(Button.builder(Component.literal("SINGLEPLAYER"), button ->
                Minecraft.getInstance().setScreen(new SelectWorldScreen(this)))
                .bounds(left, top + buttonHeight + gap, buttonWidth, buttonHeight).build());
        addRenderableWidget(Button.builder(Component.literal("MULTIPLAYER"), button ->
                Minecraft.getInstance().setScreen(new JoinMultiplayerScreen(this)))
                .bounds(left, top + (buttonHeight + gap) * 2, buttonWidth, buttonHeight).build());
        addRenderableWidget(Button.builder(Component.literal("OPTIONS"), button ->
                Minecraft.getInstance().setScreen(new OptionsScreen(this, Minecraft.getInstance().options)))
                .bounds(left, top + (buttonHeight + gap) * 3, buttonWidth, buttonHeight).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        graphics.fill(0, 0, this.width, this.height, 0xFF100812);
        graphics.fill(0, 0, this.width, Math.max(1, this.height / 3), 0xFF1B0B19);
        graphics.fill(0, this.height - 5, this.width, this.height, 0xFFFF347C);
        graphics.fill(0, 0, 5, this.height, 0xFFFF347C);
        int cardWidth = Math.min(330, Math.max(1, this.width - 20));
        int cardLeft = (this.width - cardWidth) / 2;
        int cardTop = Math.max(6, this.height / 2 - 112);
        int cardBottom = Math.min(this.height - 6, this.height / 2 + 112);
        graphics.fill(cardLeft - 2, cardTop - 2, cardLeft + cardWidth + 2, cardBottom + 2, 0xFF6E2446);
        graphics.fill(cardLeft, cardTop, cardLeft + cardWidth, cardBottom, 0xE91A0D1B);
        graphics.drawCenteredString(this.font, Component.literal("ZERO TWO"),
                this.width / 2, Math.max(12, cardTop + 12), 0xFFFF4F91);
        graphics.drawCenteredString(this.font, Component.literal("MINECRAFT  •  ANDROID EDITION"),
                this.width / 2, Math.max(27, cardTop + 29), 0xFFE8C8D7);
        graphics.drawCenteredString(this.font, Component.literal("CHOOSE YOUR NEXT ADVENTURE"),
                this.width / 2, Math.min(this.height - 14, cardBottom - 15), 0xFFFFA8C5);
        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    public void onClose() {
        Minecraft.getInstance().setScreen(parent);
    }
}
