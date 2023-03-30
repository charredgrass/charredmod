package io.github.charredgrass.charredmod.client;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.client.render.ExplodingArrowRenderer;
import io.github.charredgrass.charredmod.init.EntityInit;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CharredMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityInit.EXPLODING_ARROW.get(), ExplodingArrowRenderer::new);
    }
}
