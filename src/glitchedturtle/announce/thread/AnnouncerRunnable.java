package glitchedturtle.announce.thread;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import glitchedturtle.announce.Announce;
import glitchedturtle.announce.AnnounceConfig;
import glitchedturtle.announce.util.FireworkUtils;

public class AnnouncerRunnable extends BukkitRunnable {

	private Announce mainInstance;	
	
	public AnnouncerRunnable(Announce mainInstance) {
		
		this.mainInstance = mainInstance;
		
	}

	@Override
	public void run() {

		AnnounceConfig configuration = mainInstance.getConfiguration();
		
		String broadcastMessage = configuration.getAnnounceMessage();
		String toBroadcast = configuration.getAnnouncements().get(0);

		configuration.getAnnouncements().remove(0);
		configuration.getAnnouncements().add(toBroadcast);
		
		broadcastMessage = broadcastMessage.replaceAll("%message%", toBroadcast);
		
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', broadcastMessage));
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			
			FireworkUtils.spawnRandomFirework(p.getLocation());
		
		}
		
	}
	
}
