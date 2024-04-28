import java.util.*;
public class RequestComparatorMin implements Comparator<Request>{
             
    // Overriding compare()method of Comparator 
                // for descending order of cgpa
    public int compare(Request s1, Request s2) {
        if (s1.getFloor() > s2.getFloor())
            return -1;
        else if (s1.getFloor() < s2.getFloor())
            return 1;
                        return 0;
        }
}