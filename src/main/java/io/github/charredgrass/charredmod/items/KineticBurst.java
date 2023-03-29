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
import net.minecraft.world.phys.Vec3;

public class KineticBurst extends Item {

    private static final float DASH_INTENSITY = 3.0F;
    public KineticBurst(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        Vec3 vel = player.getDeltaMovement();
        if (vel.x == 0 && vel.z == 0) { //no lr movement
            player.getCooldowns().addCooldown(this, 5);
            return super.use(world, player, hand);
        }
        Vec3 burst = new Vec3(vel.x, 0.01, vel.z).normalize().scale(DASH_INTENSITY);
        player.addDeltaMovement(burst);
        player.getCooldowns().addCooldown(this, 5);
        return super.use(world, player, hand);
    }

}
