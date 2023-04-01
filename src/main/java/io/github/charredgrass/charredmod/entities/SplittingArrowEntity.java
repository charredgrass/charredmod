package io.github.charredgrass.charredmod.entities;

import io.github.charredgrass.charredmod.init.EntityInit;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SplittingArrowEntity extends BaseArrow {
    private int splits = 1;
    private static final double SPLIT_RATIO = 0.5; //[0,1] right to fwd

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, LivingEntity shooter, Level world) {
        super(entityType, x, y, z, shooter, world);
    }

    public void setNonSplitting() {
        this.splits = 0;
    }

    public void split() {
        if (this.splits <= 0 || this.inGround) return;
        splits--;
        Vec3 upside = this.getUpVector(0.5F);
        Vec3 vel = this.getDeltaMovement();
        Vec3 perpRight = vel.cross(upside);
        Vec3 perpLeft = perpRight.scale(-1.0);
        Vec3 splitRight = vel.scale(1-SPLIT_RATIO).add(perpRight.scale(SPLIT_RATIO));
        Vec3 splitLeft = vel.scale(1-SPLIT_RATIO).add(perpLeft.scale(SPLIT_RATIO));
        SplittingArrowEntity left = new SplittingArrowEntity(EntityInit.SPLITTING_ARROW.get(),
                this.getX(), this.getY(), this.getZ(), (LivingEntity) this.getOwner(), this.level);
        SplittingArrowEntity right = new SplittingArrowEntity(EntityInit.SPLITTING_ARROW.get(),
                this.getX(), this.getY(), this.getZ(), (LivingEntity) this.getOwner(), this.level);
        left.setDeltaMovement(splitLeft);
        right.setDeltaMovement(splitRight);
        left.setNonSplitting();
        right.setNonSplitting();
        this.level.addFreshEntity(left);
        this.level.addFreshEntity(right);
        this.discard();
    }

    @Override
    public void tick() {
        if (this.age >= 10 && this.splits >= 1) {
            this.split();
            return;
        }
        super.tick();
    }
}
