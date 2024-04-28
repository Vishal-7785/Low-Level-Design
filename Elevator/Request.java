

public class Request {
    Location loc;
    int destination_floor;
    Direction dir;

    public Request(Location loc,int destination_floor,Direction dir){
        this.loc = loc;
        this.destination_floor = destination_floor;
        this.dir = dir;
    }
    Location geLocation(){
        return loc;
    }
    Direction geDirection(){
        return dir;
    }
    int getFloor(){
        return destination_floor;
    }
}
