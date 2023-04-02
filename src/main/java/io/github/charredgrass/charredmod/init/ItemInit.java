package io.github.charredgrass.charredmod.init;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.items.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CharredMod.MODID);
    public static final RegistryObject<Item> ITEM_ICON = ITEMS.register("icon",
            () -> new Icon(new Item.Properties()));
    public static final RegistryObject<Item> KINETIC_DISPLACER = ITEMS.register("kinetic_displacer",
            () -> new KineticDisplacer(new Item.Properties()));

    public static final RegistryObject<Item> TELESTAFF = ITEMS.register("telestaff",
            () -> new Telestaff(new Item.Properties()));

    public static final RegistryObject<Item> KINETIC_FRUIT = ITEMS.register("kinetic_fruit",
            () -> new KineticFruit(new Item.Properties()));

    public static final RegistryObject<Item> KINETIC_BURST = ITEMS.register("kinetic_burst",
            () -> new KineticBurst(new Item.Properties()));

    public static final RegistryObject<Item> AIR_SLAM = ITEMS.register("air_slam",
            () -> new AirSlam(new Item.Properties()));

    public static final RegistryObject<Item> BOOM_LAUNCHER = ITEMS.register("boom_launcher",
            () -> new BoomLauncher(new Item.Properties()));

}
