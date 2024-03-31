package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.entry.GroupEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import tobinio.resourceshrooms.blocks.ModBlocks;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.List;
import java.util.Optional;

public class LootTableProvider extends FabricBlockLootTableProvider {
    protected LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (Mushroom mushroom : Mushrooms.ALL) {
            addDrop(mushroom.block(), mushroomLootTable(mushroom));
        }
    }

    private LootTable.Builder mushroomLootTable(Mushroom mushroom) {
        LootPool SporesLootPools = LootPool.builder()
                .with(ItemEntry.builder(mushroom.spores())
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.f, 1.f))))
                .build();

        LootPool HeadLootPools = LootPool.builder()
                .with(ItemEntry.builder(mushroom.head())
                        .conditionally(BlockStatePropertyLootCondition.builder(mushroom.block())
                                .properties(StatePredicate.Builder.create().exactMatch(MushroomBlock.AGE, 2)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))))
                .build();

        return LootTable.builder().pool(SporesLootPools).pool(HeadLootPools);
    }
}
