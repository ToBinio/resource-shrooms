package tobinio.resourceshrooms;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;
import tobinio.resourceshrooms.mutations.Mutation;
import tobinio.resourceshrooms.mutations.Mutations;
import tobinio.resourceshrooms.tags.ModTags;
import dev.emi.emi.api.recipe.EmiIngredientRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModEmiPlugin implements EmiPlugin {

    public static final EmiRecipeCategory MUTATION_CATEGORY = new EmiRecipeCategory(id("mutations"), EmiStack.of(Mushrooms.COAL_MUSHROOM.blockItem()), EmiStack.of(Mushrooms.COAL_MUSHROOM.blockItem()));

    @Override
    public void register(EmiRegistry registry) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            registry.addEmiStack(EmiStack.of(mushroom.blockItem()));
        }

        registry.addCategory(MUTATION_CATEGORY);

        var count = 0;

        for (Mutation mutation : Mutations.mutations) {

            count++;

            List<EmiIngredient> allRequirements = new ArrayList<>();

            for (Block block : mutation.blockRequirements()) {
                Optional<Mushroom> mushroom = Mushrooms.getFromBlock(block);

                if (mushroom.isPresent()) {
                    allRequirements.add(EmiStack.of(mushroom.get().blockItem()));
                } else if (block == Blocks.LAVA) {
                    allRequirements.add(EmiStack.of(Fluids.LAVA));
                } else if (block == Blocks.WATER) {
                    allRequirements.add(EmiStack.of(Fluids.WATER));
                } else {
                    allRequirements.add(EmiStack.of(block.asItem()));
                }
            }

            for (TagKey<Block> tagRequirement : mutation.tagRequirements()) {
                allRequirements.add(EmiIngredient.of(tagRequirement));
            }

            registry.addRecipe(new MutationEmiRecipe(allRequirements, mutation.chance(), mutation.result(), id("mutation_%d".formatted(count))));
        }

    }
}
