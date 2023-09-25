package busboard.BusStopFinder;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import busboard.JsonFetcher.JsonFetcher;

public class BusStopFinder {
    private JsonFetcher fetcher = new JsonFetcher();

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
    // todo: create parser classes for each parser method

    private BusStops getBusStops(String JsonLikeString) {
        try {
            JSONObject outer = new JSONObject(JsonLikeString);
            JSONArray stopPoints = outer.getJSONArray("stopPoints");
            for (int i = 0; i < stopPoints.length(); i++) {
                System.out.println(stopPoints.getJSONObject(i));
            }
            return null;
        } catch (JSONException e) {
            System.out.print(e);
            return null;
        }
    }

    public void doThis(String userInput) {
        LatAndLong latitudeAndLongitude = deserializeLatitudeAndLongitude(
                fetcher.fetch("http://api.postcodes.io/postcodes/" + userInput));
        String result = fetcher.fetch("https://api.tfl.gov.uk/StopPoint/?lat="
                + latitudeAndLongitude.getLatitude() + "&lon="
                + latitudeAndLongitude.getLongitude()
                + "&stopTypes=NaptanOnstreetBusCoachStopPair&radius=400");
        getBusStops(result);
    }

}
