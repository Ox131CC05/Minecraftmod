package creativeTab;

import block.BlockChromite;
import block.RedoBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZJKCreativeTab extends net.minecraft.creativetab.CreativeTabs {

	public ZJKCreativeTab() {
		super("ZJK");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(RedoBlocks.blockChromite);
	}
	
}
