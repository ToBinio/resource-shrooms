package tobinio.resourceshrooms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

/**
 * Created: 17.04.24
 *
 * @author Tobias Frischmann
 */
public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        amethystRecipe(exporter);
        calciteRecipe(exporter);
        coalRecipe(exporter);
        copperRecipe(exporter);
        diamondRecipe(exporter);
        emeraldRecipe(exporter);
        goldRecipe(exporter);
        gravelRecipe(exporter);
        ironRecipe(exporter);
        lapisRecipe(exporter);
        magmaRecipe(exporter);
    }

    private static void amethystRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.AMETHYST_SHARD)
                .pattern(" mm")
                .pattern("m m")
                .pattern("mm ")
                .input('m', Mushrooms.AMETHYST_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.AMETHYST_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.AMETHYST_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void calciteRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CALCITE, 2)
                .pattern("mmm")
                .pattern("msm")
                .pattern("mmm")
                .input('s', Items.STONE)
                .input('m', Mushrooms.CALCITE_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.CALCITE_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.CALCITE_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void coalRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COAL)
                .pattern("mm")
                .pattern("mm")
                .input('m', Mushrooms.COAL_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.COAL_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.COAL_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void copperRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RAW_COPPER)
                .pattern(" m ")
                .pattern("mim")
                .pattern(" m ")
                .input('i', Items.RAW_IRON)
                .input('m', Mushrooms.COPPER_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.COPPER_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.COPPER_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void diamondRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND)
                .pattern("mmm")
                .pattern("mmm")
                .pattern("mmm")
                .input('m', Mushrooms.DIAMOND_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.DIAMOND_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.DIAMOND_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void emeraldRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.EMERALD)
                .pattern("mmm")
                .pattern("mdm")
                .pattern("mmm")
                .input('d', Items.DIAMOND)
                .input('m', Mushrooms.EMERALD_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.EMERALD_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.EMERALD_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void goldRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RAW_GOLD)
                .pattern("mmm")
                .pattern("mim")
                .pattern("mmm")
                .input('i', Items.RAW_IRON)
                .input('m', Mushrooms.GOLD_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.GOLD_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.GOLD_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void gravelRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GRAVEL)
                .pattern("ms")
                .pattern("sm")
                .input('s', Items.COBBLESTONE)
                .input('m', Mushrooms.GRAVEL_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.GRAVEL_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.GRAVEL_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void ironRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RAW_IRON)
                .pattern(" m ")
                .pattern("mmm")
                .pattern(" m ")
                .input('m', Mushrooms.IRON_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.IRON_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.IRON_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void lapisRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LAPIS_LAZULI)
                .pattern(" mm")
                .pattern("mbm")
                .pattern("mm ")
                .input('b', Items.BONE_MEAL)
                .input('m', Mushrooms.LAPIS_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.LAPIS_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.LAPIS_MUSHROOM.head()))
                .offerTo(exporter);
    }

    private static void magmaRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGMA_BLOCK)
                .pattern(" m ")
                .pattern("mnm")
                .pattern(" m ")
                .input('n', Items.NETHERRACK)
                .input('m', Mushrooms.MAGMA_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.MAGMA_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.MAGMA_MUSHROOM.head()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LAVA_BUCKET)
                .pattern("mmm")
                .pattern("mbm")
                .pattern("mmm")
                .input('b', Items.BUCKET)
                .input('m', Mushrooms.MAGMA_MUSHROOM.head())
                .criterion(FabricRecipeProvider.hasItem(Mushrooms.MAGMA_MUSHROOM.head()), FabricRecipeProvider.conditionsFromItem(Mushrooms.MAGMA_MUSHROOM.head()))
                .offerTo(exporter);
    }
}
