package io.github.maloryware.backstreet_gardener.datagen;

import io.github.maloryware.backstreet_gardener.item.BSGItems;
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
			assert livingEntity != null;
			return livingEntity.isUsingItem()
				&& livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
		};

		register(BSGItems.CIGARETTE, Identifier.of(ID,"moking"), moking);



	}




}
