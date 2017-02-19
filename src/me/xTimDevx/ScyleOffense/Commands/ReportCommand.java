package me.xTimDevx.ScyleOffense.Commands;

import me.xtimdevx.scyleuhc.Settings;
import me.xtimdevx.scyleuhc.commands.SlashUHC;
import me.xtimdevx.scyleuhc.utils.Messages;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ReportCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("report")) {
			String REPORTPREFIX = Messages.PREFIX.replace("UHC", "Report");
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage(REPORTPREFIX + "/report <player> <reason>");
				p.sendMessage(REPORTPREFIX + "Use /report reasons to see the reasons.");
				return true;
			}
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reasons")) {
					p.sendMessage(REPORTPREFIX + "Report reasons:");
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
				if(args[0].equalsIgnoreCase("latestreport")) {
					p.sendMessage(REPORTPREFIX + "Report §c#" + Settings.getData().getInt("report.id"));
						p.sendMessage("§7Name: §a" + Settings.getData().get("report.player"));
						p.sendMessage("§7Online: " + Settings.getData().get("report.online"));
						p.sendMessage("§7Reason: §a" + Settings.getData().get("report.reason"));
						p.sendMessage("§7ID: §a#" + Settings.getData().getInt("report.id"));
						p.sendMessage("§7Reporter: §a" + Settings.getData().get("report.reporter"));
						return true;
				}
				p.sendMessage(REPORTPREFIX + "/report <player> <reason>");
				p.sendMessage(REPORTPREFIX + "Use /report reasons to see the reasons.");
				return true;
			}
			
			if(args.length == 2) {
				Player target = Bukkit.getPlayer(args[0]);
				@SuppressWarnings("deprecation")
				OfflinePlayer otarget = Bukkit.getOfflinePlayer(args[0]);
				if(target == null) {
					if(args[1].equalsIgnoreCase("killaura")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "KILLAURA");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §ckillaura§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("antiknockback")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "ANTIKNOCKBACK");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cantiknockback§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}		
					if(args[1].equalsIgnoreCase("fly")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "FLY");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cfly§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}	
					if(args[1].equalsIgnoreCase("speed")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "SPEED");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cspeed§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("fastbow")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "FASTBOW");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cfastbow§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("aimbot")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "AIMBOT");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §caimbot§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("fasteat")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "fasteat");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cfasteat§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("teaming")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "TEAMING");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cteaming§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("name")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "NAME");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cname§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("spam")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "SPAM");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cspam§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("xray")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "XRAY");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cxray§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					if(args[1].equalsIgnoreCase("other")) {
						p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
						Settings.getData().set("report.player", otarget.getName());
						Settings.getData().set("report.reason", "OTHER");
						Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
						Settings.getData().set("report.reporter", p.getName());
						Settings.getData().set("report.online", "§cfalse");
						Settings.getInstance().saveData();
						for(Player online : Bukkit.getOnlinePlayers()) {
							if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
								online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + otarget.getName() + " §7for §cother§7.");
							    ComponentBuilder builder = new ComponentBuilder(""); 
							    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
							    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
							    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
							    online.spigot().sendMessage(builder.create()); 
							}
							
						}
						return true;
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("killaura")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "KILLAURA");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §ckillaura§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") })); 
						    online.spigot().sendMessage(builder.create()); 
						}
					}
					return true;
					
				}
				if(args[1].equalsIgnoreCase("antiknockback")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "ANTIKNOCKBACK");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cantiknockback§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("fly")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "FLY");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cfly§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("speed")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "SPEED");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cspeed§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("fastbow")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "FASTBOW");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cfastbow§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("aimbot")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "AIMBOT");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §caimbot§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("fasteat")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "FASTEAT");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cfasteat§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("teaming")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "TEAMING");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cteaming§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("name")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "NAME");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cname§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("spam")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "SPAM");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cspam§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("xray")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "XRAY");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cxray§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				if(args[1].equalsIgnoreCase("other")) {
					p.sendMessage(REPORTPREFIX + "The §chost §7and §cspectators §7recieved your report.");
					Settings.getData().set("report.player", target.getName());
					Settings.getData().set("report.reason", "OTHER");
					Settings.getData().set("report.id", (Settings.getData().getInt("report.id") +1));
					Settings.getData().set("report.reporter", p.getName());
					Settings.getData().set("report.online", "§atrue");
					Settings.getInstance().saveData();
					for(Player online : Bukkit.getOnlinePlayers()) {
						if(SlashUHC.opspectators.containsKey(online.getName()) || Settings.getData().get("game.host").equals(online.getName())) {
							online.sendMessage(REPORTPREFIX + "§c" + p.getName() + " §7reported §c" + target.getName() + " §7for §cother§7.");
						    ComponentBuilder builder = new ComponentBuilder(""); 
						    builder.append(REPORTPREFIX + "§7Click §ahere §7to see the report info."); 
						    builder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report latestreport"));
						    builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[] { new TextComponent(REPORTPREFIX + "§7Click §ahere §7to see the report info.") }));
						    online.spigot().sendMessage(builder.create()); 
						}
						
					}
					return true;
				}
				p.sendMessage(REPORTPREFIX + "Please use a valid report reason.");
				p.sendMessage(REPORTPREFIX + "Use /report reasons to see the reasons.");
			}
		}
		return true;
	}

}
