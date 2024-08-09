package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.blocks.GroundBlock;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            this.registerMushroom(blockStateModelGenerator, mushroom.block());
        }

        registerGround(blockStateModelGenerator, ModBlocks.GROUND_TIER1);
        registerGround(blockStateModelGenerator, ModBlocks.GROUND_TIER2);
        registerGround(blockStateModelGenerator, ModBlocks.GROUND_TIER3);
        registerGround(blockStateModelGenerator, ModBlocks.GROUND_TIER4);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            itemModelGenerator.register(mushroom.spores(), Models.GENERATED);
            itemModelGenerator.register(mushroom.head(), Models.GENERATED);
            itemModelGenerator.register(mushroom.blockItem(), Models.GENERATED);
        }

        itemModelGenerator.register(ModItems.STABILIZER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUTAGEN, Models.GENERATED);
    }

    private void registerMushroom(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(MushroomBlock.AGE).register(integer -> {
            Identifier identifier = blockStateModelGenerator.createSubModel(block, "_stage" + integer, Models.CROSS, TextureMap::cross);
            return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
        });

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(blockStateVariantMap));
    }

    private void registerGround(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(GroundBlock.GROUND_STATE)
                .register(state -> {
                    var suffix = "";

                    if (state != GroundBlock.GroundState.NORMAL) {
                        suffix = "_" + state.asString();
                    }

                    Identifier identifier = blockStateModelGenerator.createSubModel(block, suffix, Models.CUBE_TOP, id -> new TextureMap().put(TextureKey.ALL, Identifier.ofVanilla("block/dirt"))
                            .put(TextureKey.TOP, id(id.getPath())));
                    return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
                });

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(blockStateVariantMap));
    }
}
