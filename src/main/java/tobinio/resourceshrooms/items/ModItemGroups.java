package tobinio.resourceshrooms.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.Resource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

public class ModItemGroups {

    public static final String ITEM_GROUP_KEY = "itemGroup.%s.resourceShrooms".formatted(ResourceShrooms.MOD_ID);
    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(ResourceShrooms.MOD_ID, "item_group"), FabricItemGroup.builder()
            .displayName(Text.translatable(ITEM_GROUP_KEY))
            .icon(() -> new ItemStack(Mushrooms.COAL_MUSHROOM.block()))
            .entries((displayContext, entries) -> {
                for (Mushroom mushroom : Mushrooms.ALL) {
                    entries.add(mushroom.spores());
                    entries.add(mushroom.head());
                }
            })
            .build());

    public static void initialize() {
    }
}
