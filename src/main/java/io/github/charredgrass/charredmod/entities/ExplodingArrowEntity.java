package io.github.charredgrass.charredmod.entities;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class ExplodingArrowEntity extends BaseArrow {

    public ExplodingArrowEntity(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    public ExplodingArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public ExplodingArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    private void boom() {
        this.getCommandSenderWorld().explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, true, Level.ExplosionInteraction.TNT);
        this.discard();
    }

    @Override
    public void tick() {
        if (this.age >= 20) {
            this.boom();
            return;
        }
        super.tick();
    }

    @Override
    protected void onHitEntity(EntityHitResult target) {
        super.onHitEntity(target);
        this.boom();
    }

    @Override
    protected void onHitBlock(BlockHitResult target) {
        super.onHitBlock(target);
        this.boom();
    }
}
