package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import tobinio.resourceshrooms.datagen.providers.*;

public class ModDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelProvider::new);
        pack.addProvider(EnglishTranslationProvider::new);
        pack.addProvider(BlockTagProvider::new);
        pack.addProvider(ItemTagProvider::new);
        pack.addProvider(BlockLootTableProvider::new);
        pack.addProvider(SimpleLootTableProvider::new);
        pack.addProvider(RecipeProvider::new);
    }
}
