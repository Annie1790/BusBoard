package busboard.JsonFetcher;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class JsonFetcher {
    HttpClient client = HttpClient.newHttpClient();

    public String fetch(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body) // tells the httpresponse instance(which has been stored) to use the body
                                               // method(thenapply is a public method of completablefuture class)
                .join();

       return response;
    }
    
}