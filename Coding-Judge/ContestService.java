import java.util.*;
public class ContestService {
    List<Contest> allContests;
    List<Contest> pastContests;
    List<Contest> currentContest;
    List<Contest> scheduedContests;

    private ContestService(){
        allContests = new ArrayList<>();
        pastContests = new ArrayList<>();
        currentContest = new ArrayList<>();
        scheduedContests = new ArrayList<>();
    }

    public static ContestService contesService= null;

    public static ContestService getInstance(){
        if(contesService == null){
            contesService = new ContestService();
        }
        return contesService;
    }

    public Contest getContest(int id){
        for(Contest contest: allContests){
            if(contest.getID() == id){
                return contest;
            }
        }
        return null;
    }
    public void addContest(Contest contest){
        allContests.add(contest);
        scheduedContests.add(contest);
    }

    public void addRunningContest(Contest contest){
        currentContest.add(contest);
        scheduedContests.remove(contest);
    }

    public void completeContest(Contest contest){
        pastContests.add(contest);
        currentContest.remove(contest);
    }

    public List<Contest> getAllContests(){
        return allContests;
    }

    public List<Contest> getPastContests(){
        return pastContests;
    }

    public List<Contest> getCurrentContests(){
        return currentContest;
    }

    public List<Contest> getScheduledContests(){
        return scheduedContests;
    }
}
