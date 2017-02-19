package me.xTimDevx.ScyleOffense.Commands;

import me.xtimdevx.scylelib.User;
import me.xtimdevx.scylelib.User.Rank;
import me.xtimdevx.scyleuhc.utils.Messages;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlashStaffInfo implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("staffinfo")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage(Messages.ERROR + "Usage: /staffinfo <staffmember>");
				return true;
			}
			
			if(args.length == 1) {
				@SuppressWarnings("deprecation")
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				User user = User.get(target);
				if(!(user.getRank() == Rank.ADMIN) && !(user.getRank() == Rank.MOD) && !(user.getRank() == Rank.OWNER)) {
					p.sendMessage(Messages.ERROR + "This player is not a staff member.");
					return true;
				}
				
				p.sendMessage("§8[§cSTAFF§8]: §c" + target.getName() + "§7's staff info:");
				p.sendMessage("§8[§cSTAFF§8]: §7Rank: §c" + user.getRank());
				p.sendMessage("§8[§cSTAFF§8]: §7Bans: §c" + user.getFile().getInt("bans"));
				p.sendMessage("§8[§cSTAFF§8]: §7Mutes: §c0");
			}
		}
		return true;
	}

}
