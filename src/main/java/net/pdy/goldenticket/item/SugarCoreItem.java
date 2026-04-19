package net.pdy.goldenticket.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SugarCoreItem extends Item {
	public SugarCoreItem() {
		super(new Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.5f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(@NotNull ItemStack itemstack) {
		return 32;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		if (!world.isClientSide && entity instanceof Player player) {
			player.getFoodData().eat(1, 0.1f);
			player.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
		}
		return super.finishUsingItem(itemstack, world, entity);
	}
}
