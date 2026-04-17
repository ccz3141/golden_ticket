
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pdy.goldenticket.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pdy.goldenticket.entity.PdyEntity;
import net.pdy.goldenticket.entity.Computer1101Entity;
import net.pdy.goldenticket.GoldenTicketMod;
import net.pdy.goldenticket.entity.PmtxEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoldenTicketModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GoldenTicketMod.MODID);
	public static final RegistryObject<EntityType<PdyEntity>> PDY = register("pdy",
			EntityType.Builder.<PdyEntity>of(PdyEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PdyEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PmtxEntity>> PMTX = register("pmtx",
			EntityType.Builder.<PmtxEntity>of(PmtxEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PmtxEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Computer1101Entity>> COMPUTER_1101 = register("computer_1101", EntityType.Builder.<Computer1101Entity>of(Computer1101Entity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Computer1101Entity::new).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(PDY.get(), PdyEntity.createAttributes().build());
		event.put(PMTX.get(), PmtxEntity.createAttributes().build());
		event.put(COMPUTER_1101.get(), Computer1101Entity.createAttributes().build());
	}

	@SubscribeEvent
	public static void onRegisterSpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(
				COMPUTER_1101.get(),
				SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Computer1101Entity::canSpawn,
				SpawnPlacementRegisterEvent.Operation.AND
		);

		event.register(
				PDY.get(),
				SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				PdyEntity::canSpawn,           // 需要在PdyEntity中实现canSpawn方法
				SpawnPlacementRegisterEvent.Operation.AND
		);

		event.register(
				PMTX.get(),
				SpawnPlacements.Type.IN_WATER,  // 可以根据实体不同选择不同的生成类型
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				PmtxEntity::canSpawn,
				SpawnPlacementRegisterEvent.Operation.AND
		);
	}
}
