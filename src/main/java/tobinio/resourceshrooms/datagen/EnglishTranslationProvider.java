package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

public class EnglishTranslationProvider extends FabricLanguageProvider {
    protected EnglishTranslationProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(Mushrooms.STONE_MUSHROOM.block(), "Stone Mushroom");
        translationBuilder.add(Mushrooms.STONE_MUSHROOM.spores(), "Stone Mushroom Spores");
        translationBuilder.add(Mushrooms.STONE_MUSHROOM.head(), "Stone Mushroom Head");

        translationBuilder.add(Mushrooms.COAL_MUSHROOM.block(), "Coal Mushroom");
        translationBuilder.add(Mushrooms.COAL_MUSHROOM.spores(), "Coal Mushroom Spores");
        translationBuilder.add(Mushrooms.COAL_MUSHROOM.head(), "Coal Mushroom Head");

        translationBuilder.add(ModItemGroups.ITEM_GROUP_KEY, "Resource Mushroom");
    }
}
