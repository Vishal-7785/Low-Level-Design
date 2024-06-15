import java.util.ArrayList;
import java.util.List;

public class Inning {
    InningData inningData;
    String teamName;
    int target;
    MATCHTYPE matchtype;
    List<Over> overs;
    int numberOfOvers;
    Ball ball;
    Player bowler;
    Player striker;
    boolean winner = false;
    boolean inningOver = false;
    public Inning(String teamName, MATCHTYPE matchtype, InningData inningData){
        this.teamName = teamName;
        this.matchtype = matchtype;
        this.inningData = inningData;
        overs = new ArrayList<>();
        ball = new Ball();
        updateOvers(matchtype);
    }

    private void updateOvers(MATCHTYPE matchtype){
        if(matchtype == MATCHTYPE.ODI){
            numberOfOvers = 2;
        }else if(matchtype == MATCHTYPE.TWENTY){
            numberOfOvers = 1;
        }else{
            numberOfOvers = 5;
        }
    }

    public int  start(int target){
        this.target = target;
        for(int i=0;i<numberOfOvers;i++){
            bowler = inningData.getBowler();
            startOver(bowler,i);
            if(inningOver){
                break;
            }
        }
        if(winner)return inningData.getScore();
        System.out.printf("Inning end for team %s",teamName);
        System.out.println();
        System.out.println();
        return inningData.getScore();
    }

    public void startOver(Player bowler,int number){
        Over over = new Over(number+1,bowler);
        striker = inningData.getStriker();
        System.out.printf("Over %d will be bowled by %s , bastman on strike %s",number+1,bowler.getName(),striker.getName());
        System.out.println();
        System.out.println();

        int i = 0;

        while(i<6){
            BALLTYPE balltype = deliverBall();
            System.out.printf("Ball no = %d , bowler = %s , batter = %s gets a %s", i+1,bowler.getName(),inningData.getStriker().getName(),balltype);
            System.out.println();
            over.addBall(balltype);
            updateScore(balltype);
            if(inningData.getScore()>=target){
                System.out.printf("Team %s has won the match ",teamName);
                System.out.println();
                System.out.println();
                winner = true;
                inningOver = true;
                overs.add(over);
                return;
            }
            if(inningOver){
                overs.add(over);
                return;
            }
            if(balltype== BALLTYPE.NO || balltype == BALLTYPE.WIDE){
                continue;
            }
            i++;
        }
        overs.add(over);
        System.out.printf("Over finished, team score is %d and total wickets = %d",inningData.getScore() ,inningData.getWickets());
        System.out.println();
        System.out.println();
        inningData.strikeChange();
    }

    private BALLTYPE deliverBall(){
        BALLTYPE ballType = ball.deliveringBall();
        return ballType;
    }

    private void updateScore(BALLTYPE balltype){
        switch(balltype){
            case BALLTYPE.SINGLE:
                striker.setMatchScore(striker.getMatchScore()+1);
                striker = inningData.strikeChange();
                inningData.addScore(1);
                break;

            case BALLTYPE.DOUBLE:
                striker.setMatchScore(striker.getMatchScore()+2);
                inningData.addScore(2);
                break;

            case BALLTYPE.FOUR:
                striker.setMatchScore(striker.getMatchScore()+4);
                inningData.addScore(4);
                break;

            case BALLTYPE.SIX:
                striker.setMatchScore(striker.getMatchScore()+6);
                inningData.addScore(6);
                break;

            case BALLTYPE.WIDE:
                inningData.addScore(1);
                break;

            case BALLTYPE.NO:
                inningData.addScore(1);
                break;

            case BALLTYPE.WICKET:
                striker = inningData.wicket();
                if(striker == null){
                    inningOver = true;
                }
                break;

            default:
                break;

        }
    }

    public InningData getInningData(){
        return inningData;
    }
}
