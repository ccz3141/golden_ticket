
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pdy.goldenticket.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pdy.goldenticket.GoldenTicketMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoldenTicketModTabs {
	// Creative mode tabs
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoldenTicketMod.MODID);

	public static final RegistryObject<CreativeModeTab> GOLDEN_TICKET_TAB =
			CREATIVE_MODE_TABS.register("golden_ticket_tab", () -> CreativeModeTab.builder()
					.title(Component.translatable("item_group." + GoldenTicketMod.MODID + ".golden_ticket_tab"))
					.icon(() -> new ItemStack(GoldenTicketModItems.GOLDENTICKET.get()))
					.displayItems((parameters, output) -> {
						output.accept(GoldenTicketModItems.PACKET_CHOCOLATE_BAR.get());
						output.accept(GoldenTicketModItems.PACKET_CHOCOLATEBARINCLUDE.get());
						output.accept(GoldenTicketModItems.GOLDENTICKET.get());
						output.accept(GoldenTicketModItems.EVERLASTING_GOBSTOPPER.get());
						output.accept(GoldenTicketModItems.PDY_SPAWN_EGG.get());
						output.accept(GoldenTicketModItems.PMTX_SPAWN_EGG.get());
						output.accept(GoldenTicketModItems.COMPUTER_1101_SPAWN_EGG.get());
						output.accept(GoldenTicketModItems.SUGARSLICE.get());
						output.accept(GoldenTicketModItems.SUGARCORE.get());
						output.accept(GoldenTicketModItems.EDIBLEBINDER.get());
						output.accept(GoldenTicketModItems.UNMELTINGSUGARCORE.get());
						output.accept(GoldenTicketModItems.DICK.get());
					})
					.build()
			);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(GoldenTicketModItems.PDY_SPAWN_EGG.get());
			tabData.accept(GoldenTicketModItems.PMTX_SPAWN_EGG.get());
			tabData.accept(GoldenTicketModItems.COMPUTER_1101_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(GoldenTicketModItems.EDIBLEBINDER.get());
			tabData.accept(GoldenTicketModItems.UNMELTINGSUGARCORE.get());
			tabData.accept(GoldenTicketModItems.SUGARSLICE.get());
			tabData.accept(GoldenTicketModItems.SUGARCORE.get());
			tabData.accept(GoldenTicketModItems.GOLDENTICKET.get());
			tabData.accept(GoldenTicketModItems.DICK.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(GoldenTicketModItems.PACKET_CHOCOLATEBARINCLUDE.get());
			tabData.accept(GoldenTicketModItems.PACKET_CHOCOLATE_BAR.get());
			tabData.accept(GoldenTicketModItems.EVERLASTING_GOBSTOPPER.get());
		}
	}
}
