package tobinio.resourceshrooms.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.concurrent.CompletableFuture;

public class EnglishTranslationProvider extends FabricLanguageProvider {
    public EnglishTranslationProvider(FabricDataOutput dataOutput,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, "en_us", registriesFuture);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup,
            TranslationBuilder translationBuilder) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            translateMushroom(translationBuilder, mushroom);
        }

        translationBuilder.add(ModItemGroups.ITEM_GROUP_KEY, "Resource Mushroom");
        translationBuilder.add("emi.category.%s.mutations".formatted(ResourceShrooms.MOD_ID), "Mushroom Mutations");

        translationBuilder.add("tag.item.%s.mushroom".formatted(ResourceShrooms.MOD_ID), "Resourceshrooms");
        translationBuilder.add("tag.item.%s.mushroom_head".formatted(ResourceShrooms.MOD_ID), "Mushroom Heads");
        translationBuilder.add("tag.item.%s.mushroom_spore".formatted(ResourceShrooms.MOD_ID), "Mushroom Spores");

        translationBuilder.add(ModBlocks.GROUND_TIER1, "Ground Tier1");
        translationBuilder.add(ModBlocks.GROUND_TIER2, "Ground Tier2");
        translationBuilder.add(ModBlocks.GROUND_TIER3, "Ground Tier3");
        translationBuilder.add(ModBlocks.GROUND_TIER4, "Ground Tier4");

        translationBuilder.add(ModItems.MUTAGEN, "Mutagen");
        translationBuilder.add(ModItems.STABILIZER, "Stabilizer");
    }

    public void translateMushroom(TranslationBuilder translationBuilder, Mushroom mushroom) {
        translationBuilder.add(mushroom.block(), "%s Mushroom".formatted(mushroom.displayName()));
        translationBuilder.add(mushroom.blockItem(), "%s Mushroom".formatted(mushroom.displayName()));
        translationBuilder.add(mushroom.spores(), "%s Mushroom Spores".formatted(mushroom.displayName()));
        translationBuilder.add(mushroom.head(), "%s Mushroom Head".formatted(mushroom.displayName()));
    }
}
