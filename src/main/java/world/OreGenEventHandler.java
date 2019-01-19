package world;

import java.util.Random;

import block.RedoBlocks;
import modMain.modMain;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OreGenEventHandler {
	
	private static WorldGenerator worldGenMinalble = new WorldGenMinable(RedoBlocks.blockChromite.getDefaultState(), 16);
	
	public static void init() {
		MinecraftForge.ORE_GEN_BUS.register(OreGenEventHandler.class);
	}
	
	@SubscribeEvent
	public static void onGenerateMinable(OreGenEvent.GenerateMinable event) {
		
		for (int i = 1;i <= 4;i++) {
			int PosX = event.getPos().getX() + event.getRand().nextInt(16);
			int PosY = event.getRand().nextInt(70);
			int PosZ = event.getPos().getZ() + event.getRand().nextInt(16);
			BlockPos blockPos = new BlockPos(PosX, PosY, PosZ);
			worldGenMinalble.generate(event.getWorld(), event.getRand(), blockPos);
//			modMain.instance.getLogger().info(String.format("generates at %d %d %d.", PosX, PosY, PosZ));
		}
		
	}
	
} 
