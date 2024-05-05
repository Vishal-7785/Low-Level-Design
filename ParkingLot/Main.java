/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println();

        ParkingController parkingController = new ParkingController();
        User u = new User("Shanu",1,new Address("Sainik", "kanpur", "UP", 208011),new Card(1,"Rupay",3000));
        Vehicle vehicle = new Vehicle(u, "XUV300", VehicleType.CAR, 5461);

        Ticket t = parkingController.parkVehicle(vehicle);
        parkingController.unparkVehicle(u, t);

        System.out.println();


    }
}