public class Match {
    Inning firstInning;
    Inning secondInning;
    int matchID;
    Team teamA;
    Team teamB;

    public Match(Team teamA, Team teamB,int matchID){
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchID = matchID;
        fillInningData();
    }

    public void fillInningData(){
        InningData inningDataA = new InningData(matchID, teamA.getPlayers(), teamB.getBowlers());
        InningData inningDataB = new InningData(matchID, teamB.getPlayers(), teamA.getBowlers());

        firstInning = new Inning(teamA.getName(), MATCHTYPE.ODI, inningDataA);
        secondInning = new Inning(teamB.getName(), MATCHTYPE.ODI, inningDataB);
    }

    public void startMatch(){
        System.out.printf("Going to have toss betweeen team %s and team %s",teamA.getName(),teamB.getName());
        if(doToss()==true){
            int firstInningScore = firstInning.start(20000);

            System.out.printf("First inning finished team %s has score %d runs, team %s needs %d runs to win",teamA.getName(),firstInningScore,teamB.getName(),firstInningScore+1);
            System.out.println();
            System.out.println();

            int secondInningScore  = secondInning.start(firstInningScore);

            if(secondInningScore>=firstInningScore){
                System.out.printf("Team %s has won the match by %d wickets",teamB.getName(),secondInning.getInningData().getWinningWickets());
                System.out.println();
                System.out.println();
            }else{
                System.out.printf("Team %s has won the match by %d runs",teamA.getName(),firstInningScore-secondInning.getInningData().getScore());
                System.out.println();
                System.out.println();
            }
        }else{
            int firstInningScore = secondInning.start(20000);

            System.out.printf("First inning finished team %s has score %d runs, team%s needs %d runs to win",teamB.getName(),firstInningScore,teamA.getName(),firstInningScore+1);
            System.out.println();
            System.out.println();

            int secondInningScore  = firstInning.start(firstInningScore);

            if(secondInningScore>=firstInningScore){
                System.out.printf("Team %s has won the match by %d wickets",teamA.getName(),firstInning.getInningData().getWinningWickets());
                System.out.println();
                System.out.println();
            }else{
                System.out.printf("Team %s has won the match by %d runs",teamB.getName(),firstInningScore-firstInning.getInningData().getScore());
                System.out.println();
                System.out.println();
            }
        }

    }

    public boolean doToss(){
        int rand = (int) (Math.random() * 2);
        if(rand%2==0){
            System.out.printf("Team %s has won the toss and elected to bat first",teamA.getName());
            System.out.println();
            System.out.println();
            return true;
        }else{
            System.out.printf("Team %s has won the toss and elected to bat first",teamB.getName());
            System.out.println();
            System.out.println();
        }
        return false;
    }
}
