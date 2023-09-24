package busboard.BusStopFinder;

import java.util.ArrayList;

public class BusStops {
    String commonName;
    String stopId;
    ArrayList<ArrivingBus> busList = new ArrayList<>();

    public BusStops(String name, String stopId, ArrayList<ArrivingBus> busList) {
        this.commonName = name;
        this.busList = busList;
    }

    public void addBusToBusStop(ArrivingBus bus) {
        busList.add(bus);
    }
}
