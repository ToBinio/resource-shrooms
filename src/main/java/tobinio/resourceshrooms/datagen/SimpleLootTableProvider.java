package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.blocks.MushroomBlock;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class SimpleLootTableProvider extends SimpleFabricLootTableProvider {

    protected SimpleLootTableProvider(FabricDataOutput dataOutput,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup, LootContextTypes.GENERIC);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        for (Mushroom mushroom : Mushrooms.ALL) {

            LootPool lootPool = LootPool.builder()
                    .with(ItemEntry.builder(mushroom.spores())
                            .conditionally(BlockStatePropertyLootCondition.builder(mushroom.block())
                                    .properties(StatePredicate.Builder.create().exactMatch(MushroomBlock.AGE, 2)))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.f, 4.f))))
                    .build();

            lootTableBiConsumer.accept(RegistryKey.of(RegistryKeys.LOOT_TABLE, id(mushroom.displayName()
                    .toLowerCase())), LootTable.builder().pool(lootPool));
        }
    }
}
