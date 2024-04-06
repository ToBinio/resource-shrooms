package tobinio.resourceshrooms.mutations;

import net.minecraft.block.Block;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.*;

public class Mutations {

    public static List<Mutation> mutations = new ArrayList<>();

    public static void initialize() {
    }

    public static void clear() {
        mutations.clear();
    }

    public static void addMutation(Mutation mutation) {
        mutations.add(mutation);
    }

    public static List<Mutation> getPossibleMutations(Block origin, Collection<Block> surroundings) {
        List<Mutation> possibleMutations = new ArrayList<>();

        for (Mutation mutation : mutations) {
            if (mutation.fits(origin, surroundings)) {
                possibleMutations.add(mutation);
            }
        }

        return possibleMutations;
    }
}
