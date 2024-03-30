package tobinio.resourceshrooms;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceShrooms implements ModInitializer {

    public static String MOD_ID = "resourceshrooms";

    public static Map<Block, List<Block>> mutations;

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModTags.initialize();
        ModItemGroups.initialize();

        mutations = new HashMap<>();

        mutations.put(ModBlocks.STONE_MUSHROOM, List.of(ModBlocks.COAL_MUSHROOM));
    }
}
