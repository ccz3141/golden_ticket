
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pdy.goldenticket.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pdy.goldenticket.item.PacketChocolatebarincludeItem;
import net.pdy.goldenticket.item.PacketChocolateBarItem;
import net.pdy.goldenticket.item.GoldenticketItem;
import net.pdy.goldenticket.item.EverlastingGobstopperItem;
import net.pdy.goldenticket.GoldenTicketMod;

public class GoldenTicketModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GoldenTicketMod.MODID);
	public static final RegistryObject<Item> PACKET_CHOCOLATE_BAR = REGISTRY.register("packet_chocolate_bar", () -> new PacketChocolateBarItem());
	public static final RegistryObject<Item> PDY_SPAWN_EGG = REGISTRY.register("pdy_spawn_egg", () -> new ForgeSpawnEggItem(GoldenTicketModEntities.PDY, -6044161, -1, new Item.Properties()));
	public static final RegistryObject<Item> EVERLASTING_GOBSTOPPER = REGISTRY.register("everlasting_gobstopper", () -> new EverlastingGobstopperItem());
	public static final RegistryObject<Item> PACKET_CHOCOLATEBARINCLUDE = REGISTRY.register("packet_chocolatebarinclude", () -> new PacketChocolatebarincludeItem());
	public static final RegistryObject<Item> GOLDENTICKET = REGISTRY.register("goldenticket", () -> new GoldenticketItem());
	public static final RegistryObject<Item> PMTX_SPAWN_EGG = REGISTRY.register("pmtx_spawn_egg", () -> new ForgeSpawnEggItem(GoldenTicketModEntities.PMTX, -13434676, -3342337, new Item.Properties()));
	public static final RegistryObject<Item> COMPUTER_1101_SPAWN_EGG = REGISTRY.register("computer_1101_spawn_egg", () -> new ForgeSpawnEggItem(GoldenTicketModEntities.COMPUTER_1101, -10066330, -10066330, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
