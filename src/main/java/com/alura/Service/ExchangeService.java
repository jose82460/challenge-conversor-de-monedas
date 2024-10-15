package com.alura.Service;

import com.alura.Models.ExchangeRate;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/c3a4e5e69e3788e4674bd8db/pair/";

    public static ExchangeRate exchangeRate(String tasaOrigen, String tasaDestino) {
        String url = API_URL + tasaOrigen + "/" + tasaDestino;
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("Error en la tasa de cambio: " + e.getMessage(), e);
        }
    }

    public static double convertmonto(String tasaOrigen, String tasaDestino, double monto) {
        return monto * exchangeRate(tasaOrigen, tasaDestino).getConversion_rate();
    }
}
