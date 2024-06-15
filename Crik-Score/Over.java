import java.util.*;
public class Over {
    List<BALLTYPE> balls;
    int number;
    Player bowledBy;

    public Over(int number, Player bowledBy){
        this.number = number;
        this.bowledBy = bowledBy;
        balls = new ArrayList<>();
    }

    public void addBall(BALLTYPE ball){
        balls.add(ball);
    }

    public List<BALLTYPE> getBalls(){
        return balls;
    }

    public Player getBowlerName(){
        return bowledBy;
    }


}
