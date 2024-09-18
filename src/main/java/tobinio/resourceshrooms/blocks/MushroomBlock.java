package tobinio.resourceshrooms.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;
import tobinio.resourceshrooms.mutations.Mutation;
import tobinio.resourceshrooms.mutations.Mutations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MushroomBlock extends CropBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    public static final int MAX_AGE = 2;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);

    protected MushroomBlock(Settings settings) {
        super(settings);
    }

    public Mushroom getMushroom() {
        for (Mushroom mushroom : Mushrooms.ALL) {
            if (mushroom.block() == this) {
                return mushroom;
            }
        }

        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return getMushroom().spores();
    }

    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Mushroom mushroom = getMushroom();
        BlockState blockBeneath = world.getBlockState(pos.down());

        return GroundBlock.getBLockTier(blockBeneath) >= mushroom.tier();
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
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
        if (GroundBlock.isStableGround(world.getBlockState(goalPos.down()))) {
            return this.getDefaultState();
        }

        Set<Block> neighbors = getNeighbors(world, goalPos);
        List<Mutation> mutations = Mutations.getPossibleMutations(this, neighbors);

        var isMutationGround = GroundBlock.isMutationGround(world.getBlockState(goalPos.down()));

        var weight = 0;

        for (Mutation mutation : mutations) {
            weight += isMutationGround ? mutation.chance() * 2 : mutation.chance();
        }

        weight = Math.max(weight, 100);

        var rng = random.nextBetween(1, weight);

        var currentWeight = 0;

        for (Mutation mutation : mutations) {
            currentWeight += isMutationGround ? mutation.chance() * 2 : mutation.chance();

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
