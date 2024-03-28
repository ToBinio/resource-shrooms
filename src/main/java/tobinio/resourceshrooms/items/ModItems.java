package tobinio.resourceshrooms.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;

public class ModItems {

    public static <T extends Item> T register(T item, String ID) {
        Identifier itemID = new Identifier(ResourceShrooms.MOD_ID, ID);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {

    }
}
