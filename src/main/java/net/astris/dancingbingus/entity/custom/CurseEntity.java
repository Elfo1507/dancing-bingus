package net.astris.dancingbingus.entity.custom;

import net.astris.dancingbingus.entity.ai.CurseAttackGoal;
import net.astris.dancingbingus.sound.ModSounds;
import net.astris.dancingbingus.util.ModRemovalReason;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class CurseEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CurseEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public CurseEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 10D)
                .add(Attributes.FOLLOW_RANGE, 999999999999999999999999D)
                .add(Attributes.MAX_HEALTH, 999999999999999999999999D)
                .add(Attributes.ATTACK_DAMAGE, 10D);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CurseAttackGoal(this, 2.0D, true));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }
    @Override
    public void tick() {
        if(this.level().isClientSide()){
            this.level().getNearbyPlayers(TargetingConditions.DEFAULT ,this,
                            AABB.ofSize(this.getPosition(1F), 100, 100, 100))
                    .forEach(player -> {
                        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 9999999, 999));
                    });
        }
        super.tick();
    }


    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 50;
            this.idleAnimationState.start(this.tickCount);
        } else {
            this.idleAnimationTimeout--;
        }

        if (this.isAttacking() && this.attackAnimationTimeout < 0) {
            attackAnimationTimeout = 10;
        } else {
            this.attackAnimationTimeout--;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    protected void doAutoAttackOnTouch(LivingEntity pTarget) {
        super.doAutoAttackOnTouch(pTarget);
    }

    @Override
    public boolean killedEntity(ServerLevel pLevel, LivingEntity pEntity) {
        this.die(new DamageSource((Holder<DamageType>) DamageTypes.FELL_OUT_OF_WORLD, this, this));
        if(this.level().isClientSide()){
            this.level().getNearbyPlayers(TargetingConditions.DEFAULT ,this,
                            AABB.ofSize(this.getPosition(1F), 100, 100, 100))
                    .forEach(player -> {
                        player.removeEffect(MobEffects.BLINDNESS);
                    });
        }
        return super.killedEntity(pLevel, pEntity);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.RICKROLL.get();
    }
}
