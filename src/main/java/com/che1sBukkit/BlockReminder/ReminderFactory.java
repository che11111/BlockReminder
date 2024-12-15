package com.che1sBukkit.BlockReminder;

import com.che1sBukkit.BlockReminder.listener.DestoryReminder;
import com.che1sBukkit.BlockReminder.listener.PlaceReminder;
import com.che1sBukkit.BlockReminder.listener.Reminder;
import java.util.List;

public class ReminderFactory {
    private ReminderFactory() {}

    public static Reminder getReminder(String material, String message, int delay, boolean revocate, List<String> worlds, String behavior) {
        if (behavior.equalsIgnoreCase("place")) {
            return new PlaceReminder().setMaterial(material).setMessage(message).setDelay(delay).setRevocate(revocate).setWorlds(worlds);
        } else if (behavior.equalsIgnoreCase("destroy")) {
            return new DestoryReminder().setMaterial(material).setMessage(message).setDelay(delay).setRevocate(revocate).setWorlds(worlds);
        }
        throw new IllegalArgumentException();
    }
}
