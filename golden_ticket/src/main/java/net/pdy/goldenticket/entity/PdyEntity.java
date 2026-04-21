
package net.pdy.goldenticket.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.pdy.goldenticket.init.GoldenTicketModItems;
import net.pdy.goldenticket.init.GoldenTicketModEntities;
import net.pdy.goldenticket.init.GoldenTicketModSounds;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PdyEntity extends Animal {
	@SuppressWarnings("unused")
	public PdyEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(GoldenTicketModEntities.PDY.get(), world);
	}

	public PdyEntity(EntityType<PdyEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.8f);
		xpReward = 10;
		setNoAi(false);
		setCustomName(Component.literal("Pan_Da_Yang"));
		setCustomNameVisible(true);
	}

	@Override
	public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(@NotNull LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(3, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(GoldenTicketModItems.PACKET_CHOCOLATE_BAR.get()), false));
		this.goalSelector.addGoal(10, new TemptGoal(this, 1, Ingredient.of(GoldenTicketModItems.PACKET_CHOCOLATEBARINCLUDE.get()), false));
		this.targetSelector.addGoal(11, new HurtByTargetGoal(this));
	}

	@Override
	public @NotNull MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return GoldenTicketModSounds.PDY_CHOCOLATE_QUANZIDONGCHAOJIQIAOKELIGONGCHANG.get();
	}

	@Override
	public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
		this.playSound(Objects.requireNonNull(GoldenTicketModSounds.PDY_CHOCOLATE_RENYANGYITOUNIU.get()), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(@NotNull DamageSource ds) {
		return GoldenTicketModSounds.PDY_CHOCOLATE_ZHONGSUOZHOUZHI.get();
	}

	@Override
	public SoundEvent getDeathSound() {
		return GoldenTicketModSounds.PDY_CHOCOLATE_QUANZIDONGCHAOJIQIAOKELIGONGCHANG.get();
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION))
			return false;
		if (damagesource.is(DamageTypes.TRIDENT))
			return false;
		if (damagesource.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public AgeableMob getBreedOffspring(@NotNull ServerLevel serverWorld, @NotNull AgeableMob ageable) {
		PdyEntity retval = GoldenTicketModEntities.PDY.get().create(serverWorld);
        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
	}

	@Override
	public boolean isFood(@NotNull ItemStack stack) {
		return Ingredient.of(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "pdyfood"))).test(stack);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	public static boolean canSpawn(EntityType<PdyEntity> entityType, ServerLevelAccessor levelAccessor,
								   MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return Animal.checkAnimalSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
