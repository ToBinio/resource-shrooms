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
        public static final TagKey<Item> MUSHROOM = TagKey.of(RegistryKeys.ITEM, id("mushroom"));
        public static final TagKey<Item> MUSHROOM_HEAD = TagKey.of(RegistryKeys.ITEM, id("mushroom_head"));
        public static final TagKey<Item> MUSHROOM_SPORE = TagKey.of(RegistryKeys.ITEM, id("mushroom_spore"));
    }

    public static class Blocks {
        public static final TagKey<Block> GROUND_TIER0 = TagKey.of(RegistryKeys.BLOCK, id("ground_tier0"));
        public static final TagKey<Block> GROUND_TIER1 = TagKey.of(RegistryKeys.BLOCK, id("ground_tier1"));
        public static final TagKey<Block> GROUND_TIER2 = TagKey.of(RegistryKeys.BLOCK, id("ground_tier2"));
        public static final TagKey<Block> GROUND_TIER3 = TagKey.of(RegistryKeys.BLOCK, id("ground_tier3"));
        public static final TagKey<Block> GROUND_TIER4 = TagKey.of(RegistryKeys.BLOCK, id("ground_tier4"));
    }

    public static void initialize() {
    }
}
