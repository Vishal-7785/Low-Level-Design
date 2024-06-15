import java.util.*;
public class Team {
    String name;
    Deque<Player> players;
    Deque<Player> bowlers;

    public Team(String name, Deque<Player> players,Deque<Player> bowlers){
        this.name = name;
        this.bowlers = bowlers;
        this.players = players;
    }

    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Deque<Player> getPlayers(){
        return players;
    }

    public Deque<Player> getBowlers(){
        return bowlers;
    }
}
