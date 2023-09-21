package busboard.BusStopFinder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;

import java.net.http.HttpRequest;

public class BusStopFinder {
    String result = "";

    public void getter() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.postcodes.io/postcodes/se167tn"))
                .GET()
                .build();

        String cf = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
        

    }
}
