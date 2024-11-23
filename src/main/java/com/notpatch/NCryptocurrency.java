package com.notpatch;

import com.notpatch.markets.BinanceAPI;
import com.notpatch.markets.CoinGeckoAPI;
import com.notpatch.markets.CryptoAPI;

public class NCryptocurrency {

    private static final CryptoAPI coinGeckoAPI = new CoinGeckoAPI();
    private static final CryptoAPI binanceAPI = new BinanceAPI();

    // Singleton pattern
    private NCryptocurrency() {
    }

    public static double getCoinGeckoPrice(String crypto, String currency) {
        return coinGeckoAPI.getPrice(crypto, currency);
    }

    public static double getBinancePrice(String crypto, String currency) {
        return binanceAPI.getPrice(crypto, currency);
    }

}