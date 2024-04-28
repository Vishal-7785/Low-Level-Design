import java.util.Arrays;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        try{
            Controller controller = new Controller();
            User u = new User(1,"Vishal",new Card(2,"Vishal",900));
            controller.displayShows("Kanpur");
            controller.seletShow("Tiger3");
            controller.selectTheater("ZSQUARE");
            controller.selectSeats(Arrays.asList(4, 7, 8, 9),Slot.EVENING);
            controller.payAndGetTicket(u);
            controller.selectSeats(Arrays.asList(1,3,10,19),Slot.EVENING);
            controller.payAndGetTicket(u);

        }catch(Exception  e){
            System.out.println();
            System.out.println(e);
        }
    }
}