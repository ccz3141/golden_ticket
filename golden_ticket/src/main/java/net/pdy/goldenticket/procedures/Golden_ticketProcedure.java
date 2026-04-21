package net.pdy.goldenticket.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import net.pdy.goldenticket.init.GoldenTicketModItems;

public class Golden_ticketProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ChocolateProcedure.execute(world, entity, itemstack);
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(GoldenTicketModItems.GOLDENTICKET.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
