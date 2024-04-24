package com.aluracursos.exchange.conexion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {
    public JsonObject tipomonedas(String money) {

        //Variable para almacenar y acceder a la URI de la api
        //Y ejecutar un switch para no hacer uso de tantas sentencias if

        String currencyCode = "";
        currencyCode = switch (money) {
            case "1", "3", "5" -> "USD";
            case "2" -> "ARS";
            case "4" -> "BRL";
            case "6" -> "COP";
            default -> throw new IllegalArgumentException("Moneda no válida: " + currencyCode);
        };
        //Coneccion a la api

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/581fdd5f75db692000b00905/latest/" + currencyCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al obtener datos del servidor: " + response.statusCode());
            }
            // Parsear la respuesta JSON
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(response.body()).getAsJsonObject();
            return jsonObject;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al procesar la respuesta JSON: " + e.getMessage());
        }
    }
}


