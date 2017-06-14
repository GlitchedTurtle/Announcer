package glitchedturtle.announce;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import glitchedturtle.announce.command.AnnounceCommand;
import glitchedturtle.announce.thread.AnnouncerRunnable;
import lombok.Getter;

public class Announce extends JavaPlugin {

	@Getter
	private AnnouncerRunnable announcer;
	@Getter
	private AnnounceConfig configuration;
	
	@Override
	public void onEnable() {
		File config = new File(this.getDataFolder().getAbsolutePath() + File.separator + "config.yml");
		if(!config.exists()) {
			
			this.saveResource("config.yml", false);
			
		}
		
		this.getCommand("announcer").setExecutor(new AnnounceCommand(this));
		
		this.reloadConfiguration();
		
		this.announcer = new AnnouncerRunnable(this);
		
		this.announcer.runTaskTimer(this, configuration.getAnnounceDelay() * 20 , configuration.getAnnounceDelay() * 20);
		
	}

	public void reloadConfiguration() {
		
		this.reloadConfig();
		this.configuration = new AnnounceConfig(this);
		
	}
	
}
