package com.che1sBukkit.BlockReminder;

import com.che1sBukkit.BlockReminder.listener.Reminder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class Main extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        registerListener();
        Bukkit.getLogger().info("[PlaceReminder] 插件已启用");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[PlaceReminder] 插件已停用");
    }

    private void registerListener() {
        FileConfiguration config = getConfig();
        Set<String> keys = config.getKeys(false);

        for (String key : keys) {
            String material = config.getString(key + ".material");
            String message = config.getString(key + ".message");
            int delay = config.getInt(key + ".delay");
            boolean revocate = config.getBoolean(key + ".revocate");
            List<String> worlds = Arrays.asList(config.getString(key + ".worlds").split(","));
            String behavior = config.getString(key + ".behavior");

            Reminder reminder = ReminderFactory.getReminder(material, message, delay, revocate, worlds, behavior);
            Bukkit.getPluginManager().registerEvents(reminder, this);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
