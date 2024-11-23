package com.notpatch;

import org.bukkit.plugin.java.JavaPlugin;

public class NCryptocurrency {
    private static JavaPlugin plugin;
    private static APIProvider apiProvider;


    public static void setPlugin(final JavaPlugin plugin) {
        if (NCryptocurrency.plugin != null) {
            throw new IllegalStateException("You already referenced api!");
        }
        NCryptocurrency.plugin = plugin;
    }

    public static APIProvider getAPI() {
        if (plugin == null) {
            throw new IllegalStateException("Plugin reference not set! Call setPlugin() first.");
        }
        return apiProvider;
    }
}