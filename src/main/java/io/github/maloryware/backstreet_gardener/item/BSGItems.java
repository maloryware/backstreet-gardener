package io.github.maloryware.backstreet_gardener.item;

import io.github.maloryware.backstreet_gardener.block.BSGBlocks;
import io.github.maloryware.backstreet_gardener.item.custom.SmokableItem;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static io.github.maloryware.backstreet_gardener.component.BSGComponents.IS_LIT;

public class BSGItems {

	public static void register(String itemName, Item item){
		Registry.register(Registries.ITEM, Identifier.of("backstreet_gardener", itemName), item);
	}




	public static final Item CIGARETTE = new SmokableItem(new Item.Settings().rarity(Rarity.EPIC).maxDamage(255).maxCount(1).component(IS_LIT, false));
	public static final Item CIGARETTE_BUTT = new Item(new Item.Settings().maxCount(8));
	public static final Item TOBACCO_SEED = new AliasedBlockItem(BSGBlocks.TOBACCO_CROP,new Item.Settings().rarity(Rarity.UNCOMMON));
	public static final Item TOBACCO_LEAF = new Item(new Item.Settings().rarity(Rarity.RARE));


	public static void initialize(){

		register("cigarette", CIGARETTE);
		register("tobacco_seeds", TOBACCO_SEED);
		register("tobacco_leaf", TOBACCO_LEAF);
		register("cigarette_butt", CIGARETTE_BUTT);

	}

}
