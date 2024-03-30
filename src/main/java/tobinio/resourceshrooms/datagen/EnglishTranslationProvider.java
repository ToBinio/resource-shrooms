package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;

public class EnglishTranslationProvider extends FabricLanguageProvider {
    protected EnglishTranslationProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.STONE_MUSHROOM, "Stone Mushroom");
        translationBuilder.add(ModItems.STONE_MUSHROOM_SPORES, "Stone Mushroom Spores");
        translationBuilder.add(ModItems.STONE_MUSHROOM_HEAD, "Stone Mushroom Head");

        translationBuilder.add(ModBlocks.COAL_MUSHROOM, "Coal Mushroom");
        translationBuilder.add(ModItems.COAL_MUSHROOM_SPORES, "Coal Mushroom Spores");
        translationBuilder.add(ModItems.COAL_MUSHROOM_HEAD, "Coal Mushroom Head");

        translationBuilder.add(ModItemGroups.ITEM_GROUP_KEY, "Resource Mushroom");
    }
}
