package com.notpatch.markets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BinanceAPI implements CryptoAPI {
    @Override
    public double getPrice(String crypto, String currency) {
        try {
            String symbol = crypto.toUpperCase() + currency.toUpperCase();
            String url = BASE_URL + "?symbol=" + symbol;

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).get().build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String jsonData = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
                return jsonObject.get("price").getAsDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Hata durumunda -1 döner
    }

    private static final String BASE_URL = "https://api.binance.com/api/v3/ticker/price";


}