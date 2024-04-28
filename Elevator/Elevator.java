import java.util.*;


public class Elevator {
    Direction dir;
    PriorityQueue<Request> pQueueMin;
    PriorityQueue<Request> pQueueMax;
    int currentFloor;

    public Elevator(){
        dir = Direction.IDLE;
        pQueueMin = new PriorityQueue<Request>(new RequestComparatorMin());
        pQueueMax = new PriorityQueue<Request>( new RequestComparator());
    }

    void processRequest(){
        processUpwardRequests();
        processDownwardRequests();
    }
    void processUpwardRequests(){
        while(pQueueMax.isEmpty() == false){
            Request cur;
            cur = pQueueMax.poll();
            int destination_floor = cur.getFloor();
            if(cur.geLocation()==Location.INSIDE){
                System.err.println("Going Upward to "+ destination_floor+" floor to drop");
                currentFloor = destination_floor;
            }else{
                System.err.println("Going Upward to "+ destination_floor+" floor to pick");
                currentFloor = destination_floor;
            }
        }
        if(pQueueMin.isEmpty()){
            dir = Direction.IDLE;
        }else{
            dir = Direction.DOWNWARD;
        }
        

    }
    void processDownwardRequests(){
        while(pQueueMin.isEmpty() == false){
            Request cur;
            cur = pQueueMin.poll();
            int destination_floor = cur.getFloor();
            if(cur.geLocation()==Location.INSIDE){
                System.err.println("Going Downward to "+ destination_floor+" floor to drop");
                currentFloor = destination_floor;
            }else{
                System.err.println("Going Downward to "+ destination_floor+" floor to pick");
                currentFloor = destination_floor;
            }
        }
        if(pQueueMax.isEmpty()){
            dir = Direction.IDLE;
        }else{
            dir = Direction.DOWNWARD;
        }
    }

    void addRequest(Request req){
        Direction direction = req.geDirection();
        if(direction == Direction.UPWARD){
            pQueueMax.add(req);
        }else{
            pQueueMin.add(req);
        }
    }

}
