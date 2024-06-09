import java.util.*;
public class TripService {
    List<Trip> allTrips;
    
    public TripService(){
        allTrips = new ArrayList<>();
    }

    public void addTrip(Trip trip){
        allTrips.add(trip);
    }

    public Trip getTrip(int id){
        if(allTrips.size()>0){
            for(Trip trip:allTrips){
                if(trip.getID() == id){
                    return trip;
                }
            }
        }
        return null;
    }

}
