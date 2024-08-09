package tobinio.resourceshrooms.items;

import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

/**
 * Created: 08.08.24
 *
 * @author Tobias Frischmann
 */
public class MushroomItem extends AliasedBlockItem {

    private final int tier;

    public MushroomItem(Block block, int tier, Settings settings) {
        super(block, settings);
        this.tier = tier;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("Tier %d".formatted(tier)).formatted(Formatting.AQUA));
    }
}
