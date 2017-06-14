package glitchedturtle.announce;

import java.util.List;

import org.bukkit.configuration.Configuration;

import lombok.Getter;

@Getter
public class AnnounceConfig {

	private long announceDelay;
	private String announceMessage;
	private List<String> announcements;
	
	public AnnounceConfig(Announce announce) {
		
		Configuration config = announce.getConfig();
		
		announceDelay = config.getLong("announce-delay");
		announceMessage = config.getString("announce-message");
		announcements = config.getStringList("announcements");
		
	}
	
}
