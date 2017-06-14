package glitchedturtle.announce.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import glitchedturtle.announce.Announce;

public class AnnounceCommand implements CommandExecutor {

	private Announce mainInstance;

	public AnnounceCommand(Announce mainInstance) {
	
		this.mainInstance = mainInstance;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(args.length == 0) {
			
			sendInvalidUsage(sender);
			
			return true;
		}
		
		String subCommand = args[0];
		
		if(subCommand == null)
			return false;
		
		if(subCommand.equalsIgnoreCase("announce")) {
			
			this.mainInstance.getAnnouncer().run();
			
			return true;
		}
		
		
		if(subCommand.equalsIgnoreCase("reload")) {
			
			this.mainInstance.reloadConfiguration();
			
			sender.sendMessage(ChatColor.GREEN + "The configuration has been reloaded successfully!");
			
			return true;
		}
		
		if(subCommand.equalsIgnoreCase("list")) {
			
			sender.sendMessage(ChatColor.GREEN + "Listing announcements: ");
			
			for(String announcement : mainInstance.getConfiguration().getAnnouncements()) {
				
				sender.sendMessage(ChatColor.GREEN + " - " + announcement);
				
			}
			
			return true;
		}
		
		sendInvalidUsage(sender);
		
		return true;
		
	}

	public void sendInvalidUsage(CommandSender sender) {
		
		sender.sendMessage(ChatColor.RED + "Invalid usage!\n"
				+ "- /announcer announce: Forces the announcer to announce now\n"
				+ "- /announcer reload: Reloads the configuration\n"
				+ "- /announcer list: Lists all announcements");
		
	}
	
}
