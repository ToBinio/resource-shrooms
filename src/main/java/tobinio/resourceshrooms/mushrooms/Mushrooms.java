package tobinio.resourceshrooms.mushrooms;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;

import java.util.ArrayList;
import java.util.List;

public class Mushrooms {
    public static final List<Mushroom> ALL = new ArrayList<>();

    public static final Mushroom STONE_MUSHROOM = register("Stone");
    public static final Mushroom COAL_MUSHROOM = register("Coal");
    public static final Mushroom IRON_MUSHROOM = register("Iron");


    public static Mushroom register(String displayName) {

        var name = displayName.toLowerCase();

        MushroomBlock block = ModBlocks.registerMushroom("%s_mushroom".formatted(name));

        Item spores = ModItems.register(new AliasedBlockItem(block, new FabricItemSettings()), "%s_mushroom_spores".formatted(name));
        Item head = ModItems.register(new Item(new FabricItemSettings()), "%s_mushroom_head".formatted(name));

        Mushroom mushroom = new Mushroom(displayName, block, spores, head);

        ALL.add(mushroom);

        return mushroom;
    }

    public static void initialize() {
    }

    public static void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(STONE_MUSHROOM.block(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(COAL_MUSHROOM.block(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IRON_MUSHROOM.block(), RenderLayer.getCutout());
    }
}
