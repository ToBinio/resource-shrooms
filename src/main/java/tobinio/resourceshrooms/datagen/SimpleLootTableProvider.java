package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.Collections;
import java.util.function.BiConsumer;

public class SimpleLootTableProvider extends SimpleFabricLootTableProvider {

    protected SimpleLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput, LootContextTypes.GENERIC);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        for (Mushroom mushroom : Mushrooms.ALL) {

            LootPool lootPool = LootPool.builder()
                    .with(ItemEntry.builder(mushroom.spores())
                            .conditionally(BlockStatePropertyLootCondition.builder(mushroom.block())
                                    .properties(StatePredicate.Builder.create().exactMatch(MushroomBlock.AGE, 2)))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.f, 4.f))))
                    .build();

            exporter.accept(new Identifier(ResourceShrooms.MOD_ID, mushroom.displayName()
                    .toLowerCase()), LootTable.builder().pool(lootPool));
        }
    }
}
