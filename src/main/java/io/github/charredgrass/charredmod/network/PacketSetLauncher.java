package io.github.charredgrass.charredmod.network;

import io.github.charredgrass.charredmod.CharredMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSetLauncher {
    private final int mode;

    public PacketSetLauncher(int mode) {
        this.mode = mode;
    }
    public PacketSetLauncher(FriendlyByteBuf buf) {
        this.mode = buf.readInt();
    }
    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(this.mode);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                CharredMod.LOGGER.info("Handling");
                Vec3 v = player.getDeltaMovement();
                CharredMod.LOGGER.info("stuff: " + v.x + " " + v.y+ " " + v.z);
                player.addDeltaMovement(new Vec3(0.0, 10.0, 0.0));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
