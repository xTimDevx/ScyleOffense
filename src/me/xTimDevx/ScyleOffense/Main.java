package me.xTimDevx.ScyleOffense;


import me.xTimDevx.ScyleOffense.Commands.BanCommand;
import me.xTimDevx.ScyleOffense.Commands.MuteCommand;
import me.xTimDevx.ScyleOffense.Commands.PunishCommand;
import me.xTimDevx.ScyleOffense.Commands.PunishinfoCommand;
import me.xTimDevx.ScyleOffense.Commands.ReportCommand;
import me.xTimDevx.ScyleOffense.Commands.SlashStaffInfo;
import me.xTimDevx.ScyleOffense.Commands.TempBanCommand;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		getCommand("tempban").setExecutor(new TempBanCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("staffinfo").setExecutor(new SlashStaffInfo());
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("punish").setExecutor(new PunishCommand());
		getCommand("punishinfo").setExecutor(new PunishinfoCommand());
		Bukkit.getPluginManager().registerEvents(new Eventws(this), this);
 	}
}
