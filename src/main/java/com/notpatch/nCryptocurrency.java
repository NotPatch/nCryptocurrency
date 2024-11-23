package com.notpatch;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.bukkit.plugin.java.JavaPlugin;

public class Main {
    private static JavaPlugin plugin;

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    public static void main(String[] args) {
        try {
            String currency = "bitcoin";
            String vsCurrency = "usd";

            String apiUrl = COINGECKO_API_URL + "?ids=" + currency + "&vs_currencies=" + vsCurrency;

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(apiUrl)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
                double price = jsonObject.getAsJsonObject(currency).get(vsCurrency).getAsDouble();

                System.out.println("Bitcoin fiyatı (USD): " + price);
            } else {
                System.err.println("API Hatası: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}