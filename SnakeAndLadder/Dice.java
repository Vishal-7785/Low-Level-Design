package SystemDesign.SnakeAndLadder;

public class Dice {
    public int number;
    public Dice(int number){
        this.number = number;
    }
    public int rollDice(){
        int num = 6*number;
        int s = (int)(Math.random()*num);
        return s;
    }
}
