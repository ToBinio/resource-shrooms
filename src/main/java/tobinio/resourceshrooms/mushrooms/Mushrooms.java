package tobinio.resourceshrooms.mushrooms;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.items.MushroomItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Mushrooms {
    public static final List<Mushroom> ALL = new ArrayList<>();

    public static final Mushroom GRAVEL_MUSHROOM = register("Gravel", 0);
    public static final Mushroom DIRT_MUSHROOM = register("Dirt", 0);
    public static final Mushroom STONE_MUSHROOM = register("Stone", 0);

    public static final Mushroom COAL_MUSHROOM = register("Coal", 1);
    public static final Mushroom MOSS_MUSHROOM = register("Moss", 1);
    public static final Mushroom SAND_MUSHROOM = register("Sand", 1);
    public static final Mushroom CALCITE_MUSHROOM = register("Calcite", 1);

    public static final Mushroom IRON_MUSHROOM = register("Iron", 2);
    public static final Mushroom COPPER_MUSHROOM = register("Copper", 2);
    public static final Mushroom LAPIS_MUSHROOM = register("Lapis", 2);

    public static final Mushroom MAGMA_MUSHROOM = register("Magma", 3);
    public static final Mushroom NETHERRACK_MUSHROOM = register("Netherrack", 3);
    public static final Mushroom AMETHYST_MUSHROOM = register("Amethyst", 3);
    public static final Mushroom QUARTZ_MUSHROOM = register("Quartz", 3);
    public static final Mushroom REDSTONE_MUSHROOM = register("Redstone", 3);

    public static final Mushroom GOLD_MUSHROOM = register("Gold", 4);
    public static final Mushroom DIAMOND_MUSHROOM = register("Diamond", 4);
    public static final Mushroom EMERALD_MUSHROOM = register("Emerald", 4);

    private static Mushroom register(String displayName, int level) {
        return register(ResourceShrooms.MOD_ID, displayName, level);
    }


    /**
     * Registers a block with the id "&lt;type&gt;_mushroom"
     * <br>
     * <br>
     * and 3 items:
     * <ul>
     *     <li> "&lt;type&gt;_mushroom_spores" </li>
     *     <li> "&lt;type&gt;_mushroom_head" </li>
     *     <li> "&lt;type&gt;_mushroom" </li>
     * </ul>
     */
    public static Mushroom register(String nameSpace, String type, int tier) {
        var name = type.toLowerCase();

        MushroomBlock block = ModBlocks.registerMushroom("%s_mushroom".formatted(name));

        Item spores = ModItems.register(new MushroomItem(block, tier, new Item.Settings()), Identifier.of(nameSpace, "%s_mushroom_spores".formatted(name)));
        Item head = ModItems.register(new Item(new Item.Settings()), Identifier.of(nameSpace, "%s_mushroom_head".formatted(name)));
        Item blockItem = ModItems.register(new MushroomItem(block, tier, new Item.Settings()), Identifier.of(nameSpace, "%s_mushroom".formatted(name)));

        Mushroom mushroom = new Mushroom(type, block, spores, head, blockItem, tier);

        ALL.add(mushroom);

        return mushroom;
    }

    public static Optional<Mushroom> getFromString(String name) {
        for (Mushroom mushroom : ALL) {
            if (mushroom.displayName().equalsIgnoreCase(name)) {
                return Optional.of(mushroom);
            }
        }

        return Optional.empty();
    }

    public static Optional<Mushroom> getFromBlock(Block block) {
        for (Mushroom mushroom : ALL) {
            if (mushroom.block() == block) {
                return Optional.of(mushroom);
            }
        }

        return Optional.empty();
    }

    public static void initialize() {
    }

    public static void initializeClient() {
        for (Mushroom mushroom : ALL) {
            BlockRenderLayerMap.INSTANCE.putBlock(mushroom.block(), RenderLayer.getCutout());
        }
    }
}
