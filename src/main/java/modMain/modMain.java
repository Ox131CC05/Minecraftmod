package modMain;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import proxy.CommonProxy;

@Mod(modid = modMain.MODID, name = modMain.NAME, version = modMain.VERSION)
public class modMain {
	public static final String MODID = "zjk";
	public static final String NAME = "ZJK";
	public static final String VERSION = "1.0.0";
	
	@SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(MODID)
	public static modMain instance;
	
	private Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	} // 注册物品、方块、模型等
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	} // 注册合成表、熔炉配方
	
	public Logger getLogger() {
		return logger;
	}
}
