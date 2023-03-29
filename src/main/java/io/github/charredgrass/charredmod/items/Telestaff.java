package io.github.charredgrass.charredmod.items;

import io.github.charredgrass.charredmod.util.CoordMath;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class Telestaff extends Item {
    public Telestaff(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
//        BlockHitResult ray = getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE);
        BlockHitResult ray;
        if (player.isShiftKeyDown() == true) {
            ray = CoordMath.getPlayerBlockLook2D(world, player, ClipContext.Fluid.NONE, 16.0);
        } else {
            ray = CoordMath.getPlayerBlockLook(world, player, ClipContext.Fluid.NONE, 16.0);
        }
        BlockPos lookPos = ray.getBlockPos();
        player.setPos(lookPos.getX(), lookPos.getY(), lookPos.getZ());
        player.getCooldowns().addCooldown(this, 5);
        return super.use(world, player, hand);
    }
}
