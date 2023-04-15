package io.github.charredgrass.charredmod.gui.buttons;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ToggleImageButton extends Button {


    private final int imgWidth, imgHeight;
    private boolean toggleState;
    private final ResourceLocation img, hovered, selected;


    public ToggleImageButton(int x, int y, int w, int h, Component component, OnPress onPress,
                             ResourceLocation img, ResourceLocation hovered, ResourceLocation selected,
                             int imgW, int imgH) {
        super(x, y, w, h, component, onPress, Button.DEFAULT_NARRATION);
        this.imgWidth = imgW;
        this.imgHeight = imgH;
        this.toggleState = false;
        this.img = img;
        this.hovered = hovered;
        this.selected = selected;
    }

    protected ResourceLocation getCurrImg() {
        return (toggleState ? selected : (this.isHovered() ? hovered : img));
    }

    @Override
    public void render(PoseStack pose, int x, int y, float partialTick) {
        //note: x,y = mouse pos
//        super.render(pose, x, y, partialTick);
        RenderSystem.setShaderTexture(0, this.getCurrImg());
        blit(pose, this.getX(), this.getY(), 0, 0, this.width, this.height, this.imgWidth, this.imgHeight);
    }

    public boolean isSelected() {
        return toggleState;
    }

    public void setToggleState(boolean toggleState) {
        this.toggleState = toggleState;
    }
}
