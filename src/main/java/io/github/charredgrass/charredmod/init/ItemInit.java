package io.github.charredgrass.charredmod.init;

import io.github.charredgrass.charredmod.CharredMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CharredMod.MODID);
    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("icon",
            () -> new Item(new Item.Properties()));

}
