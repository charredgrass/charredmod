package io.github.charredgrass.charredmod.init;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.items.KineticBurst;
import io.github.charredgrass.charredmod.items.KineticDisplacer;
import io.github.charredgrass.charredmod.items.KineticFruit;
import io.github.charredgrass.charredmod.items.Telestaff;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CharredMod.MODID);
    public static final RegistryObject<Item> ITEM_ICON = ITEMS.register("icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KINETIC_DISPLACER = ITEMS.register("kinetic_displacer",
            () -> new KineticDisplacer(new Item.Properties()));

    public static final RegistryObject<Item> TELESTAFF = ITEMS.register("telestaff",
            () -> new Telestaff(new Item.Properties()));

    public static final RegistryObject<Item> KINETIC_FRUIT = ITEMS.register("kinetic_fruit",
            () -> new KineticFruit(new Item.Properties()));

    public static final RegistryObject<Item> KINETIC_BURST = ITEMS.register("kinetic_burst",
            () -> new KineticBurst(new Item.Properties()));

}
