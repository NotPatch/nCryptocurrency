package com.notpatch;

import com.notpatch.markets.BinanceAPI;
import com.notpatch.markets.CoinGeckoAPI;
import com.notpatch.markets.CryptoAPI;

public class APIProvider {

    private static final APIProvider INSTANCE = new APIProvider();

    private static final CryptoAPI coinGeckoAPI = new CoinGeckoAPI();
    private static final CryptoAPI binanceAPI = new BinanceAPI();

    private APIProvider() {
    }

    public static APIProvider getAPI() {
        return INSTANCE;
    }

    public static double getCoinGeckoPrice(String crypto, String currency) {
        return coinGeckoAPI.getPrice(crypto, currency);
    }

    public static double getBinancePrice(String crypto, String currency) {
        return binanceAPI.getPrice(crypto, currency);
    }

}
