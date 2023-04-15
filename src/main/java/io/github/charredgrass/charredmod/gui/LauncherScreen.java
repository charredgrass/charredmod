package io.github.charredgrass.charredmod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.gui.buttons.ToggleImageButton;
import io.github.charredgrass.charredmod.network.ModPacketHandler;
import io.github.charredgrass.charredmod.network.PacketSetLauncher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class LauncherScreen extends Screen {
    public LauncherScreen() {
        super(Component.literal("Menu"));
    }

    @Override
    protected void init() {
        super.init();
        int midX = this.width / 2;
        int midY = this.height / 2;
        int startDrawX = midX - (Button.DEFAULT_WIDTH / 2);
        int startDrawY = midY - (Button.DEFAULT_HEIGHT * 5);
        this.addRenderableWidget(
                Button.builder(Component.literal("Gaming"), (Button b) -> {
                    CharredMod.LOGGER.info("BUTTON CLICKED SEND PACKETING TIME");
                    ModPacketHandler.INSTANCE.sendToServer(new PacketSetLauncher(1));
                    Minecraft.getInstance().player.addDeltaMovement(new Vec3(0.0, 10.0, 0.0));
                }).pos(this.width/2, this.height/2).build()
        );
        ResourceLocation rl = new ResourceLocation(CharredMod.MODID, "textures/gui/button.png");
        ImageButton ib = new ImageButton(startDrawX, startDrawY,
                128, 128, 0, 0, 0,
                rl, 128, 128,
                (Button b) -> {
                    Minecraft.getInstance().player.addDeltaMovement(new Vec3(0.1, 10.0, 0.0));
                });
//        this.addRenderableWidget(ib);
        ToggleImageButton tib = new ToggleImageButton(startDrawX, startDrawY, 128, 128,
                Component.literal("juegos"), (Button b) -> {
            Minecraft.getInstance().player.addDeltaMovement(new Vec3(0.1, 10.0, 0.0));
        }, rl, 128, 128);
        this.addRenderableWidget(tib);
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
