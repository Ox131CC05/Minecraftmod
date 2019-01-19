package proxy;

import block.RedoBlocks;
import creativeTab.RedoCreateiveTabs;
import entity.RedoEntity;
import event.RedoEvents;
import item.RedoItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import world.OreGenEventHandler;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		new RedoCreateiveTabs(event);
		RedoBlocks.init();
		RedoItems.init();
		RedoEntity.init();
	}
	
	public void init(FMLInitializationEvent event) {
		RedoItems.addSmelting();
		OreGenEventHandler.init();
		new RedoEvents();
	}
	
} // ·þÎñ¶Ë (Items/Blocks)
