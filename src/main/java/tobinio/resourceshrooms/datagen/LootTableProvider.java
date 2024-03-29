package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import tobinio.resourceshrooms.blocks.ModBlocks;

public class LootTableProvider extends FabricBlockLootTableProvider {
    protected LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STONE_MUSHROOM, drops(ModBlocks.STONE_MUSHROOM));
        addDrop(ModBlocks.COAL_MUSHROOM, drops(ModBlocks.COAL_MUSHROOM));
    }
}
