package SystemDesign.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    public Deque<Player> players;
    public Dice d;
    public GameBoard gameBoard;
    public Game(){
        players = new LinkedList<>();
        initializeGameBoard();
    }
    public void initializeGameBoard(){
        d = new Dice(1);
        gameBoard = new GameBoard();
        initializePlayers();
    }
    public void initializePlayers(){
        Player p1 = new Player("Vishal", 1);
        Player p2 = new Player("Himanshi", 2);
        players.add(p1);
        players.add(p2);
    }
    Boolean winner = false;
    public void play(){
        while(!winner){
            Player currPlayer = players.getFirst();
            players.removeFirst();
            int src = currPlayer.position;
            Cell oldPosition = gameBoard.getCell(src);
            int diceNumber = d.rollDice();
            int newP = src+diceNumber;
            if(newP>=100){
                winner = true;
                System.out.println("Winner is "+currPlayer.name);
                continue;
            }
            Cell newPosition = gameBoard.getCell(newP);
            
            if(newPosition==oldPosition){
                System.out.println("Current player "+currPlayer.name+" moves from "+src+" to "+newP);
                currPlayer.position = newP;
            }else{
                int newSrc = newPosition.dst;
                if(newSrc>newP){
                    System.out.println(currPlayer.name+" took a ladder from "+newP+ " to "+newSrc);
                }else{
                    System.out.println(currPlayer.name+" got bitten by snake from "+newP+ " to "+newSrc);
                }
                currPlayer.position = newP;
            }
            players.addLast(currPlayer);

        }
    }
}
