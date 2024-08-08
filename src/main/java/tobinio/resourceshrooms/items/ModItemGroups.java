package tobinio.resourceshrooms.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModItemGroups {

    public static final String ITEM_GROUP_KEY = "itemGroup.%s.resourceShrooms".formatted(ResourceShrooms.MOD_ID);
    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, id("item_group"), FabricItemGroup.builder()
            .displayName(Text.translatable(ITEM_GROUP_KEY))
            .icon(() -> new ItemStack(Mushrooms.COAL_MUSHROOM.block()))
            .entries((displayContext, entries) -> {
                for (Mushroom mushroom : Mushrooms.ALL) {
                    entries.add(mushroom.spores());
                }
                for (Mushroom mushroom : Mushrooms.ALL) {
                    entries.add(mushroom.head());
                }

                entries.add(ModBlocks.GROUND_TIER1);
                entries.add(ModBlocks.GROUND_TIER2);
                entries.add(ModBlocks.GROUND_TIER3);
                entries.add(ModBlocks.GROUND_TIER4);

                entries.add(ModItems.MUTAGEN);
                entries.add(ModItems.STABILIZER);
            })
            .build());

    public static void initialize() {
    }
}
 