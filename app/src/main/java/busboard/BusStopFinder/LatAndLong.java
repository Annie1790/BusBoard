package busboard.BusStopFinder;

public class LatAndLong {
    String latitude;
    String longitude;

    public LatAndLong(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }
}
