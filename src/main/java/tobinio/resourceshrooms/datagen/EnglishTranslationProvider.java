package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

public class EnglishTranslationProvider extends FabricLanguageProvider {
    protected EnglishTranslationProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            translateMushroom(translationBuilder, mushroom);
        }

        translationBuilder.add(ModItemGroups.ITEM_GROUP_KEY, "Resource Mushroom");
        translationBuilder.add("emi.category.%s.mutations".formatted(ResourceShrooms.MOD_ID), "Mushroom Mutations");
        translationBuilder.add("tag.item.%s.mushroom_grow_block".formatted(ResourceShrooms.MOD_ID), "Mushroom Grow Blocks");
        translationBuilder.add("tag.item.%s.mushroom_stable_block".formatted(ResourceShrooms.MOD_ID), "Mushroom Stable Grow Blocks");
        translationBuilder.add("tag.item.%s.mushroom_mutation_block".formatted(ResourceShrooms.MOD_ID), "Mushroom Mutation Grow Blocks");
    }

    public void translateMushroom(TranslationBuilder translationBuilder, Mushroom mushroom) {
        translationBuilder.add(mushroom.block(), "%s Mushroom".formatted(mushroom.displayName()));
        translationBuilder.add(mushroom.blockItem(), "%s Mushroom".formatted(mushroom.displayName()));
        translationBuilder.add(mushroom.spores(), "%s Mushroom Spores".formatted(mushroom.displayName()));
        translationBuilder.add(mushroom.head(), "%s Mushroom Head".formatted(mushroom.displayName()));
    }
}
