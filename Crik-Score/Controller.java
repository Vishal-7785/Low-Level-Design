import java.util.*;
public class Controller {

    public Controller(){
        System.out.println("Controller Initialized");
        System.out.println();
    }

    public void start(){
        Team teamA = createTeamIndia();
        Team teamB = createTeamAustralia();

        Match match = new Match(teamA, teamB, 1);
        match.startMatch();

    }

    public Team createTeamIndia(){

        Deque<Player> indianPlayers = getIndiaPlayers();
        Deque<Player> indianbBowlers = getIndiaBowlers();

        Team teamindia = new Team("India",indianPlayers,indianbBowlers);
        return teamindia;
    }

    public Team createTeamAustralia(){

        Deque<Player> autralianPlayers = getAustraliaPlayers();
        Deque<Player> autralianBowlers = getAustraliaBowlers();
        Team teamAustralia = new Team("Australia",autralianPlayers,autralianBowlers);
        return teamAustralia;
    }

    public Deque<Player> getIndiaPlayers(){
        Deque<Player> players = new ArrayDeque<>();

        Player player1 = new Player("Rohit");
        Player player2 = new Player("Yashashvi");
        Player player3 = new Player("Virat");
        Player player4 = new Player("Shivam");
        Player player5 = new Player("Iyer");
        Player player6 = new Player("Pandya");
        Player player7 = new Player("Jadeja");
        Player player8 = new Player("Bumrah");
        Player player9 = new Player("Unadkat");
        Player player10 = new Player("Ashwin");
        Player player11 = new Player("Siraj");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);
        players.add(player11);

        return players;

    }

    public Deque<Player> getIndiaBowlers(){

        Deque<Player> players = new ArrayDeque<>();


        Player player7 = new Player("Jadeja");
        Player player8 = new Player("Bumrah");
        Player player9 = new Player("Unadkat");
        Player player10 = new Player("Ashwin");
        Player player11 = new Player("Siraj");

        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);
        players.add(player11);

        return players;
    }

    public Deque<Player> getAustraliaPlayers(){
        Deque<Player> players = new ArrayDeque<>();

        Player player1 = new Player("Warner");
        Player player2 = new Player("Head");
        Player player3 = new Player("Watson");
        Player player4 = new Player("Smith");
        Player player5 = new Player("Balley");
        Player player6 = new Player("Ponting");
        Player player7 = new Player("Warne");
        Player player8 = new Player("Lyon");
        Player player9 = new Player("Bret-Lee");
        Player player10 = new Player("Hazlewood");
        Player player11 = new Player("Start");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);
        players.add(player11);

        return players;
    }

    public Deque<Player> getAustraliaBowlers(){

        Deque<Player> players = new ArrayDeque<>();

        Player player7 = new Player("Warne");
        Player player8 = new Player("Lyon");
        Player player9 = new Player("Bret-Lee");
        Player player10 = new Player("Hazlewood");
        Player player11 = new Player("Start");

        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);
        players.add(player11);

        return players;
    }
}
