public class Player {
    String name;
    int score;
    int matchScore;

    public Player(String name){
        this.name = name;
        score = 0;
        matchScore = 0;
    }

    public String getName(){
        return name;
    }

    public int getTotalSore(){
        return score;
    }

    public int getMatchScore(){
        return matchScore;
    }

    public void setMatchScore(int matchScore){
        this.matchScore = matchScore;
    }

    public void setTotalScore(int totalScore){
        this.score = totalScore;
    }
}
