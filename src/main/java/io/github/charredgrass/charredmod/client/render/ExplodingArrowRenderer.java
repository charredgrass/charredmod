package io.github.charredgrass.charredmod.client.render;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.entities.ExplodingArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ExplodingArrowRenderer extends ArrowRenderer<ExplodingArrowEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(CharredMod.MODID, "textures/entity/projectiles/arrow.png");

    public ExplodingArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplodingArrowEntity arrow) {
        return TEXTURE;
    }
}
