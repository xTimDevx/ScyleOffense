package me.xTimDevx.ScyleOffense.Commands;

import java.util.ArrayList;
import java.util.Date;

import me.xTimDevx.ScyleOffense.DateUtils;
import me.xTimDevx.ScyleOffense.Main;
import me.xtimdevx.scylelib.User;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class TempBanCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		final Player p = (Player) sender;
		final User user = User.get(p);
		if(cmd.getName().equalsIgnoreCase("tempban")) {
			if(!p.hasPermission("scylemc.offense.command.tempban")) {
				p.sendMessage("§8[§cTEMPBAN§8]: §cYou do not have the permission §nscylemc.offense.command.tempban§c!");
				return true;
			}
			
			if(args.length < 3) {
				p.sendMessage("§8[§cTEMPBAN§8]: §cUsage: /tempban <player> <time> <reason>");
				return true;
			}
			
			final Player target = Bukkit.getServer().getPlayer(args[0]);
			
			final BanList list = Bukkit.getBanList(Type.NAME);
			
			long time = DateUtils.parseDateDiff(args[1], true);
			Date date = new Date(time);
			
			StringBuilder reason = new StringBuilder("");
			
			for(int i = 2; i < args.length; i++) {
				reason.append(args[i]).append(" ");
			} 
			
			final String msg = reason.toString().trim();
			
			if(target == null) {
				p.getServer().broadcastMessage("§8[§cTEMPBAN§8]: §c" + args[0] + " §7has been temp-banned for §c" + msg + "§7!");
				list.addBan(args[0], msg, date, sender.getName());
				user.getFile().set("bans", user.getFile().getInt("bans") +1);
				user.saveFile();
				return true;
 			}
			
			  if(target.getUniqueId().toString().equals("a06fb8df-4ce8-4b60-a1d2-15e1d0d06619") || target.getUniqueId().toString().equals("47797ff7-03fe-4a6a-b595-17e4a171ef69")) {
					p.sendMessage("§8[§cBAN§8]: §cYou can not ban xTimDevx & GirlJitske.");
					return true;
				}
			
			new BukkitRunnable() {
				int left = 3;
				
				public void run() {
					if(left == 0) {
						long time = DateUtils.parseDateDiff(args[1], true);
						
						Date date = new Date(time);
						
						p.getServer().broadcastMessage("§8[§cTEMPBAN§8]: §c" + args[0] + " §7has been temp-banned for §c" + msg + "§7!");
						user.getFile().set("bans", user.getFile().getInt("bans") +1);
						user.saveFile();
						for (Player online : Bukkit.getOnlinePlayers()) { 
				            online.playSound(online.getLocation(), Sound.BLAZE_HIT, 1, 1); 
						}
						
						BanEntry ban = list.addBan(target.getName(), msg, date, p.getName());
						
						target.setWhitelisted(false);
						
						PlayerDeathEvent event = new PlayerDeathEvent(target, new ArrayList<ItemStack>(), 0, null); 
				        Bukkit.getServer().getPluginManager().callEvent(event);
				        
				        target.kickPlayer("§8[§cBAN§8]: §7You have been §ctemp-banned §7from the §cScyleMC §7network." + 
				                "\n" +  
				                "\n§7Reason: §c" + ban.getReason() + 
				                "\n7§Banned by: §c" + ban.getSource() + 
				                "\n§7Expires in: §c" + DateUtils.formatDateDiff(time) + 
				                "\n" + 
				                "\n§8[§cBAN§8]: §7If you would like to appeal, Send an email to §capply@scylemc.com§7." 
				                );
				        
				        cancel();
				        
					} else {
						p.getServer().broadcastMessage("§8[§cTEMPBAN§8]: §7Incoming §ctemp-ban §7in §c" + left + "§7.");
						left--;
						
						for (Player online : Bukkit.getOnlinePlayers()) { 
				            online.playSound(online.getLocation(), Sound.CLICK, 1, 1); 
				           } 
					}
				}
			}.runTaskTimer(Main.plugin, 0, 20); 
		}
		return true;
	}
	
}
