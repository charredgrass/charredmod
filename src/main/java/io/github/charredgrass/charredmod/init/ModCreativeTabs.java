package io.github.charredgrass.charredmod.init;


import com.mojang.logging.LogUtils;
import io.github.charredgrass.charredmod.CharredMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = CharredMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CharredMod.MODID);

    public static ResourceKey<CreativeModeTab> MOD_TAB = MOD_TABS.register("charredmod_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group." + CharredMod.MODID + ".charredmod"))
                    .icon(() -> ItemInit.ITEM_ICON.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(ItemInit.ITEM_ICON.get());
                    })
                    .build()
    ).getKey();
    private static final Logger LOGGER = LogUtils.getLogger();
//    @SubscribeEvent
//    public static void onCreativeTabRegistry(BuildCreativeModeTabContentsEvent event) {
//        MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(CharredMod.MODID, "charredmod"),
//                    builder -> {
//                        builder.title(Component.translatable("item_group." + CharredMod.MODID + ".charredmod"))
//                                .icon(() -> new ItemStack(ItemInit.ITEM_ICON.get())).build();
//                    }
//                );
//            LOGGER.info("creative tabs registered");
//
//    }
}
