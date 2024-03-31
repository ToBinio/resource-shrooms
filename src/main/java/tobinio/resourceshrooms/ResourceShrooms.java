package tobinio.resourceshrooms;

import io.netty.util.Attribute;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.block.Block;
import net.minecraft.resource.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.items.ModItemGroups;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushrooms;
import tobinio.resourceshrooms.mutations.Mutations;
import tobinio.resourceshrooms.mutations.MutationsResourceLoader;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceShrooms implements ModInitializer {

    public static final String MOD_ID = "resourceshrooms";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new MutationsResourceLoader());

        ModItems.initialize();
        ModBlocks.initialize();
        ModTags.initialize();
        ModItemGroups.initialize();

        Mushrooms.initialize();
        Mutations.initialize();
    }
}
