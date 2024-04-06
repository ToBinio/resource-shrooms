package tobinio.resourceshrooms.mutations;

import net.minecraft.block.Block;
import tobinio.resourceshrooms.mushrooms.Mushroom;

import java.util.Collection;
import java.util.List;

public record Mutation(List<Block> requirements, Mushroom result, int chance) {

    public boolean fits(Block origin, Collection<Block> surroundings) {
        if (!requirements.contains(origin)) {
            return false;
        }

        for (Block requirement : requirements) {
            if (!surroundings.contains(requirement)) {
                return false;
            }
        }

        return true;
    }

}
