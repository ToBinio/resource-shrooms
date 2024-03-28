package tobinio.resourceshrooms.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;

public class ModBlocks {

    public static final Block STONE_MUSHROOM = register(new MushroomBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.CROP)
            .noCollision()
            .breakInstantly()
            .luminance(state -> 1)
            .postProcess(Blocks::always)
            .nonOpaque()
            .pistonBehavior(PistonBehavior.DESTROY)), "stone_mushroom", true);

    public static <T extends Block> T register(T block, String name, boolean shouldRegisterItem) {
        Identifier id = new Identifier(ResourceShrooms.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }


    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> itemGroup.add(STONE_MUSHROOM));
    }

    public static void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(STONE_MUSHROOM, RenderLayer.getCutout());
    }
}
