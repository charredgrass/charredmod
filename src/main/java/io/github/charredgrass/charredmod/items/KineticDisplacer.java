package io.github.charredgrass.charredmod.items;

import io.github.charredgrass.charredmod.util.CoordMath;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class KineticDisplacer extends Item {
    public KineticDisplacer(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
//        player.setPos(player.getX(), player.getY() + 10.0, player.getZ());
//        player.setDeltaMovement(0.0, 10.0D, 0.0);
        player.addDeltaMovement(new Vec3(0.0, 10.0, 0.0));
//        player.addDeltaMovement(CoordMath.getLookDirection(player).scale(10.0D));
        player.getCooldowns().addCooldown(this, 20);
        return super.use(world, player, hand);
    }

//    @Override
//    public InteractionResult interactLivingEntity(ItemStack item, Player player, LivingEntity entity, InteractionHand hand) {
//        entity.move();
//        return InteractionResult.SUCCESS;
//    }
}
