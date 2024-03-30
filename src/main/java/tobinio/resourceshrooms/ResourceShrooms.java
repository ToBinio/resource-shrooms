package tobinio.resourceshrooms;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushrooms;
import tobinio.resourceshrooms.mutations.Mutations;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceShrooms implements ModInitializer {

    public static String MOD_ID = "resourceshrooms";

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModTags.initialize();
        ModItemGroups.initialize();

        Mushrooms.initialize();
        Mutations.initialize();
    }
}
