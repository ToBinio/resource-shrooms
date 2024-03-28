package tobinio.resourceshrooms;

import net.fabricmc.api.ModInitializer;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.tags.ModTags;

public class ResourceShrooms implements ModInitializer {

    public static String MOD_ID = "resourceshrooms";

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModTags.initialize();
    }
}
