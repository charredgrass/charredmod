package io.github.charredgrass.charredmod.client.render;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.entities.SplittingArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SplittingArrowRenderer extends ArrowRenderer<SplittingArrowEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(CharredMod.MODID, "textures/entity/projectiles/arrow.png");

    public SplittingArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(SplittingArrowEntity arrow) {
        return TEXTURE;
    }
}
