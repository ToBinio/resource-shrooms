package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.Optional;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            this.registerMushroom(blockStateModelGenerator, mushroom.block());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            itemModelGenerator.register(mushroom.spores(), Models.GENERATED);
            itemModelGenerator.register(mushroom.head(), Models.GENERATED);
            itemModelGenerator.register(mushroom.blockItem(), Models.GENERATED);
        }
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
