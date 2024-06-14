import java.util.*;
public class ProblemService {
    List<Problem> allProblems;
    HashMap<Tag,List<Problem>> tagProblemMap;
    HashMap<DIFFICULTY,List<Problem>> difficultyMap;

    private ProblemService(){
        allProblems = new ArrayList<>();
        tagProblemMap = new HashMap<>();
        difficultyMap = new HashMap<>();
    }

    public static ProblemService problemService = null;
    public static ProblemService getInstance(){
        if(problemService == null){
            problemService = new ProblemService();
        }
        return problemService;
    }

    public void addProblem(Problem problem){
        allProblems.add(problem);
        addDifficulty(problem,problem.getDifficulty());
        addTags(problem,problem.getTags());
    }

    public void addProblems(List<Problem> problems){
        for(Problem problem: problems){
            addProblem(problem);
        }
    }

    public void addDifficulty(Problem problem, DIFFICULTY diff){
        List<Problem> pr = new ArrayList<>();
        if(difficultyMap.containsKey(diff)){
            pr = difficultyMap.get(diff);
        }
        pr.add(problem);
        difficultyMap.put(diff, pr);
    }

    public void addTags(Problem problem, List<Tag> tags){
        for(Tag tag:tags){
            addTag(problem,tag);
        }
    }

    public void addTag(Problem problem, Tag tag){
        List<Problem> pr = new ArrayList<>();
        if(tagProblemMap.containsKey(tag)){
            pr = tagProblemMap.get(tag);
        }
        pr.add(problem);
        tagProblemMap.put(tag,pr);
    }

    public List<Problem> getAllProblems(){
        return allProblems;
    }

    public List<Problem> getProblemOnDifficulty(DIFFICULTY difficulty){
        int c = 0;
        List<Problem> problems= new ArrayList<>();
        if(difficultyMap.containsKey(difficulty)){

            for(Problem problem: difficultyMap.get(difficulty)){
                problems.add(problem);
                c++;
                if(c==5)break;
            }
        }
        return problems;
    }

    public List<Problem> getProblemOnTag(Tag tag){
        int c = 0;
        List<Problem> problems= new ArrayList<>();
        if(tagProblemMap.containsKey(tag)){
            for(Problem problem: tagProblemMap.get(tag)){
                problems.add(problem);
                c++;
                if(c==5)break;
            }
        }
        return problems;
    }

    public List<Problem> getRelevantProblems(Problem problem){
        int c = 5;
        List<Problem> result= new ArrayList<>();
        List<Tag> problemTags = problem.getTags();
        for(Tag tag: problemTags){
            int u = 2;
            for(Problem pro: tagProblemMap.get(tag)){
                result.add(pro);
                u++;
                c++;
                if(u==2)break;
            }
            if(c==5)break;
        }
        return result;
    }

    public void printProblems(List<Problem> problems){
        if(problems.size()==0){
            System.out.println("No problem to show");
            System.out.println();
            return;
        }
        for(Problem problem: problems){
            System.out.printf("Problem name =  %s problem score = %d",problem.getName(),problem.getScore());
            System.out.println();
        }
        System.out.println();
    }
}
