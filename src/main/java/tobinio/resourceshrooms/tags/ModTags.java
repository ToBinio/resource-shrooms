package tobinio.resourceshrooms.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> MUSHROOM_GROW_BLOCK = TagKey.of(RegistryKeys.ITEM, id("mushroom_grow_block"));

        public static final TagKey<Item> MUSHROOM_MUTATION_BLOCK = TagKey.of(RegistryKeys.ITEM, id("mushroom_mutation_block"));

        public static final TagKey<Item> MUSHROOM_STABLE_BLOCK = TagKey.of(RegistryKeys.ITEM, id("mushroom_stable_block"));

        public static final TagKey<Item> MUSHROOM = TagKey.of(RegistryKeys.ITEM, id("mushroom"));
    }

    public static class Blocks {
        public static final TagKey<Block> MUSHROOM_GROW_BLOCK = TagKey.of(RegistryKeys.BLOCK, id("mushroom_grow_block"));

        public static final TagKey<Block> MUSHROOM_MUTATION_BLOCK = TagKey.of(RegistryKeys.BLOCK, id("mushroom_mutation_block"));

        public static final TagKey<Block> MUSHROOM_STABLE_BLOCK = TagKey.of(RegistryKeys.BLOCK, id("mushroom_stable_block"));
    }

    public static void initialize() {
    }
}
