package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.MUSHROOM_MUTATION_BLOCK).add(Blocks.MOSS_BLOCK.asItem())
                .add(Blocks.MUD.asItem());

        getOrCreateTagBuilder(ModTags.Items.MUSHROOM_GROW_BLOCK).add(Blocks.GRASS_BLOCK.asItem())
                .add(Blocks.DIRT.asItem())
                .add(Blocks.PODZOL.asItem())
                .add(Blocks.COARSE_DIRT.asItem())
                .add(Blocks.ROOTED_DIRT.asItem())
                .add(Blocks.MUD.asItem())
                .add(Blocks.MOSS_BLOCK.asItem())
                .add(Blocks.MYCELIUM.asItem());

        getOrCreateTagBuilder(ModTags.Items.MUSHROOM_STABLE_BLOCK).add(Blocks.MYCELIUM.asItem())
                .add(Blocks.PODZOL.asItem());


        for (Mushroom mushroom : Mushrooms.ALL) {
            getOrCreateTagBuilder(ModTags.Items.MUSHROOM).add(mushroom.blockItem());
        }
    }
}
