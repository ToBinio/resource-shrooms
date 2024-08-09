package tobinio.resourceshrooms.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class ModBlocks {

    public static final Block GROUND_TIER1 = register(new GroundBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)), "ground_tier1", true);
    public static final Block GROUND_TIER2 = register(new GroundBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)), "ground_tier2", true);
    public static final Block GROUND_TIER3 = register(new GroundBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)), "ground_tier3", true);
    public static final Block GROUND_TIER4 = register(new GroundBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)), "ground_tier4", true);

    public static <T extends Block> T register(T block, String name, boolean shouldRegisterItem) {
        Identifier id = id(name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static MushroomBlock registerMushroom(String name) {
        return register(new MushroomBlock(AbstractBlock.Settings.create()
                .sounds(BlockSoundGroup.CROP)
                .noCollision()
                .breakInstantly()
                .luminance(state -> 1)
                .postProcess(Blocks::always)
                .nonOpaque()
                .ticksRandomly()
                .offset(AbstractBlock.OffsetType.XZ)
                .pistonBehavior(PistonBehavior.DESTROY)), name, false);
    }


    public static void initialize() {
    }
}
