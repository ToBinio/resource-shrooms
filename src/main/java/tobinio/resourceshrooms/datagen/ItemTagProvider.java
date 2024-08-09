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
        for (Mushroom mushroom : Mushrooms.ALL) {
            getOrCreateTagBuilder(ModTags.Items.MUSHROOM).add(mushroom.blockItem());
            getOrCreateTagBuilder(ModTags.Items.MUSHROOM_HEAD).add(mushroom.head());
            getOrCreateTagBuilder(ModTags.Items.MUSHROOM_SPORE).add(mushroom.spores());
        }
    }
}
