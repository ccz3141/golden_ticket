package net.pdy.goldenticket.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;
import net.pdy.goldenticket.init.GoldenTicketModItems;

public class Pdy_get_chocolateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double pdy_get_chocolate_random = 0;
		pdy_get_chocolate_random = Mth.nextInt(RandomSource.create(), 1, 20);
		if (pdy_get_chocolate_random == 10) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(GoldenTicketModItems.PACKET_CHOCOLATE_BAR.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (pdy_get_chocolate_random > 0 && pdy_get_chocolate_random < 10) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(GoldenTicketModItems.PACKET_CHOCOLATE_BAR.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
