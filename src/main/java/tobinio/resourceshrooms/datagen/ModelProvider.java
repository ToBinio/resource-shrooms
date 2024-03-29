package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.registerMushroom(blockStateModelGenerator, ModBlocks.STONE_MUSHROOM);
        this.registerMushroom(blockStateModelGenerator, ModBlocks.COAL_MUSHROOM);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    private void registerMushroom(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(MushroomBlock.AGE).register(integer -> {
            Identifier identifier = blockStateModelGenerator.createSubModel(block, "_stage" + integer, Models.CROSS, TextureMap::cross);
            return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
        });

        blockStateModelGenerator.registerItemModel(block, "_stage" + MushroomBlock.MAX_AGE);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(blockStateVariantMap));
    }
}
