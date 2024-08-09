package tobinio.resourceshrooms.mushrooms;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public record Mushroom(String displayName, Block block, Item spores, Item head, Item blockItem, int tier) {
}
