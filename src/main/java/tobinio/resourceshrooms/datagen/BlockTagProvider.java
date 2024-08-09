package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER0).add(Blocks.DIRT);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER1).add(ModBlocks.GROUND_TIER1);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER2).add(ModBlocks.GROUND_TIER2);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER3).add(ModBlocks.GROUND_TIER3);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER4).add(ModBlocks.GROUND_TIER4);
    }
}
