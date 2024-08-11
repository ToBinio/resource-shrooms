package tobinio.resourceshrooms.mutations;

import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;
import tobinio.resourceshrooms.mushrooms.Mushroom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record Mutation(List<Block> blockRequirements, List<TagKey<Block>> tagRequirements, Mushroom result,
                       int chance) {

    public boolean fits(Block origin, Collection<Block> surroundings) {

        var blocks = new ArrayList<>(surroundings);
        blocks.add(origin);


        for (Block requirement : blockRequirements) {
            if (!blocks.contains(requirement)) {
                return false;
            }
        }

        for (TagKey<Block> requirement : tagRequirements) {
            var contains = false;

            for (Block block : blocks) {
                if (block.getDefaultState().isIn(requirement)) {
                    contains = true;
                }
            }

            if (!contains) {
                return false;
            }
        }

        return true;
    }

}
