/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.addRequest(new Request(Location.INSIDE, 10, Direction.UPWARD));
        elevator.addRequest(new Request(Location.INSIDE, 2, Direction.UPWARD));
        elevator.addRequest(new Request(Location.INSIDE, 3, Direction.UPWARD));
        elevator.addRequest(new Request(Location.OUTSIDE, 9, Direction.UPWARD));
        elevator.addRequest(new Request(Location.INSIDE, -1, Direction.DOWNWARD));
        elevator.addRequest(new Request(Location.INSIDE, 5, Direction.DOWNWARD));
        elevator.processRequest();
    }
}