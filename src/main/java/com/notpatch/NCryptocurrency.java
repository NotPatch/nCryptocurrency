package com.notpatch;

import com.notpatch.markets.BinanceAPI;
import com.notpatch.markets.CoinGeckoAPI;
import com.notpatch.markets.CryptoAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class NCryptocurrency {

    private static JavaPlugin plugin;

    private static final NCryptocurrency INSTANCE = new NCryptocurrency();

    private static final CryptoAPI coinGeckoAPI = new CoinGeckoAPI();
    private static final CryptoAPI binanceAPI = new BinanceAPI();

    private NCryptocurrency() {
    }

    public static double getCoinGeckoPrice(String crypto, String currency) {
        return coinGeckoAPI.getPrice(crypto, currency);
    }

    public static double getBinancePrice(String crypto, String currency) {
        return binanceAPI.getPrice(crypto, currency);
    }


    public static void setPlugin(final JavaPlugin plugin) {
        if (NCryptocurrency.plugin != null) {
            throw new IllegalStateException("You already referenced api!");
        }
        NCryptocurrency.plugin = plugin;
    }

    public static NCryptocurrency getAPI() {
        if (plugin == null) {
            throw new IllegalStateException("Plugin reference not set! Call setPlugin() first.");
        }
        return INSTANCE;
    }

}