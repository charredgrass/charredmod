package io.github.charredgrass.charredmod.gui.buttons;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ImageButton extends Button {

    protected ResourceLocation img;
    private final int imgWidth, imgHeight;


    public ImageButton(int x, int y, int w, int h, Component component, OnPress onPress,
                       ResourceLocation img, int imgW, int imgH) {
        super(x, y, w, h, component, onPress, Button.DEFAULT_NARRATION);
        this.img = img;
        this.imgWidth = imgW;
        this.imgHeight = imgH;
    }

    @Override
    public void render(PoseStack pose, int x, int y, float partialTick) {
//        super.render(pose, x, y, partialTick);
        RenderSystem.setShaderTexture(0, this.img);
        blit(pose, x, y, 0, 0, this.width, this.height, this.imgWidth, this.imgHeight);
    }
}
