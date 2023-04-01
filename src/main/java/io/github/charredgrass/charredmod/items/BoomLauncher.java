package io.github.charredgrass.charredmod.items;

import io.github.charredgrass.charredmod.entities.ExplodingArrowEntity;
import io.github.charredgrass.charredmod.entities.SplittingArrowEntity;
import io.github.charredgrass.charredmod.init.EntityInit;
import io.github.charredgrass.charredmod.util.CoordMath;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BoomLauncher extends Item {
    public BoomLauncher(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!player.level.isClientSide()) {
//            ExplodingArrowEntity arrow = new ExplodingArrowEntity(EntityInit.EXPLODING_ARROW.get(), player, world);
            SplittingArrowEntity arrow = new SplittingArrowEntity(EntityInit.SPLITTING_ARROW.get(), player, world);
//            arrow.setDeltaMovement(CoordMath.getLookDirection(player).normalize().scale(6.0));
            arrow.setSplits(3);
            arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
            world.addFreshEntity(arrow);
        }
        return super.use(world, player, hand);
    }
}
