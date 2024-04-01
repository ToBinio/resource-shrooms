package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class TagProvider extends FabricTagProvider.BlockTagProvider {
    public TagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //todo more blocks
        getOrCreateTagBuilder(ModTags.MUSHROOM_GROW_BLOCK).add(Blocks.GRASS_BLOCK)
                .add(Blocks.DIRT)
                .add(Blocks.MOSS_BLOCK)
                .add(Blocks.MYCELIUM);
        getOrCreateTagBuilder(ModTags.MUSHROOM_MUTATION_BLOCK).add(Blocks.MOSS_BLOCK);
        getOrCreateTagBuilder(ModTags.MUSHROOM_STABLE_BLOCK).add(Blocks.MYCELIUM);
    }
}
