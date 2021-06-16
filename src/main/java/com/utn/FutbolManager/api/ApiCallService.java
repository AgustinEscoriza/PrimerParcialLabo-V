package com.utn.FutbolManager.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApiCallService {
    @CircuitBreaker(name = "futbolista", fallbackMethod = "fallbackFutbolista")
    public List<FutbolistaResponse> getFutbolistasResponse() throws IOException, InterruptedException{

        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://app.sportdataapi.com/api/v1/soccer/players"))
                .header("accept", "application/json")
                .header("x-apikey", "52c94a40-cee6-11eb-b2e8-73d00822e05f&country_id=13")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Type listJugadoresType = new TypeToken<List<FutbolistaResponse>>(){}.getType();
        return new Gson().fromJson(response.body(), listJugadoresType);
    }
    @CircuitBreaker(name = "euro", fallbackMethod = "fallbackEuro")
    public EuroResponse getEuroResponse() throws IOException, InterruptedException {

        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dolarsi.com/api/api.php?type=genedolar&opc=ta"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), EuroResponse.class);
    }

    public EuroResponse fallbackEuro(final Throwable t) {
        log.info("Fallback cause, {}", t.toString());
        return EuroResponse.builder().build();
    }


    @CircuitBreaker(name = "euro", fallbackMethod = "fallbackDollar")
    public DollarResponse getDolarResponse() throws IOException, InterruptedException {

        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dolarsi.com/api/api.php?type=genedolar&opc=ta"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), DollarResponse.class);
    }

    public DollarResponse fallbackDollar(final Throwable t) {
        log.info("Fallback cause, {}", t.toString());
        return DollarResponse.builder().build();
    }
}
