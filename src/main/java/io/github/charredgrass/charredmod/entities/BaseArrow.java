package io.github.charredgrass.charredmod.entities;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

abstract class BaseArrow extends AbstractArrow {
    protected int age = 0;
    public BaseArrow(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    public BaseArrow(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public BaseArrow(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    public BaseArrow(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, LivingEntity shooter, Level world) {
        super(entityType, x, y, z, world);
        this.setOwner(shooter);
        if (shooter instanceof Player) {
            this.pickup = Pickup.ALLOWED;
        }
    }

    @Override
    public void tick() {
        this.age++;
        super.tick();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return super.getAddEntityPacket();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
