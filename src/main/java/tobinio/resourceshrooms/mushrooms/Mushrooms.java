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

    public static final Mushroom STONE_MUSHROOM = register("stone");
    public static final Mushroom COAL_MUSHROOM = register("coal");
    public static final Mushroom IRON_MUSHROOM = register("iron");


    public static Mushroom register(String name) {
        MushroomBlock block = ModBlocks.registerMushroom("%s_mushroom".formatted(name));

        Item spores = ModItems.register(new AliasedBlockItem(block, new FabricItemSettings()), "%s_mushroom_spores".formatted(name));
        Item head = ModItems.register(new Item(new FabricItemSettings()), "%s_mushroom_head".formatted(name));

        return new Mushroom(block, spores, head);
    }

    public static void initialize() {
    }

    public static void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(STONE_MUSHROOM.block(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(COAL_MUSHROOM.block(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IRON_MUSHROOM.block(), RenderLayer.getCutout());
    }
}
