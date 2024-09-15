package tobinio.resourceshrooms.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.concurrent.CompletableFuture;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER0).forceAddTag(TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("dirt")));
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER1).add(ModBlocks.GROUND_TIER1);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER2).add(ModBlocks.GROUND_TIER2);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER3).add(ModBlocks.GROUND_TIER3);
        getOrCreateTagBuilder(ModTags.Blocks.GROUND_TIER4).add(ModBlocks.GROUND_TIER4);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("mineable/shovel")))
                .add(ModBlocks.GROUND_TIER1)
                .add(ModBlocks.GROUND_TIER2)
                .add(ModBlocks.GROUND_TIER3)
                .add(ModBlocks.GROUND_TIER4);
    }
}
