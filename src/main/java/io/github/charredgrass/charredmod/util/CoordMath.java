package io.github.charredgrass.charredmod.util;

import com.mojang.logging.LogUtils;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;


public class CoordMath {
    private static final Logger LOGGER = LogUtils.getLogger();

    //modification of net.minecraft.world.item.Item.getPlayerPOVHitResult
    //gets the block the player is looking at, capped at range
    //This function is heavily commented because it is a close copy of the original Mojang code
    public static BlockHitResult getPlayerBlockLook(Level world, Player player, ClipContext.Fluid fluidMode, double range) {
        float xRot = player.getXRot();  //[-90, 90], forwards 0, up is 90, down is -90
        float yRot = player.getYRot();   //[-180, 180], left is -90, forwards 0, right 90
//        LOGGER.info("RAYTRACE: " + xRot + " " + yRot);
        Vec3 eyes = player.getEyePosition();
        /*
            x,z of target = <sin(-90-yRot), cos(-90-yRot)>
            convert to 3D:
            x,y,z = <sin(-90-yRot)*-cos(-xRot), sin(-xRot), cos(-90-yRot)*-cos(-xRot)>
         */
        //retaining this weird order because it's how it was in the Mojang code
        float zDist = Mth.cos(-yRot * ((float)Math.PI / 180F) - (float)Math.PI); //cos(-yRot-90) as radians
        float xDist = Mth.sin(-yRot * ((float)Math.PI / 180F) - (float)Math.PI);
        float yAdjustment = -Mth.cos(-xRot * ((float)Math.PI / 180F));
        float y = Mth.sin(-xRot * ((float)Math.PI / 180F));
        float x = xDist * yAdjustment;
        float z = zDist * yAdjustment;
        Vec3 target = eyes.add((double)x * range, (double)y * range, (double)z * range);
        return world.clip(new ClipContext(eyes, target, ClipContext.Block.OUTLINE, fluidMode, player));
    }

    public static BlockHitResult getPlayerBlockLook2D(Level world, Player player, ClipContext.Fluid fluidMode, double range) {
        float yRot = player.getYRot();
        Vec3 eyes = player.getEyePosition();
        float z = -Mth.cos(-yRot * ((float)Math.PI / 180F) - (float)Math.PI); //cos(-yRot-90) as radians
        float x = -Mth.sin(-yRot * ((float)Math.PI / 180F) - (float)Math.PI);
        Vec3 target = eyes.add((double)x * range, 0.0D, (double)z * range);
        return world.clip(new ClipContext(eyes, target, ClipContext.Block.OUTLINE, fluidMode, player));
    }
}
