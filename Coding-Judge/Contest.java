import java.util.*;
public class Contest {
    int id;
    String time;
    String duration;
    List<Problem> problems;
    User leader;
    CONTESTSTATUS contestStatus;
    List<User> registeredUsers;
    ContestService contestService;
    ProblemService problemService;

    public Contest(int id, String time, String duration, List<Problem> problems){
        this.id = id;
        this.time = time;
        this.duration = duration;
        this.problems = problems;
        this.contestStatus = CONTESTSTATUS.SCHEDULED;
        this.leader = null;
        this.registeredUsers = new ArrayList<>();
        contestService = ContestService.getInstance();
        contestService.addContest(this);
        problemService = ProblemService.getInstance();
    }

    public String getTime(){
        return time;
    }

    public int getID(){
        return id;
    }

    public void registerUser(User user){
        user.setContestScore(0);
        registeredUsers.add(user);
    }

    public void removeUser(User user){
        registeredUsers.remove(user);
    }

    public User getLeader(){
        return leader;
    }

    public void setLeader(User user){
        this.leader = user;
    }

    public CONTESTSTATUS getContestStatus(){
        return contestStatus;
    }

    public List<Problem> getAllProblems(){
        return problems;
    }

    public List<Problem> getProblemsByDifficulty(DIFFICULTY difficulty){
        List<Problem> problemList = new ArrayList<>();
        for(Problem problem: problemList){
            if(problem.getDifficulty() == difficulty){
                problemList.add(problem);
            }
        }
        return problemList;
    }

    public void startContest(){
        contestStatus = CONTESTSTATUS.RUNNING;
        contestService.addRunningContest(this);
    }

    public void completeContest(){
        contestStatus = CONTESTSTATUS.COMPLETED;
        contestService.completeContest(this);
        problemService.addProblems(problems);
    }

    public int getLeaderScore(){
        if(leader==null)return 0;

        return leader.getContestScore();
    }
}
