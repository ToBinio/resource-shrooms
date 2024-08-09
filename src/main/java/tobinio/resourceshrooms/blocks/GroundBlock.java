package tobinio.resourceshrooms.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tobinio.resourceshrooms.items.ModItems;
import tobinio.resourceshrooms.tags.ModTags;

/**
 * Created: 08.08.24
 *
 * @author Tobias Frischmann
 */
public class GroundBlock extends Block {
    public static final EnumProperty<GroundState> GROUND_STATE = EnumProperty.of("ground_state", GroundState.class);

    public enum GroundState implements StringIdentifiable {
        NORMAL("normal"), STABLE("stable"), MUTATING("mutating");

        private final String text;

        GroundState(String text) {
            this.text = text;
        }

        @Override
        public String asString() {
            return text;
        }
    }

    public GroundBlock(Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(GROUND_STATE, GroundState.NORMAL));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GROUND_STATE);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
            PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getItem() == ModItems.STABILIZER && state.get(GROUND_STATE) != GroundState.STABLE) {
            world.setBlockState(pos, state.with(GROUND_STATE, GroundState.STABLE));
            stack.decrementUnlessCreative(1, player);
            world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            return ItemActionResult.SUCCESS;
        }

        if (stack.getItem() == ModItems.MUTAGEN && state.get(GROUND_STATE) != GroundState.MUTATING) {
            world.setBlockState(pos, state.with(GROUND_STATE, GroundState.MUTATING));
            stack.decrementUnlessCreative(1, player);
            world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            return ItemActionResult.SUCCESS;
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    public static int getBLockTier(BlockState state) {
        if (state.isIn(ModTags.Blocks.GROUND_TIER4)) {
            return 4;
        }
        if (state.isIn(ModTags.Blocks.GROUND_TIER3)) {
            return 3;
        }
        if (state.isIn(ModTags.Blocks.GROUND_TIER2)) {
            return 2;
        }
        if (state.isIn(ModTags.Blocks.GROUND_TIER1)) {
            return 1;
        }
        if (state.isIn(ModTags.Blocks.GROUND_TIER0)) {
            return 0;
        }

        return -1;
    }

    public static boolean isMutationGround(BlockState state) {
        return state.getOrEmpty(GROUND_STATE).orElse(GroundState.NORMAL) == GroundState.MUTATING;
    }


    public static boolean isStableGround(BlockState state) {
        return state.getOrEmpty(GROUND_STATE).orElse(GroundState.NORMAL) == GroundState.STABLE;
    }
}
