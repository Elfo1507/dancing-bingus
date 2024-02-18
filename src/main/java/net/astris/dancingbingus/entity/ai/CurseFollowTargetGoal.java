package net.astris.dancingbingus.entity.ai;

import net.astris.dancingbingus.entity.custom.CurseEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CurseFollowTargetGoal extends FollowMobGoal {
    private final CurseEntity entity;
    public CurseFollowTargetGoal(Mob pMob, double pSpeedModifier, float pStopDistance, float pAreaSize) {
        super(pMob, pSpeedModifier, pStopDistance, pAreaSize);
        entity = ((CurseEntity) pMob);
    }

}
