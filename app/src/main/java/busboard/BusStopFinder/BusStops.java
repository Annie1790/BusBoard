package busboard.BusStopFinder;

import java.util.ArrayList;

public class BusStops {
    String commonName;
    double distance;
    ArrayList<Bus> busList = new ArrayList<>();

    public BusStops(String name, double distance, ArrayList<Bus> busList) {
        this.commonName = name;
        this.distance = distance;
        this.busList = busList;
    }

    public void addBusToBusStop(Bus bus) {
        busList.add(bus);
    }
}
