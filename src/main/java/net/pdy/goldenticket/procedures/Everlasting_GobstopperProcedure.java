package net.pdy.goldenticket.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class Everlasting_GobstopperProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 0.1));
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 0.1));
	}
}
