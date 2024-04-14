package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
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
        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_MUTATION_BLOCK).add(Blocks.MOSS_BLOCK)
                .add(Blocks.MUD);

        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_GROW_BLOCK).add(Blocks.GRASS_BLOCK)
                .add(Blocks.DIRT)
                .add(Blocks.PODZOL)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.MUD)
                .add(Blocks.MOSS_BLOCK)
                .add(Blocks.MYCELIUM);

        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_STABLE_BLOCK).add(Blocks.MYCELIUM)
                .add(Blocks.PODZOL);
    }
}
