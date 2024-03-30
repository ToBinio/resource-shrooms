package tobinio.resourceshrooms.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;

public class ModItems {

    public static final Item STONE_MUSHROOM_SPORES = register(new AliasedBlockItem(ModBlocks.STONE_MUSHROOM, new FabricItemSettings()), "stone_mushroom_spores");

    public static final Item STONE_MUSHROOM_HEAD = register(new Item(new FabricItemSettings()), "stone_mushroom_head");

    public static final Item COAL_MUSHROOM_SPORES = register(new AliasedBlockItem(ModBlocks.COAL_MUSHROOM, new FabricItemSettings()), "coal_mushroom_spores");

    public static final Item COAL_MUSHROOM_HEAD = register(new Item(new FabricItemSettings()), "coal_mushroom_head");

    public static <T extends Item> T register(T item, String ID) {
        Identifier itemID = new Identifier(ResourceShrooms.MOD_ID, ID);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
    }
}
