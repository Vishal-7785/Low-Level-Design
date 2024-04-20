import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class Game {
    Deque<Player> playerList;
    int[] row,col;
    int dia,diaReverse;
    Board board;
    Player winner;
    Boolean isOver;
    int number;
    public Game(int n){
        row = new int[n];
        col = new int[n];
        winner = null;
        this.number = n;
        isOver = false;
        board = new Board(n);
        playerList = new LinkedList<>();
        initializePlayers();
    }
    private void initializePlayers(){
        Player p1 = new Player(new Piece("X",1), "Vishal", 1, 5,90.00);
        Player p2 = new Player(new Piece("O",-1), "Shanu", 2, 8,98.00);
        playerList.add(p1);
        playerList.add(p2);
    }

    public void Play(){
        Scanner s = new Scanner(System.in);
        int count = 0;
        while(!isOver && count<number*number){
            Player p1 = playerList.getFirst();
            playerList.removeFirst();
            board.show();
            System.out.println("Player "+p1.name+" want to add sign please enter row and column where you want to add");
            System.out.println();
            int i = -1,j=-1;
            while(i<0 || i>=number || j<0 || j>=number || board.board[i][j]!=0){
                i = s.nextInt();
                j = s.nextInt();
                System.out.println();
                if(i<0 || i>=number || j<0 || j>=number){
                    System.out.println("Index out of range please enter again");
                    System.out.println();
                }else if( board.board[i][j]!=0){
                    System.out.println("Value Already Filled Enter Again");
                    System.out.println();
                }
            }
            board.board[i][j] = p1.piece.getValue();
            fillAndCheck(i,j,p1.piece.getValue(),p1);
            playerList.addLast(p1);
            count++;
            
        }
        s.close();

        if(winner==null){
            System.out.println("Game Draw");
        }else{
            System.out.println("Winner of the game is "+winner.name);
            board.show();
        }
    }
    public void fillAndCheck(int i, int j,int value,Player p1){
        row[i]+= value;
        col[j]+= value;
        if(i==j){
            dia+= value;
        }
        if(i+j==number-1){
            diaReverse+= value;
        }
        if(row[i]==number || col[j]==number || dia == number || diaReverse == number){
            winner = p1;
            isOver = true;
        }

    }

    
}
