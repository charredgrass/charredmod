package io.github.charredgrass.charredmod.items;

import io.github.charredgrass.charredmod.gui.LauncherScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class Icon extends Item {

    public Icon(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.getCommandSenderWorld().isClientSide()) {
            Minecraft.getInstance().setScreen(new LauncherScreen());
        }
        return super.use(world, player, hand);
    }
}
