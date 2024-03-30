package tobinio.resourceshrooms.client;

import net.fabricmc.api.ClientModInitializer;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

public class ResourceShroomsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Mushrooms.initializeClient();
    }
}
