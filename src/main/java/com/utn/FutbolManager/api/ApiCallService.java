package com.utn.FutbolManager.api;

import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
@Slf4j
public class ApiCallService {
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
