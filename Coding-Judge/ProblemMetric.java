import java.util.*;
public class ProblemMetric {
    Problem problem;
    int likesCount;
    int avgTimeToSolve;
    List<User> userSolved;
    ProbleMetricService probleMetricService;

    public ProblemMetric(Problem problem){
        this.problem = problem;
        likesCount = 0;
        avgTimeToSolve = 0;
        userSolved = new ArrayList<>();
        probleMetricService = ProbleMetricService.getInstance();
        probleMetricService.addMetric(problem,this);

    }

    public void updateMetric(User user, int timeToSolve){
        userSolved.add(user);
        avgTimeToSolve = (avgTimeToSolve+timeToSolve)/(userSolved.size());
    }

    public void Like(){
        likesCount+=1;
    }

    public void disLike(){
        likesCount-=1;
    }

    public int getAvgTimeToSolve(){
        return avgTimeToSolve;
    }

    public int getLikes(){
        return likesCount;
    }

}
