import java.util.*;
public class InningData {
    int matchId;
    int totalScore;
    Deque<Player> batters;
    Deque<Player> bowlers;
    Player striker;
    Player nonStriker;
    Player bowler;
    int totalBatsman;
    int batsmanPlayed;

    public InningData(int matchId,Deque<Player> batters,Deque<Player> bowlers){
        this.matchId = matchId;
        this.totalScore = 0;
        this.batters = batters;
        this.bowlers = bowlers;
        this.totalBatsman = batters.size();
        striker = batters.removeFirst();
        nonStriker = batters.removeFirst();
        batters.addLast(striker);
        batters.addLast(nonStriker);
        batsmanPlayed = 2;
    }
    public Player getBowler(){
        Player player = bowlers.removeFirst();
        bowlers.addLast(player);
        return player;
    }

    public Player getStriker(){
        return striker;
    }

    public Player strikeChange(){
        Player dummy = nonStriker;
        nonStriker = striker;
        striker = dummy;
        return striker;
    }

    public Player wicket(){
        if(batsmanPlayed == totalBatsman){
            return null;
        }
        striker = batters.removeFirst();
        batters.addLast(striker);
        batsmanPlayed++;
        return striker;
    }
    
    public void addScore(int score){
        totalScore+=score;
    }

    public int getScore(){
        return totalScore;
    }

    public int getWinningWickets(){
        return totalBatsman-batsmanPlayed;
    }

    public int getWickets(){
        return batsmanPlayed-2;
    }
}
