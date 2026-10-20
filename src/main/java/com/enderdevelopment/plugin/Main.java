package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.TimeUnit;

public class Main extends JavaPlugin {

    private FileConfiguration config;
    private long restartInterval;

    @Override
    public void onEnable() {
        // Save default config if it doesn't exist
        saveDefaultConfig();
        config = getConfig();

        // Load restart interval from config
        restartInterval = config.getLong("restart-interval", TimeUnit.HOURS.toMillis(5));

        // Schedule the restart task
        scheduleRestartTask();

        getLogger().info("ServerRestartPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ServerRestartPlugin has been disabled!");
    }

    private void scheduleRestartTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("Server is restarting in 5 minutes!");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.broadcastMessage("Server is restarting now!");
                        Bukkit.shutdown();
                    }
                }.runTaskLater(Main.this, 20 * 60 * 5); // 5 minutes in ticks
            }
        }.runTaskTimer(this, restartInterval, restartInterval);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("restart")) {
            if (sender.hasPermission("serverrestart.restart")) {
                Bukkit.broadcastMessage("Server is restarting now!");
                Bukkit.shutdown();
                return true;
            } else {
                sender.sendMessage("You do not have permission to use this command.");
                return false;
            }
        }
        return false;
    }
}