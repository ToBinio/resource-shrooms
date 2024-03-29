package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import tobinio.resourceshrooms.blocks.ModBlocks;

public class EnglishTranslationProvider extends FabricLanguageProvider {
    protected EnglishTranslationProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.STONE_MUSHROOM, "Stone Mushroom");
        translationBuilder.add(ModBlocks.COAL_MUSHROOM, "Coal Mushroom");
    }
}
