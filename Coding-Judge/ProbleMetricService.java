import java.util.*;
public class ProbleMetricService {
    HashMap<Problem,ProblemMetric> metricMap;

    private ProbleMetricService(){
        metricMap = new HashMap<>();
    }

    public static ProbleMetricService probleMetricService = null;

    public static ProbleMetricService getInstance(){
        if(probleMetricService == null){
            probleMetricService = new ProbleMetricService();
        }
        return probleMetricService;
    }

    public ProblemMetric getMetric(Problem problem){
        if(metricMap.containsKey(problem)){
            return metricMap.get(problem);
        }
        System.out.println("Problem doesn't exist");
        System.out.println();
        return null;
    }

    public void updateMetric(Problem problem,User user,int timeToSolve){
        if(metricMap.containsKey(problem)){
            System.out.println("Updating metric of problem");
            System.out.println();
            ProblemMetric problemMetric = metricMap.get(problem);
            problemMetric.updateMetric(user,timeToSolve);
            metricMap.put(problem,problemMetric);

        }else{
            System.out.println("Problem doesn't exist");
            System.out.println();
        }
    }

    public void addMetric(Problem problem,ProblemMetric problemMetric){
        metricMap.put(problem, problemMetric);
    }
}
