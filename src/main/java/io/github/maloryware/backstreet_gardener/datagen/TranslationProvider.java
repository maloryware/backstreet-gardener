package io.github.maloryware.backstreet_gardener.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static io.github.maloryware.backstreet_gardener.item.BSGItems.*;

public class TranslationProvider extends FabricLanguageProvider {
	public TranslationProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

		translationBuilder.add(BLUNT, "Blunt");
		translationBuilder.add(JOINT, "Joint");
		translationBuilder.add(CIGARETTE, "Cigarette");
		translationBuilder.add(COKE, "Cocaine");
		translationBuilder.add(OPIUM, "Opium");

		translationBuilder.add(PERUVIAN_COCA_SEED, "Coca Plant Seeds");
		translationBuilder.add(POPPY_SEED, "Opiate Poppy Seeds");
		translationBuilder.add(CANNABIS_SEED, "Cannabis Seeds");
		translationBuilder.add(TOBACCO_SEED, "Tobacco Plant Seeds");

		translationBuilder.add(COCA_LEAF, "Coca Leaf");
		translationBuilder.add(OPIUM_LEAF, "Opium Leaf");
		translationBuilder.add(CANNABIS_LEAF, "Cannabis Leaf");
		translationBuilder.add(TOBACCO_LEAF, "Tobacco Leaf");

		translationBuilder.add("substances","Backstreet Gardener");
		translationBuilder.add("backstreet_gardener","Backstreet Gardener");

	}
}
