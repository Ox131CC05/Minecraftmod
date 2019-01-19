package event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RedoEvents {
	
	public static final EventBus EVENT_BUS = new EventBus();
	
	public RedoEvents() {
		MinecraftForge.EVENT_BUS.register(this);
		EVENT_BUS.register(this);
	}
	
	@Cancelable
	public static class PlayerRightClickZJKBlockEvent extends PlayerEvent {
		
		public final BlockPos pos;
		public final World world;
		
		public PlayerRightClickZJKBlockEvent(EntityPlayer player, BlockPos pos, World world) {
			super(player);
			this.pos = pos;
			this.world = world;
		}
		
	}
	
	@SubscribeEvent
	public void onPlayerRightClickZJKBlock(PlayerRightClickZJKBlockEvent event) {
		
		if (!event.world.isRemote) {
			BlockPos pos = event.pos;
			event.world.createExplosion(event.getEntityPlayer(), pos.getX(), pos.getY(), pos.getZ(), 20, true);
		}
		
	}
	
	@Cancelable
	public static class PlayerWalkOnZJKBlockEvent extends PlayerEvent {
		
		public final BlockPos pos;
		public final World world;
		public final EntityPlayer player;
		
		public PlayerWalkOnZJKBlockEvent(EntityPlayer player, BlockPos pos, World world) {
			super(player);
			this.pos = pos;
			this.world = world;
			this.player = player;
		}
		
	}
	
	@SubscribeEvent
	public void onPlayerWalkOnZJKBlock(PlayerWalkOnZJKBlockEvent event) {
		
		if (!event.world.isRemote) {
			EntityPlayer player = event.player;
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2, 2));
		}
		
	}
	
}
