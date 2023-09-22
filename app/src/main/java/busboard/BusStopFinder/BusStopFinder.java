package busboard.BusStopFinder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.http.HttpRequest;

public class BusStopFinder {

    public String fetch(String url) {
        HttpClient client = HttpClient.newHttpClient();
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

    private LatAndLong deserializeLatitudeAndLongitude(String JsonLikeString) {
        try {
            JSONObject outer = new JSONObject(JsonLikeString);
            JSONObject inner = outer.getJSONObject("result");
            String longitude = inner.getString("longitude");
            String latitude = inner.getString("latitude");
            return new LatAndLong(latitude, longitude);

        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }

    private BusStops getBusStops(String JsonLikeString) {
        try {
            JSONObject outer = new JSONObject(JsonLikeString);
            JSONArray stopPoints = outer.getJSONArray("stopPoints");
            for (int i = 0; i <= stopPoints.length(); i++) {
                //todo
            }
            return null;
        } catch (JSONException e) {
            System.out.print(e);
            return null;
        }
    }

    public void doThis(String userInput) {
        LatAndLong latitudeAndLongitude = deserializeLatitudeAndLongitude(
                fetch("http://api.postcodes.io/postcodes/" + userInput));
        String result = fetch("https://api.tfl.gov.uk/StopPoint/?lat="
                + latitudeAndLongitude.getLatitude() + "&lon="
                + latitudeAndLongitude.getLongitude()
                + "&stopTypes=NaptanOnstreetBusCoachStopPair&radius=400");
        getBusStops(result);
    }

}
