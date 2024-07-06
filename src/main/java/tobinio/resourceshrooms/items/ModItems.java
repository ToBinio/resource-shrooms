package tobinio.resourceshrooms.items;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModItems {

    public static <T extends Item> T register(T item, String ID) {
        Identifier itemID = id(ID);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
    }
}
