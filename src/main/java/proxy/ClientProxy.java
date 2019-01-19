package proxy;

import block.RedoBlocks;
import entity.RedoEntity;
import item.RedoItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RedoItems.clientInit();
		RedoBlocks.clientInit();
		RedoEntity.registerRenders();
	}
	
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
} // ¿Í»§¶Ë (models)
