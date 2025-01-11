package net.caspian.tutorialmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GlockItem extends Item {

    public GlockItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        if (player != null && !world.isClient()) {

            Vec3d lookDirection = player.getRotationVec(1.0F).multiply(5.0);
            Vec3d playerPos = player.getEyePos();
            Box area = new Box(playerPos, playerPos.add(lookDirection));
            for (Entity entity : world.getEntitiesByClass(Entity.class, area, e -> e != player)) {
                entity.kill();
            }

            world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_ANVIL_FALL, SoundCategory.BLOCKS);
        }

        return ActionResult.SUCCESS;
    }
}