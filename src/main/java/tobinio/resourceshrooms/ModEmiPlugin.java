package tobinio.resourceshrooms;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
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

public class ModEmiPlugin implements EmiPlugin {

    public static final EmiRecipeCategory MUTATION_CATEGORY = new EmiRecipeCategory(new Identifier(ResourceShrooms.MOD_ID, "mutations"), EmiStack.of(Mushrooms.COAL_MUSHROOM.blockItem()), EmiStack.of(Mushrooms.COAL_MUSHROOM.blockItem()));

    @Override
    public void register(EmiRegistry registry) {
        for (Mushroom mushroom : Mushrooms.ALL) {
            registry.addEmiStack(EmiStack.of(mushroom.blockItem()));
        }

        registry.addCategory(MUTATION_CATEGORY);

        var count = 0;

        for (Mutation mutation : Mutations.mutations) {

            count++;

            List<EmiStack> allRequirements = new ArrayList<>();

            for (Block block : mutation.requirements()) {
                Optional<Mushroom> mushroom = Mushrooms.getFromBlock(block);

                if (mushroom.isPresent()) {
                    allRequirements.add(EmiStack.of(mushroom.get().blockItem()));
                } else if (block == Blocks.LAVA) {
                    allRequirements.add(EmiStack.of(Fluids.LAVA));
                } else {
                    allRequirements.add(EmiStack.of(block.asItem()));
                }
            }

            registry.addRecipe(new MutationEmiRecipe(allRequirements, mutation.chance(), mutation.result(), new Identifier(ResourceShrooms.MOD_ID, "mutation_%d".formatted(count))));
        }

    }
}
