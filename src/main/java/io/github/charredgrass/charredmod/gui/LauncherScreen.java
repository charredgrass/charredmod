package io.github.charredgrass.charredmod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.network.ModPacketHandler;
import io.github.charredgrass.charredmod.network.PacketSetLauncher;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class LauncherScreen extends Screen {
    public LauncherScreen() {
        super(Component.literal("Menu"));
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(
                Button.builder(Component.literal("Gaming"), (Button b) -> {
                    CharredMod.LOGGER.info("BUTTON CLICKED SEND PACKETING TIME");
                    ModPacketHandler.INSTANCE.sendToServer(new PacketSetLauncher(1));
                }).build()
        );
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(pose);
        super.render(pose, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
