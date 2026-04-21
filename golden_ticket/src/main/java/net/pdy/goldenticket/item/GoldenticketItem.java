
package net.pdy.goldenticket.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class GoldenticketItem extends Item {
	public GoldenticketItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
	}
}
