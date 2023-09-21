package busboard.BusStopFinder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
            deserialize(cf);
    }

    public void deserialize(String string) {
        try {
            JSONObject object = new JSONObject(string);
            JSONObject result = object.getJSONObject("result");
            String longitude = result.getString("longitude");
            System.out.println(longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
