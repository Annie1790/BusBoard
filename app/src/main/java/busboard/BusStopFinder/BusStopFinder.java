package busboard.BusStopFinder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.http.HttpRequest;

public class BusStopFinder {

    public void fetchLatitudeAndLongitude(String userInput) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.postcodes.io/postcodes/" + userInput))
                .GET()
                .build();

        String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body) // tells the httpresponse instance(which has been stored) to use the body
                                               // method(thenapply is a public method of completablefuture class)
                .join();

        deserializeLatitudeAndLongitude(response);
    }

    public void deserializeLatitudeAndLongitude(String string) {
        try {
            JSONObject object = new JSONObject(string);
            JSONObject result = object.getJSONObject("result");
            String longitude = result.getString("longitude");
            String latitude = result.getString("latitude");
            System.out.println("Latitude: " + latitude + "; " + "Longitude: " + longitude + ";");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
