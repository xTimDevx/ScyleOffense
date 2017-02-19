package me.xTimDevx.ScyleOffense.Commands;

import me.xtimdevx.scylelib.User;
import me.xtimdevx.scylelib.User.Rank;
import me.xtimdevx.scyleuhc.Settings;
import me.xtimdevx.scyleuhc.utils.Messages;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("punish")) {
			Player p = (Player) sender;
			User user = User.get(p);
			String PUNISHPREFIX = Messages.PREFIX.replace("UHC", "Punish");
			if(user.getRank() == Rank.PLAYER || user.getRank() == Rank.BUILDER || user.getRank() == Rank.HELPER) {
				p.sendMessage(PUNISHPREFIX + "You are not allowed to punish players.");
				return true;
			}
			
			if(args.length == 0) {
				p.sendMessage(PUNISHPREFIX + "Usage: /punish <player> <reason>");
				p.sendMessage(PUNISHPREFIX + "Use /punish reasons to see the punish reasons.");
				return true;
			}
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reasons")) {
					p.sendMessage(PUNISHPREFIX + "Report reasons:");
					p.sendMessage("§7- KILLAURA");
					p.sendMessage("§7- ANTIKNOCKBACK");
					p.sendMessage("§7- FLY");
					p.sendMessage("§7- SPEED");
					p.sendMessage("§7- FASTBOW");
					p.sendMessage("§7- AIMBOT");
					p.sendMessage("§7- FASTEAT");
					p.sendMessage("§7- TEAMING");
					p.sendMessage("§7- NAME");
					p.sendMessage("§7- SPAM");
					p.sendMessage("§7- XRAY");
					p.sendMessage("§7- OTHER");
					return true;
				}
				p.sendMessage(PUNISHPREFIX + "Usage: /punish <player> <reason>");
				p.sendMessage(PUNISHPREFIX + "Use /punish reasons to see the punish reasons.");
				return true;
			}
			if(args.length == 2) {
				final BanList list = Bukkit.getBanList(Type.NAME);
				
				
				StringBuilder reason = new StringBuilder("");
				
				for(int i = 1; i < args.length; i++) {
					reason.append(args[i]).append(" ");
				} 
				
				final String msg = reason.toString().trim();
				
				Player target =  Bukkit.getPlayer(args[0]);
				if(args[1].equalsIgnoreCase("killaura")) {
					if(target == null) {
						for(Player online : Bukkit.getOnlinePlayers()) {
							online.sendMessage(PUNISHPREFIX + "§c" + args[0] + " §7has been banned for §c" + msg + "§7!");
							if(online.hasPermission("uhc.staff")) {
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(PUNISHPREFIX + "§7Click §ahere §7to see the ban info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/punishinfo " + args[0]));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(PUNISHPREFIX + "§7Click §ahere §7to see the ban info.") }));
							    online.spigot().sendMessage(builder.create()); 		
							 }
						}
						list.addBan(args[0], msg, null, sender.getName());
						Settings.getData().set("punish.id", Settings.getData().getInt("punish.id") + 1);
						Settings.getInstance().saveData();
					}else{
						for(Player online : Bukkit.getOnlinePlayers()) {
							online.sendMessage(PUNISHPREFIX + "§c" + target.getName() + " §7has been banned for §c" + msg + "§7!");
							if(online.hasPermission("uhc.staff")) {
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(PUNISHPREFIX + "§7Click §ahere §7to see the ban info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/punishinfo " + args[0]));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(PUNISHPREFIX + "§7Click §ahere §7to see the ban info.") }));
							    online.spigot().sendMessage(builder.create()); 		
							 }
						}
						list.addBan(target.getName(), msg, null, sender.getName());
						target.kickPlayer(PUNISHPREFIX + "You got banned from the server.");
						Settings.getData().set("punish.id", Settings.getData().getInt("punish.id") + 1);
						Settings.getInstance().saveData();
					}
				}
				return true;
			}
			p.sendMessage(PUNISHPREFIX + "This is not a valid punish reason.");
			p.sendMessage(PUNISHPREFIX + "Use /punish reasons to see the punish reasons.");
		}
		return true;
	}

}
