package tobinio.resourceshrooms;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.TextWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.List;

public class MutationEmiRecipe implements EmiRecipe {
    private final List<EmiIngredient> requirements;
    private final float chance;
    private final Identifier id;

    private final EmiStack output;

    public MutationEmiRecipe(List<EmiStack> requirements, float chance, Mushroom output, Identifier id) {
        this.chance = chance;
        this.id = id;

        this.output = EmiStack.of(output.blockItem());
        this.requirements = requirements.stream()
                .map(block -> EmiIngredient.of(List.of(block)))
                .toList();
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return ModEmiPlugin.MUTATION_CATEGORY;
    }

    @Override
    public @Nullable Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return requirements;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(output);
    }

    @Override
    public int getDisplayWidth() {
        return 108;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }

    @Override
    public boolean supportsRecipeTree() {
        return false;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {

        for (int i = 0; i < requirements.size(); i++) {
            widgets.addSlot(requirements.get(i), i * 18, 16);
        }

        var startX = requirements.size() * 18;
        var middle = (startX + 90) / 2;

        widgets.addTexture(EmiTexture.EMPTY_ARROW, middle - EmiTexture.EMPTY_ARROW.width / 2, 17);
        widgets.addText(Text.literal("%s%%".formatted(chance)), middle, 5, -1, true)
                .horizontalAlign(TextWidget.Alignment.CENTER);

        widgets.addSlot(output, 90, 16).recipeContext(this);
    }
}
