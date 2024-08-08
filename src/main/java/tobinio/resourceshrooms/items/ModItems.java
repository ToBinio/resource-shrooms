package tobinio.resourceshrooms.items;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModItems {

    public static final Item MUTAGEN = register(new Item(new Item.Settings()), id("mutagen"));
    public static final Item STABILIZER = register(new Item(new Item.Settings()), id("stabilizer"));

    public static <T extends Item> T register(T item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void initialize() {
    }
}
