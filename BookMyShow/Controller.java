import java.io.IOException;
import java.util.*;

public class Controller {
    
    Theater t;
    String showName;
    Slot slot;
    HashMap<String,List<Show>> showCityMap;
    HashMap<String,List<Theater>> showTheaterMap;
    HashMap<String, Theater> theaterMap;
    List<Seat> bookedSeats = new ArrayList<Seat>();
    int totalPrice = 0;
    public Controller(){
        theaterMap = new HashMap<String,Theater>();
        showTheaterMap = new HashMap<String,List<Theater>>();
        showCityMap = new HashMap<String,List<Show>>();
        initializeTheaters();
        initializeShows();
        
    }

    private void initializeShows(){
        Show tiger3 = new Show(1,"Tiger3","160",true,Arrays.asList("Salman","Katrina"),Genre.ACTION,9.9,"Great Movie");
        Show pathan = new Show(1,"pathan","170",true,Arrays.asList("Shahrukh","Deepika"),Genre.ACTION,9.9,"Ok Movie");
        Show tarzan = new Show(1,"tarzan","190",true,Arrays.asList("Ajay Devgan","Unknown"),Genre.THRILLER,9.9,"Nice Movie");
        Show Dabang = new Show(1,"Dabang","120",true,Arrays.asList("Salman","Sonakshi"),Genre.COMEDY,9.9,"Awesome Movie");
        showCityMap.put("Kanpur", Arrays.asList(tiger3,pathan,tarzan,Dabang));
        int i = 0;
        for(String s:theaterMap.keySet()){
            if(i==0){
                Theater t = theaterMap.get(s);
                t.addShow(tiger3, Slot.MORNING);
                t.addShow(tiger3, Slot.AFTERNOON);
                t.addShow(tiger3, Slot.EVENING);
            
            }else if(i==1){
                Theater t = theaterMap.get(s);
                t.addShow(pathan, Slot.MORNING);
                t.addShow(tiger3, Slot.AFTERNOON);
                t.addShow(pathan, Slot.EVENING);
            
            }else if(i==2){
                Theater t = theaterMap.get(s);
                t.addShow(pathan, Slot.MORNING);
                t.addShow(Dabang, Slot.AFTERNOON);
                t.addShow(Dabang, Slot.EVENING);
            }else{
                Theater t = theaterMap.get(s);
                t.addShow(pathan, Slot.MORNING);
                t.addShow(pathan, Slot.AFTERNOON);
                t.addShow(tiger3, Slot.EVENING);
            }
            i++;
            
        }

        

    }

    private void initializeTheaters(){
        Theater t1 = new Theater("SOUTHX", 1, "Kidwai Nagar");
        
        Theater t2 = new Theater("ZSQUARE", 2, "Bada Chauraha");
        Theater t3 = new Theater("Rave Moti", 3, "RTO Office");
        Theater t4 = new Theater("Rave 3", 4, "Panki");
        theaterMap.put("SOUTHX",t1);
        theaterMap.put("ZSQUARE",t2);
        theaterMap.put("Rave Moti",t3);
        theaterMap.put("Rave 3",t4);
        showTheaterMap.put("Tiger3",Arrays.asList(t2,t3,t4));
        
    }

    public void selectTheater(String theaterName){
        t = theaterMap.get(theaterName);
        Boolean gotTheater=true;
        for(Theater tname:  showTheaterMap.get(showName)){
            if(tname==t){
                gotTheater = false;
            }
        }
        if(gotTheater){
            System.out.println();
            System.out.println("This  theater doesn't contain the show please enter different theater");
            t = null;
        }
    }

    public void selectSeats(List<Integer> seats, Slot slot){
        if(t==null){
            System.out.println();
            System.out.println("Pleae select theater first then book tickets");
        }else{
            this.slot = slot;
            try{
                totalPrice = t.selectSeats(seats, slot,bookedSeats);
                if(totalPrice ==0){
                    throw new IOException("hey");
                }
            }catch(Exception e){
                System.out.println("Exception*** "+e.getMessage());
            }
            
        }
    }

    public void displayShows(String city){
        for(Show s: showCityMap.get(city)){
            System.out.println();
            System.out.println("Name = "+s.getName());
            System.out.println("Rating = "+s.getRating());
            System.out.println("Genre = "+s.getGenre());
            System.out.println("Actors = "+s.getActors());
            System.out.println("Rating = "+s.getTrending());
            System.out.println("Description = "+s.getDescription());
            
        }
    }

    public void seletShow(String name){
        this.showName = name;
        System.out.println();
        System.out.println("List of theaters where " + name+" is present");
        for(Theater t:showTheaterMap.get(name)){
            System.out.println();
            System.out.print(t.getName());
            System.out.println(" "+ t.getLocation());
            System.out.println(t.getSlot(name));
        }
    }

    public void bookTickets(List<Integer> bookTiclets,Slot slot){
        if(t==null){
            System.out.println();
            System.out.println("Pleae select theater first then book tickets");
        }else{
            
            this.slot = slot;
            System.out.println();
            System.out.println("***");
            System.out.println(this.slot);
            System.out.println();
            t.bookTickets(bookTiclets, slot);
        }
    }
    public void payAndGetTicket(User u){
        if(u.getCard().getMoney()<totalPrice){
            System.out.println("Insufficient balance! try again");
            return;
        }
        List<Seat> bookedOnes = new ArrayList<Seat>();
        if(totalPrice==0){
            System.out.println();
            System.out.println("Please select seats first then book");
            return;
        }else{
            for(Seat s: bookedSeats){
                if(s.getAvailable()==false){
                    System.out.println();
                    unbookSeats(bookedOnes);
                    System.out.println("Please select seats again as the one you selected is already booked");
                }else{
                    bookedOnes.add(s);
                    s.setAvailable(false);
                }

            }
            int totalMoney = u.getCard().getMoney();
            int remainingMoney = totalMoney-totalPrice;
            u.getCard().setMoney(remainingMoney);

            System.out.println();
            System.out.println("Debitted money!"+ "Money left = "+u.getCard().getMoney() + " your tickets are booked please see below");
            System.out.println();
            System.out.println("User "+u.getName()+" has booked "+ bookedSeats.size()+" tickets, please see ticket list below");
            for(Seat s:bookedOnes){
                System.out.println();
                System.out.println("Theater "+t.getName()+" sitauted at "+t.getLocation()+" Slot name "+slot+" seat number "+s.getNumber());
            }
            bookedOnes = new ArrayList<Seat>();
            bookedSeats = new ArrayList<Seat>();
        }
    }

    public void unbookSeats(List<Seat> bookedOnes){
        for(Seat s:bookedOnes){
            s.setAvailable(true);
        }
    }
    
    public Theater getTheater(String theaterName){
        if(theaterMap.containsKey(theaterName)){
            return theaterMap.get(theaterName);
        }
        return null;
    }



}
