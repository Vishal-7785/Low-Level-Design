import java.util.*;

public class Theater {
    String name;
    int id;
    String location;
    HashMap<String,Show> showNameMap;
    HashMap<Slot,Screen> slotScreenMap;
    public Theater(String name,int id, String location){
        showNameMap = new HashMap<String,Show>();
        slotScreenMap = new HashMap<Slot,Screen>();
        this.name = name;
        this.id = id;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public List<Slot> getSlot(String name){
        List<Slot> slotList = new ArrayList<Slot>();
        for(Slot s: slotScreenMap.keySet()){
            Show cur_show = slotScreenMap.get(s).getShow();
            if(cur_show.name == name){
                slotList.add(s);
            }
        }
        return slotList;
    }

    public void addShow(Show show, Slot slot){

        if(slotScreenMap.containsKey(slot)){
            System.out.println();
            System.out.println("Can not add show, this slot already has some issuea");
        }else{
            Screen scr = new Screen(show,slot);
            slotScreenMap.put(slot,scr);
            showNameMap.put(show.getName(), show);
        }
        
    }
    public void removeShow(Show show,Slot slot){
        if(slotScreenMap.containsKey(slot)){
            showNameMap.remove(show.getName());
        }
    }

    public void displayShow(String showName){
        Show show = showNameMap.get(showName);
        System.out.println();
        System.out.println(show.getName());
        System.out.println(show.getDescription());
        System.out.println(show.getMinutes());
        System.out.println(show.getRating());
        System.out.println(show.getGenre());
        System.out.println(show.getActors());
        System.out.println("Is trending ?"+ show.getTrending());
        System.err.println();

    }
    public int selectSeats(List<Integer> seats,Slot slot,List<Seat> bookedSeats){
        int price = 0;
        if(slotScreenMap.containsKey(slot)){
            Screen screen = slotScreenMap.get(slot);
            price = screen.selectSeats(seats,bookedSeats);
        }else{
            System.out.println();
            System.out.println("No movie available for this slot, please try with different slot");
            return 0;
        }
        if(price == 0){
            return 0;
        }
        System.out.println();
        System.out.println("Please pay "+price+ " to confirm booking of your seats");
        return price;
    }

    public void bookTickets(List<Integer> bookTiclets,Slot slot){
        if(slotScreenMap.containsKey(slot)){
            Screen screen = slotScreenMap.get(slot);
            List<Seat> bookedSeats = new ArrayList<Seat>();
            screen.bookSeats(bookTiclets, bookedSeats);
        }else{
            System.out.println();
            System.out.println("No movie available for this slot, please try with different slot");
        }
    }


}
