package com.notpatch.markets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CoinGeckoAPI implements CryptoAPI {
    @Override
    public double getPrice(String crypto, String currency) {
        try {
            String url = BASE_URL + "?ids=" + crypto + "&vs_currencies=" + currency;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).get().build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String jsonData = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
                return jsonObject.getAsJsonObject(crypto).get(currency).getAsDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static final String BASE_URL = "https://api.coingecko.com/api/v3/simple/price";

}