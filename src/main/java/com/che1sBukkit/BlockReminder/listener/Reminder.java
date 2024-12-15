package com.che1sBukkit.BlockReminder.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Reminder implements Listener {
    protected String material;

    protected String message;

    protected int delay;

    protected boolean revocate;

    protected List<String> worlds;

    protected final Set<Player> players = new HashSet<>();

    protected Reminder() {}

    public Reminder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public Reminder setMessage(String message) {
        this.message = message;
        return this;
    }

    public Reminder setDelay(int delay) {
        this.delay = delay;
        return this;
    }

    public Reminder setRevocate(boolean revocate) {
        this.revocate = revocate;
        return this;
    }

    public Reminder setWorlds(List<String> worlds) {
        this.worlds = new ArrayList<>(worlds);
        return this;
    }
}
