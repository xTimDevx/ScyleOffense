package me.xTimDevx.ScyleOffense.Commands;

import me.xTimDevx.ScyleOffense.DateUtils;
import me.xtimdevx.scylelib.User;
import me.xtimdevx.scylelib.User.Rank;
import me.xtimdevx.scyleuhc.Settings;
import me.xtimdevx.scyleuhc.utils.Messages;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishinfoCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		User user = User.get(p);
		String PUNISHPREFIX = Messages.PREFIX.replace("UHC", "Punish");
		if(cmd.getName().equalsIgnoreCase("punishinfo")) {
			if(user.getRank() == Rank.PLAYER || user.getRank() == Rank.BUILDER || user.getRank() == Rank.HELPER) {
				p.sendMessage(PUNISHPREFIX + "You are not allowed to see punishments.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage(PUNISHPREFIX + "Usage: /punishinfo <player>");
				return true;
			}
			
			if(args.length == 1) {
				BanList name = Bukkit.getBanList(Type.NAME); 
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) {
				    BanEntry ban = name.getBanEntry(args[0]);
				    if(ban == null) {
				    	p.sendMessage(PUNISHPREFIX + "This player is not on the punish database.");
				    	return true;
				    }
				    int id = Settings.getData().getInt("punish.id");
				    p.sendMessage(PUNISHPREFIX + "Punishment §c#" + id + "§7:");
				    p.sendMessage("§7Name: §a" + args[0]);
				    p.sendMessage("§7Reason: §a" + ban.getReason());
				    p.sendMessage("§7ID: §a#" + id);
				    p.sendMessage("§7Punisher: §a" + ban.getSource());
				    if(ban.getExpiration() == null) {
				    	p.sendMessage("§7Time: §aPermanent");
				    }else{
				    	p.sendMessage("§7Time: §a" + DateUtils.formatDateDiff(ban.getExpiration().getTime()));
				    }
				    p.sendMessage("§7Alts: §aNone");
				}
			}
		}
		return true;
	}

}
