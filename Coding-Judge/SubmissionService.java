import java.util.*;
public class SubmissionService {
    List<Submission> submissionList;
    HashMap<User,List<Submission>> submissionUserMap;
    ProbleMetricService probleMetricService;
    ContestService contestService;

    private SubmissionService(){
        submissionList = new ArrayList<>();
        submissionUserMap = new HashMap<>();
        probleMetricService = ProbleMetricService.getInstance();
        contestService = ContestService.getInstance();
    }

    public static SubmissionService submissionService = null;
    public static SubmissionService getInstance(){
        if(submissionService == null){
            submissionService = new SubmissionService();
        }
        return submissionService;
    }

    public void addSubmission(User user,Submission submission){
        List<Submission> addList = new ArrayList<>();
        if(submissionUserMap.containsKey(user)){
            addList = submissionUserMap.get(user);
        }
        addList.add(submission);
        submissionUserMap.put(user,addList);
        submissionList.add(submission);

        if(submission.geSubmissionstatus() == SUBMISSIONSTATUS.SUCCESS){
            user.setScore(user.getScore()+submission.getProblem().getScore());
            probleMetricService.updateMetric(submission.getProblem(), user, submission.getTimeTakeToSolve());
        }
    }

    public void addSubmissionForContest(User user,Submission submission,int contestID){
        addSubmission(user,submission);
        Contest contest = contestService.getContest(contestID);
        if(contest.getLeaderScore() <user.getScore()){
            contest.setLeader(user);
        }
    }

    public List<Submission> getAllSubmissions(){
        return submissionList;
    }

    public List<Submission> getAllSubmission(User user){
        List<Submission> userSubmission = new ArrayList<>();
        if(submissionUserMap.containsKey(user)){
            List<Submission> allSubs = submissionUserMap.get(user);
            for(Submission submission:allSubs){
                userSubmission.add(submission);
            }
        }
        return userSubmission;
    }

    public List<Submission> getAllSuccessSubmission(User user){
        List<Submission> sucSubs = new ArrayList<>();
        if(submissionUserMap.containsKey(user)){
            List<Submission> allSubs = submissionUserMap.get(user);
            for(Submission submission:allSubs){
                if(submission.geSubmissionstatus() == SUBMISSIONSTATUS.SUCCESS){
                    sucSubs.add(submission);
                }
            }
        }
        return sucSubs;
    }

    public List<Submission> getAllFailedSubmission(User user){
        List<Submission> failSubs = new ArrayList<>();
        if(submissionUserMap.containsKey(user)){
            List<Submission> allSubs = submissionUserMap.get(user);
            for(Submission submission:allSubs){
                if(submission.geSubmissionstatus() == SUBMISSIONSTATUS.FAILED){
                    failSubs.add(submission);
                }
            }
        }
        return failSubs;
    }

    public void printSubmissions(List<Submission> submissions){
        if(submissions.size()==0){
            System.out.println("No successful submission made by you");
            System.out.println();
            return;
        }
        for(Submission submission: submissions){
            System.out.printf("Problem score = %d time taken = %d solved by user %s",submission.getProblem().getScore(),submission.getTimeTakeToSolve(),submission.getUser().getName());
            System.out.println();
        }
        System.out.println();
    }
}
