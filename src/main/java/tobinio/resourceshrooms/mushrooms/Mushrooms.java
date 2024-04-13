package tobinio.resourceshrooms.mushrooms;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Mushrooms {
    public static final List<Mushroom> ALL = new ArrayList<>();

    public static final Mushroom STONE_MUSHROOM = register("Stone");
    public static final Mushroom COAL_MUSHROOM = register("Coal");
    public static final Mushroom IRON_MUSHROOM = register("Iron");
    public static final Mushroom DIRT_MUSHROOM = register("Dirt");
    public static final Mushroom GRAVEL_MUSHROOM = register("Gravel");
    public static final Mushroom MAGMA_MUSHROOM = register("Magma");
    public static final Mushroom NETHERRACK_MUSHROOM = register("Netherrack");
    public static final Mushroom MOSS_MUSHROOM = register("Moss");
    public static final Mushroom COPPER_MUSHROOM = register("Copper");
    public static final Mushroom AMETHYST_MUSHROOM = register("Amethyst");
    public static final Mushroom SAND_MUSHROOM = register("Sand");
    public static final Mushroom QUARTZ_MUSHROOM = register("Quartz");
    public static final Mushroom CALCITE_MUSHROOM = register("Calcite");
    public static final Mushroom GOLD_MUSHROOM = register("Gold");
    public static final Mushroom LAPIS_MUSHROOM = register("Lapis");
    public static final Mushroom REDSTONE_MUSHROOM = register("Redstone");
    public static final Mushroom DIAMOND_MUSHROOM = register("Diamond");

    public static Mushroom register(String displayName) {

        var name = displayName.toLowerCase();

        MushroomBlock block = ModBlocks.registerMushroom("%s_mushroom".formatted(name));

        Item spores = ModItems.register(new AliasedBlockItem(block, new FabricItemSettings()), "%s_mushroom_spores".formatted(name));
        Item head = ModItems.register(new Item(new FabricItemSettings()), "%s_mushroom_head".formatted(name));
        Item blockItem = ModItems.register(new Item(new FabricItemSettings()), "%s_mushroom".formatted(name));

        Mushroom mushroom = new Mushroom(displayName, block, spores, head, blockItem);

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
