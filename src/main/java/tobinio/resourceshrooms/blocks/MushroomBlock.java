package tobinio.resourceshrooms.blocks;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import tobinio.resourceshrooms.mutations.Mutation;
import tobinio.resourceshrooms.mutations.Mutations;
import tobinio.resourceshrooms.tags.ModTags;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MushroomBlock extends Block {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    public static final int MAX_AGE = 2;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);

    protected MushroomBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos down = pos.down();
        return world.getBlockState(down).isIn(ModTags.Blocks.MUSHROOM_GROW_BLOCK);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        if (state.get(AGE) < MAX_AGE) {
            world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1));
            return;
        }

        var xOffset = random.nextBetween(-1, 1);
        var yOffset = random.nextBetween(-1, 1);
        var zOffset = random.nextBetween(-1, 1);

        BlockPos goalPosition = pos.add(xOffset, yOffset, zOffset);

        if (canPlaceAt(this.getDefaultState(), world, goalPosition) && world.getBlockState(goalPosition)
                .isOf(Blocks.AIR)) {
            world.setBlockState(goalPosition, getOffSpring(world, goalPosition, random));
        }
    }

    private BlockState getOffSpring(ServerWorld world, BlockPos goalPos, Random random) {

        //stable ground do not mutate
        if (world.getBlockState(goalPos.down()).isIn(ModTags.Blocks.MUSHROOM_STABLE_BLOCK)) {
            return this.getDefaultState();
        }

        Set<Block> neighbors = getNeighbors(world, goalPos);
        List<Mutation> mutations = Mutations.getPossibleMutations(this, neighbors);

        var mutationsGround = world.getBlockState(goalPos.down()).isIn(ModTags.Blocks.MUSHROOM_MUTATION_BLOCK);

        var weight = 0;

        for (Mutation mutation : mutations) {
            weight += mutationsGround ? mutation.chance() * 2 : mutation.chance();
        }

        weight = Math.max(weight, 100);

        var rng = random.nextBetween(1, weight);

        var currentWeight = 0;

        for (Mutation mutation : mutations) {
            currentWeight += mutationsGround ? mutation.chance() * 2 : mutation.chance();

            if (rng <= currentWeight) {
                return mutation.result().block().getDefaultState();
            }
        }

        return this.getDefaultState();
    }

    private Set<Block> getNeighbors(ServerWorld world, BlockPos pos) {

        HashSet<Block> blocks = new HashSet<>();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    blocks.add(world.getBlockState(pos.add(x, y, z)).getBlock());
                }
            }
        }

        return blocks;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
            WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
