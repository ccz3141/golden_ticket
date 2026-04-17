
package net.pdy.goldenticket.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pdy.goldenticket.init.GoldenTicketModSounds;
import org.jetbrains.annotations.NotNull;

public class DickItem extends RecordItem {
	public DickItem() {
		super(15, GoldenTicketModSounds.PDY_CHOCOLATE1,
				new Item.Properties().durability(2).fireResistant().rarity(Rarity.RARE),
				4600);
	}

	@Override
	
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public boolean isRepairable(@NotNull ItemStack itemstack) {
		return false;
	}

	@Override
	
	public int getEnchantmentValue() {
		return 1;
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
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player entity, @NotNull InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		return ar;
	}
}
