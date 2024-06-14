import java.util.*;
public class Problem {
    String name;
    String description;
    DIFFICULTY difficulty;
    int score;
    List<Tag> tags;
    ProblemMetric problemMetric;


    public Problem(String name,String description, DIFFICULTY difficulty, int score, List<Tag> tags){
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.score = score;
        this.tags = tags;
        problemMetric =  new ProblemMetric(this);
    }

    public List<Tag> getTags(){
        return tags;
    }

    public int getScore(){
        return score;
    }

    public DIFFICULTY getDifficulty(){
        return difficulty;
    }

    public String getName(){
        return name;
    }
}
