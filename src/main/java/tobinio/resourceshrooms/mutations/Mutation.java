package tobinio.resourceshrooms.mutations;

import net.minecraft.block.Block;
import tobinio.resourceshrooms.mushrooms.Mushroom;

import java.util.Collection;

public record Mutation(Collection<Block> requirements, Mushroom result) {

    public boolean fits(Collection<Block> blocks) {
        for (Block requirement : requirements) {
            if (!blocks.contains(requirement)) {
                return false;
            }
        }
        
        return true;
    }

}
