package creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class RedoCreateiveTabs {

	public static CreativeTabs zjkTabs;
	
	public RedoCreateiveTabs(FMLPreInitializationEvent event) {
		zjkTabs = new ZJKCreativeTab();
	}
	
}
