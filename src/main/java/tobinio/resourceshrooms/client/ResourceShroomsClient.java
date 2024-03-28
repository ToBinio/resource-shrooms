package tobinio.resourceshrooms.client;

import net.fabricmc.api.ClientModInitializer;
import tobinio.resourceshrooms.blocks.ModBlocks;

public class ResourceShroomsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlocks.initializeClient();
    }
}
