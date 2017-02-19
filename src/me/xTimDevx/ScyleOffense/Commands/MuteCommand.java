package me.xTimDevx.ScyleOffense.Commands;

import java.util.Date;
import java.util.TimeZone;

import me.xTimDevx.ScyleOffense.DateUtils;
import me.xtimdevx.scylelib.User;
import me.xtimdevx.scyleuhc.utils.Messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Player target = Bukkit.getPlayer(args[0]);
		User user = User.get(target);
		if(cmd.getName().equalsIgnoreCase("mute")) {
			if(!p.hasPermission("uhc.command.mute")) {
				p.sendMessage(Messages.NOPERMMESSAGE);
				return true;
			}
			
			if(args.length == 0) {
				p.sendMessage(Messages.ERROR + "/mute <player> [time] [reason]");
				return true;
			}
			if(args.length == 1) {			
			if(target == null) {
				p.sendMessage(Messages.ERROR + "That player is not online.");
				return true;
			}
			}
			if(args.length < 3) {
				p.sendMessage(Messages.ERROR + "/mute <player> [time] [reason]");
				return true;
			}
			
			StringBuilder message = new StringBuilder("");
			
			for(int i = 2; i < args.length; i++) {
				message.append(args[i]).append(" ");
			}
			
			String reason = message.toString().trim();
			TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
			long time = DateUtils.parseDateDiff(args[1], true); 
			
			Bukkit.broadcastMessage(Messages.PREFIX + "§c" + target.getName() + " §7has been §c" + (args[1].equals("-") ? "muted" : "temp-mute") + " §7for §c" + reason + "§7.");
			target.sendMessage(Messages.PREFIX + "You have been muted for §c" + reason + "§7.");
			
			user.mute(reason, (time <= 0 ? null : new Date(time)));
			}
		return true;
	}

}
