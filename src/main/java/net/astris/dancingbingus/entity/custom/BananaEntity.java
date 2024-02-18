package net.astris.dancingbingus.entity.custom;

import net.astris.dancingbingus.entity.ModEntities;
import net.astris.dancingbingus.sound.ModSounds;
import net.astris.dancingbingus.util.ModTags;
import net.minecraft.client.particle.WaterDropParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BananaEntity extends Animal {
    public BananaEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int curseSpawnDelay = 0;


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new FollowBoatGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 999999.0F));
        this.goalSelector.addGoal(4, new FollowMobGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new TemptGoal(this, 1.5D, Ingredient.of(ModTags.Items.FISHES), false));
    }

    @Override
    public void tick() {
        if(this.isAlive()) {
            this.level().addParticle(ParticleTypes.DRIPPING_WATER, this.getX(), this.getY(0.5D), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
        super.tick();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.FOLLOW_RANGE, 10);
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModTags.Items.FISHES);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BINGUS_AMBIENT.get();
    }

    @Override
    protected void tickDeath() {
        super.tickDeath();
        if (!this.level().isClientSide && this.curseSpawnDelay == 0) {
            EntityType<CurseEntity> curse = ModEntities.CURSE.get();
            curse.spawn((ServerLevel) this.level(), this.blockPosition(), MobSpawnType.TRIGGERED);
            this.curseSpawnDelay++;
        } else {
            this.curseSpawnDelay++;
            if (this.curseSpawnDelay > 100) {
                this.curseSpawnDelay = 0;
            }
        }
    }
}
