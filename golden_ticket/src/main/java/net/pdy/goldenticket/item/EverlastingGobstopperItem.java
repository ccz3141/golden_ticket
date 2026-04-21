
package net.pdy.goldenticket.item;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pdy.goldenticket.init.GoldenTicketModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EverlastingGobstopperItem extends Item {
	public EverlastingGobstopperItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.5f).alwaysEat().build()));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public boolean isRepairable(@NotNull ItemStack itemstack) {
		return false;
	}

	@Override
	public int getUseDuration(@NotNull ItemStack itemstack) {
		return 32;
	}

	@Override
	public boolean isCorrectToolForDrops(@NotNull BlockState state) {
		return true;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.golden_ticket.everlasting_gobstopper.description_0"));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		if (!world.isClientSide && entity instanceof Player player) {
			player.getFoodData().eat(1, 0.5f);
			player.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
			player.getCooldowns().addCooldown(this, 200);
		}
		return new ItemStack(GoldenTicketModItems.EVERLASTING_GOBSTOPPER.get());
	}
}
