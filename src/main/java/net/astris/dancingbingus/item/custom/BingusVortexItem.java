package net.astris.dancingbingus.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class BingusVortexItem extends Item {
    public BingusVortexItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if(!level.isClientSide) {
            BlockPos blockPos = pContext.getClickedPos();

            for (int i = -26; i < 25 ; i++) {
                for (int j = -26; j < 25; j++) {
                    for (int k = -26; k < 25; k++) {
                        BlockPos blockPos1 = blockPos.offset(i, j, k);
                        BlockState state = pContext.getLevel().getBlockState(blockPos1);
                        if (!state.isAir() && blockPos.distToCenterSqr(blockPos1.getX(), blockPos1.getY(), blockPos1.getZ()) < 50) {
                            level.destroyBlock(blockPos1, true);
                        }
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.dancingbingus.bingus_vortex.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}