package com.che1sBukkit.BlockReminder.listener;

import com.che1sBukkit.BlockReminder.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class DestoryReminder extends Reminder {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("PlaceReminder.bypass.test1")) {
            return;
        }
        if (e.getBlock().getType().toString().equalsIgnoreCase(material)
                && worlds.contains(e.getBlock().getWorld().getName())) {
            if (players.contains(player)) {
                return;
            }
            player.sendMessage(message);
            if (delay != 0) {
                players.add(player);
                Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), () -> {
                    players.remove(player);
                }, delay * 20L);
            }
            e.setCancelled(revocate);
        }
    }
}
