package tobinio.resourceshrooms.mutations;

import net.minecraft.block.Block;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.util.*;

public class Mutations {

    public static Map<Block, List<Mutation>> mutations = new HashMap<>();

    public static void initialize() {
//        addMutation(Mushrooms.STONE_MUSHROOM, new Mutation(List.of(), Mushrooms.COAL_MUSHROOM));
//        addMutation(Mushrooms.STONE_MUSHROOM, new Mutation(List.of(Mushrooms.COAL_MUSHROOM.block()), Mushrooms.IRON_MUSHROOM));
//
//        addMutation(Mushrooms.COAL_MUSHROOM, new Mutation(List.of(Mushrooms.STONE_MUSHROOM.block()), Mushrooms.IRON_MUSHROOM));
    }

    public static void clear() {
        mutations.clear();
    }

    public static void addMutation(Mushroom mushroom, Mutation mutation) {
        var currentMutations = mutations.getOrDefault(mushroom.block(), new ArrayList<>());

        currentMutations.add(mutation);

        mutations.put(mushroom.block(), currentMutations);
    }

    public static List<Mutation> getPossibleMutations(Block origin, Collection<Block> blocks) {
        List<Mutation> mutations = Mutations.mutations.getOrDefault(origin, List.of());

        List<Mutation> possibleMutations = new ArrayList<>();

        for (Mutation mutation : mutations) {
            if (mutation.fits(blocks)) {
                possibleMutations.add(mutation);
            }
        }

        return possibleMutations;
    }
}
