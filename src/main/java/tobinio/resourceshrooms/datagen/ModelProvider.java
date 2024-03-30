package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.registerMushroom(blockStateModelGenerator, Mushrooms.STONE_MUSHROOM.block());
        this.registerMushroom(blockStateModelGenerator, Mushrooms.COAL_MUSHROOM.block());
        this.registerMushroom(blockStateModelGenerator, Mushrooms.IRON_MUSHROOM.block());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Mushrooms.STONE_MUSHROOM.spores(), Models.GENERATED);
        itemModelGenerator.register(Mushrooms.STONE_MUSHROOM.head(), Models.GENERATED);

        itemModelGenerator.register(Mushrooms.COAL_MUSHROOM.spores(), Models.GENERATED);
        itemModelGenerator.register(Mushrooms.COAL_MUSHROOM.head(), Models.GENERATED);

        itemModelGenerator.register(Mushrooms.IRON_MUSHROOM.spores(), Models.GENERATED);
        itemModelGenerator.register(Mushrooms.IRON_MUSHROOM.head(), Models.GENERATED);
    }

    private void registerMushroom(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(MushroomBlock.AGE).register(integer -> {
            Identifier identifier = blockStateModelGenerator.createSubModel(block, "_stage" + integer, Models.CROSS, TextureMap::cross);
            return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
        });

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(blockStateVariantMap));
    }
}
