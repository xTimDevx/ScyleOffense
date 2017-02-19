package me.xTimDevx.ScyleOffense;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Eventws implements Listener{
	
	public Eventws(Main main) {
	}

	@EventHandler
	public void onJoin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		 if (event.getResult() == Result.KICK_BANNED) { 
			   BanList name = Bukkit.getBanList(Type.NAME); 
			    
			    
			   if (name.getBanEntry(player.getName()) != null) { 
			    if (player.hasPermission("uhc.staff")) { 
			     name.pardon(player.getName()); 
			     event.allow(); 
			     return; 
			    } 
			 
			    BanEntry ban = name.getBanEntry(player.getName()); 			     
			    if(ban.getExpiration() == null) {
				    event.setKickMessage( 
				    		"§8[§cBAN§8]: §7You have been §cbanned §7from the §cScyleMC §7network." + 
					                "\n" +  
					                "\n§7Reason: §c" + ban.getReason() + 
					                "\n§7Banned by: §c" + ban.getSource() + 
					                "\n" + 
					                "\n§8[§cBAN§8]: §7If you would like to appeal, Send an email to §capply@scylemc.com" 
				    ); 
			    }else{
			    event.setKickMessage( 
			    		"§8[§cBAN§8]: §7You have been §ctemp-banned §7from the §cScyleMC §7network." + 
				                "\n" +  
				                "\n§7Reason: §c" + ban.getReason() + 
				                "\n§7Banned by: §c" + ban.getSource() + 
				                "\n§7Expires in: §c" +  DateUtils.formatDateDiff(ban.getExpiration().getTime()) + 
				                "\n" + 
				                "\n§8[§cBAN§8]: §7If you would like to appeal, Send an email to §capply@scylemc.com" 
			    ); 
			   } 
			   }
	}
	}

}
