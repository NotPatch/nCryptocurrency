package com.notpatch;

import org.bukkit.plugin.java.JavaPlugin;

public class nCryptocurrency {
    private static JavaPlugin plugin;


    public static void setPlugin(final JavaPlugin plugin) {
        if (nCryptocurrency.plugin != null) {
            throw new IllegalStateException("You already referenced api!");
        }
        nCryptocurrency.plugin = plugin;
    }

    public static JavaPlugin getPlugin() {
        if (plugin == null) {
            throw new IllegalStateException("Plugin reference not set! Call setPlugin() first.");
        }
        return plugin;
    }


}