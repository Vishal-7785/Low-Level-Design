import java.util.*;
public class Screen {
    Seat [][]seats;
    Show show;
    Slot slot;

    public Screen(Show show, Slot slot){
        seats = new Seat[10][10];
        for(int i=0;i<10;i++){
            for(int j = 0;j<10;j++){
                seats[i][j] = new Seat(true,i*10+j,200);
             }
        }
        this.show = show;
        this.slot = slot;
    }


    public Show getShow(){
        return show;
    }

    public Slot getSlot(){
        return slot;
    }
    public Seat[][] getSeats(){
        return seats;
    }

    public int selectSeats(List<Integer> numbers,List<Seat> bookedSeats){
        int price = 0;
        for(Integer i:numbers){
            Seat seat = getSeat(i);
            if(seat.getAvailable()){
                price+= seat.getPrice();
                bookedSeats.add(seat);
            }else{
                bookedSeats = new ArrayList<Seat>(); 
                System.out.println();
                System.out.println("Selected Seat "+i+" is not available, Please select seats again");
               return 0;
            }
        }
        return price;
    }

    public int bookSeats(List<Integer> numbers,List<Seat> bookedSeats){
        int price = 0;
        for(Integer i:numbers){
            Seat seat = getSeat(i);
            if(seat.getAvailable()){
                seat.setAvailable(false);
                price+= seat.getPrice();
                bookedSeats.add(seat);
            }else{
                for(Seat s: bookedSeats){
                    int seatNumber = s.getNumber();
                    setAvailable(seatNumber);
                }
                bookedSeats = new ArrayList<Seat>();
                System.out.println();
                System.out.println("Selected Seat "+i+" is not available, Please select seats again");

               return 0;
            }
        }
        System.out.println();
        System.out.println("Selected seats have total price "+ price+ "Please pay to confirm booking");
        return price;
    }

    public void setAvailable(int i){
        int p = 0;
        int y = 0;
        int x = 0;
        if(i%10==0){
            y = 9;
            x = i/10;
            if(i!=0){
                x-=1;
            }
        }else{
            x = i/10-p;
            y = i%10-1;
        }
        seats[x][y].setAvailable(true);

    }
    public Seat getSeat(Integer i){
        int p = 0;
        int y = 0;
        int x = 0;
        if(i%10==0){
            y = 9;
            x = i/10;
            if(i!=0){
                x-=1;
            }
        }else{
            x = i/10-p;
            y = i%10-1;
        }

        return seats[x][y];
    }
}
