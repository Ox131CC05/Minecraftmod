package item;

import block.RedoBlocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class RedoItems {
	
	public static Item itemZJKSword = new ItemZJKSword().setUnlocalizedName("zjkSword");
	public static Item itemZJKIngot = new ItemChromeIngot().setUnlocalizedName("zjkIngot");
	public static Item itemZJKwand = new ItemZJKWand().setUnlocalizedName("zjkWand");
	
	public static void init() {
		ForgeRegistries.ITEMS.register(itemZJKSword.setRegistryName("zjk_sword"));
		ForgeRegistries.ITEMS.register(itemZJKIngot.setRegistryName("zjk_ingot"));
		ForgeRegistries.ITEMS.register(itemZJKwand.setRegistryName("zjk_wand"));
		OreDictionary.registerOre("ingotChrome", itemZJKIngot);
	}
	
	@SideOnly(Side.CLIENT)
	public static void clientInit() {
		ModelResourceLocation zjkswordLocation = new ModelResourceLocation(itemZJKSword.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(itemZJKSword, 0, zjkswordLocation);
		
		ModelResourceLocation zjkIngotLocation = new ModelResourceLocation(itemZJKIngot.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(itemZJKIngot, 0, zjkIngotLocation);
		
		ModelResourceLocation zjkWandLocation = new ModelResourceLocation(itemZJKwand.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(itemZJKwand, 0, zjkWandLocation);
	}
	
	public static void addSmelting() { // »€¬Ø≈‰∑Ω
		GameRegistry.addSmelting(RedoBlocks.blockChromite, new ItemStack(itemZJKIngot), 0.5F);
	}
	
}
