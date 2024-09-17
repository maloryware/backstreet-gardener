package io.github.maloryware.backstreet_gardener.item.custom;

import io.github.maloryware.backstreet_gardener.component.BSGComponents;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class ProcessableLeafItem extends Item {
	public ProcessableLeafItem(Settings settings) {
		super(settings
			.component(BSGComponents.PROGRESS, 0));
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		super.appendTooltip(stack, context, tooltip, type);
	}

	@Override
	public int getItemBarStep(ItemStack stack) {
		// between 1 and 13
		return stack.getOrDefault(BSGComponents.PROGRESS, 0);
	}

	@Override
	public boolean isItemBarVisible(ItemStack stack) {
		// if processing progress > 0
		return stack.getOrDefault(BSGComponents.PROGRESS, 0) != 0;
	}

	@Override
	public int getItemBarColor(ItemStack stack) {
		// irrelevant but whatever
		return super.getItemBarColor(stack);
	}
}
