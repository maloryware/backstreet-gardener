package io.github.maloryware.backstreet_gardener.datagen;

import io.github.maloryware.backstreet_gardener.component.BSGComponents;
import io.github.maloryware.backstreet_gardener.item.BSGItems;
import io.github.maloryware.backstreet_gardener.item.custom.ProcessableLeafItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ClampedModelPredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

import static io.github.maloryware.backstreet_gardener.BackstreetGardener.ID;

@Environment(EnvType.CLIENT)
public class ModelPredicateProvider extends ModelPredicateProviderRegistry {

	public static void register(){

		ClampedModelPredicateProvider moking = (itemStack, clientWorld, livingEntity, seed) ->
		{
			if(livingEntity != null) return livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
			else return 0.0F;
		};

		ClampedModelPredicateProvider lit = (itemStack, clientWorld, livingEntity, seed) ->
		{
			if(livingEntity != null) return itemStack.getDamage() > 0 ? 1.0F : 0.0F;
			else return 0.0F;
		};

		ClampedModelPredicateProvider hasWater = (itemStack, clientWorld, livingEntity, seed) -> {

			if (livingEntity != null) return itemStack.get(BSGComponents.BONG_COMPONENT).hasWater() ? 1.0F : 0.0F;
			else return 0.0F;
		};

		ClampedModelPredicateProvider dryness = (itemStack, clientWorld, livingEntity, seed) -> {
			if (itemStack.getItem() instanceof ProcessableLeafItem leafItem) {
				return  ((float)(itemStack.getOrDefault(BSGComponents.PROGRESS, 0) + 1) / (leafItem.getDefinedMaxProgress() + 1));
			}
			return 0.0F;
		};

		register(BSGItems.BONG, Identifier.of(ID,"moking"), moking);
		register(BSGItems.BONG, Identifier.of(ID,"has_water"), hasWater);

		register(BSGItems.BLUNT, Identifier.of(ID,"moking"), moking);
		register(BSGItems.BLUNT, Identifier.of(ID,"lit"), lit);

		register(BSGItems.JOINT, Identifier.of(ID,"moking"), moking);
		register(BSGItems.JOINT, Identifier.of(ID,"lit"), lit);

		register(BSGItems.CIGARETTE, Identifier.of(ID,"moking"), moking);
		register(BSGItems.CIGARETTE, Identifier.of(ID,"lit"), lit);

		register(BSGItems.TOBACCO_LEAF, Identifier.of(ID, "dryness"), dryness);
		register(BSGItems.CANNABIS_LEAF, Identifier.of(ID, "dryness"), dryness);




	}




}
