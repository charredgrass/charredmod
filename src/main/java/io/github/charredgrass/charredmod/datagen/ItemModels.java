package io.github.charredgrass.charredmod.datagen;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ItemModelProvider {
    public ItemModels(PackOutput packOutput, ExistingFileHelper helper) {
        super(packOutput, CharredMod.MODID, helper);
    }

    @Override
    protected void registerModels() {
        registerItemModel(ItemInit.ITEM_ICON, "item/icon");
        registerItemModel(ItemInit.KINETIC_BURST, "item/kinetic_burst");
        registerItemModel(ItemInit.KINETIC_DISPLACER, "item/kinetic_displacer");
        registerItemModel(ItemInit.KINETIC_FRUIT, "item/kinetic_fruit");
        registerItemModel(ItemInit.TELESTAFF, "item/telestaff");
    }

    private <Item> void registerItemModel(RegistryObject<Item> item, String locName) {
        singleTexture(item.getId().getPath(), mcLoc("item/generated"), "layer0",
                modLoc(locName));
    }
}
