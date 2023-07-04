package io.github.charredgrass.charredmod.entities;

import com.mojang.logging.LogUtils;
import io.github.charredgrass.charredmod.init.EntityInit;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;

import java.util.ArrayList;

public class SplittingArrowEntity extends BaseArrow {
    private int splits = 0;
    private static final double SPLIT_RATIO = 0.5; //[0,1] right to fwd
    private static final int FUSE = 10;
    private static final int NUM_SHOTS = 10;

    private static final Logger LOGGER = LogUtils.getLogger();

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter,
                                Level world, int splits) {
        super(entityType, shooter, world);
        this.splits = splits;
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z,
                                LivingEntity shooter, Level world) {
        super(entityType, x, y, z, shooter, world);
    }

    public SplittingArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z,
                                LivingEntity shooter, Level world, int splits) {
        super(entityType, x, y, z, shooter, world);
        this.splits = splits;
    }

    public void split() {
        LOGGER.info("splitting! " + this.splits);
        Vec3 upside = this.getUpVector(0.5F);
        Vec3 vel = this.getDeltaMovement();
        Vec3 perpRight = vel.cross(upside);
        Vec3 perpLeft = perpRight.scale(-1.0);
        double angle = 0.0;
        for (int i = 0; i < NUM_SHOTS / 2; i++) {
            angle += 1.0 / ((double) NUM_SHOTS / 2.0);
            Vec3 vRight = vel.scale(1-angle).add(perpRight.scale(angle));
            Vec3 vLeft = vel.scale(1-angle).add(perpLeft.scale(angle));
            SplittingArrowEntity right = new SplittingArrowEntity(EntityInit.SPLITTING_ARROW.get(),
                    this.getX(), this.getY(), this.getZ(), (LivingEntity) this.getOwner(), this.getCommandSenderWorld(),
                    this.splits - 1);
            SplittingArrowEntity left = new SplittingArrowEntity(EntityInit.SPLITTING_ARROW.get(),
                    this.getX(), this.getY(), this.getZ(), (LivingEntity) this.getOwner(), this.getCommandSenderWorld(),
                    this.splits - 1);
            right.setDeltaMovement(vRight);
            left.setDeltaMovement(vLeft);
            this.getCommandSenderWorld().addFreshEntity(right);
            this.getCommandSenderWorld().addFreshEntity(left);
        }
        this.discard();
    }

    @Override
    public void tick() {
        if (this.age >= FUSE && this.splits >= 1 && !this.inGround) {
            this.split();
            return;
        } else if (this.inGround && this.splits >= 1) {
            this.splits = 0;
        }
        super.tick();
    }
}
