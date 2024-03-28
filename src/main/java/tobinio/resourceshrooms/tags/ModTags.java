package tobinio.resourceshrooms.tags;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;

public class ModTags {
    public static final TagKey<Block> RESOURCE_MUSHROOM_GROW_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ResourceShrooms.MOD_ID, "resource_mushroom_grow_block"));

    public static void initialize() {
    }
}
