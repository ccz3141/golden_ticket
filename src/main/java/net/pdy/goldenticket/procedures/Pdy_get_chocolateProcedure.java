package net.pdy.goldenticket.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.ItemHandlerHelper;

public class Pdy_get_chocolateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double pdy_get_chocolate_random = 0;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
