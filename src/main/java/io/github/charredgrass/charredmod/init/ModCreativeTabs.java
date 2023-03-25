package io.github.charredgrass.charredmod.init;


import com.mojang.logging.LogUtils;
import io.github.charredgrass.charredmod.CharredMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = CharredMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabs {

    public static CreativeModeTab MOD_TAB;
    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void onCreativeTabRegistry(CreativeModeTabEvent.Register event) {
        MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(CharredMod.MODID, "charredmod"),
                    builder -> {
                        builder.title(Component.translatable("item_group." + CharredMod.MODID + ".charredmod"))
                                .icon(() -> new ItemStack(ItemInit.ITEM_ICON.get())).build();
                    }
                );
            LOGGER.info("creative tabs registering eeeeeeeeeeeee");

    }
}
