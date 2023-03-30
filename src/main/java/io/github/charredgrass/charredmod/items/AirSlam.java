package io.github.charredgrass.charredmod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AirSlam extends Item {
    public AirSlam(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.addDeltaMovement(new Vec3(0.0, -10.0, 0.0));
        world.explode(player, player.getX(), player.getY(), player.getZ(), 1.0F, Level.ExplosionInteraction.TNT);
        return super.use(world, player, hand);
    }
}
