package io.github.charredgrass.charredmod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class KineticFruit extends Item {

    public KineticFruit(Properties properties) {
        super(properties.food(
                new FoodProperties.Builder().nutrition(0).saturationMod(0).alwaysEat()
//                        .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0), 1.0F)
                        .build()
        ));
    }

    @Override public ItemStack finishUsingItem(ItemStack item, Level level, LivingEntity user) {
        user.addDeltaMovement(new Vec3(0.0, 10.0, 0.0));
        return super.finishUsingItem(item, level, user);
    }


}
