import java.util.*;
public class Controller {
    AuthenticationStrategy strategy;
    boolean isLoggedIn;
    ProblemService problemService;
    ContestService contestService;
    SubmissionService submissionService;
    ProbleMetricService probleMetricService;
    User user;
    public Controller(AuthenticationStrategy strategy,User user){
        this.strategy = strategy;
        this.isLoggedIn = false;
        this.problemService = ProblemService.getInstance();
        this.contestService = ContestService.getInstance();
        this.user = user;
        this.submissionService = SubmissionService.getInstance();
        probleMetricService = ProbleMetricService.getInstance();
    }

    public void login(){
        System.out.printf("Doing authentication for user %s", user.getName());
        System.out.println();
        System.out.println();
        boolean b = strategy.login();
        isLoggedIn = b;
    }

    public void addProblem(Problem problem){
        System.out.printf("Adding problem with name = %s and score = %d to problem service",problem.getName(),problem.getScore());
        System.out.println();
        System.out.println();
        problemService.addProblem(problem);
    }

    public void addContest(Contest contest){
        System.out.printf("Adding contest scheduled at %s ",contest.getTime());
        System.out.println();
        System.out.println();
        contestService.addContest(contest);
    }

    public void startContest(Contest contest){
        System.out.println("Contest started");
        System.out.println();
        contest.startContest();
    }

    public void completeContest(Contest contest){
        System.out.println("Contest finished");
        System.out.println();
        contest.completeContest();
    }

    public void getLeader(Contest contest){
        User user = contest.getLeader();
        System.out.printf("Contest leader is %s",user.getName());
        System.out.println();
        System.out.println();
    }

    public void makeSubmission(Submission submission){
        System.out.printf("Making submission for problem = %s , user who is submitting = %s",submission.getProblem().getName(),user.getName());
        System.out.println();
        System.out.println();
        submissionService.addSubmission(user,submission);
    }

    public void makeSubmissionToContest(Submission submission, int contest){
        System.out.printf("Making submission to contest for problem = %s , user who is submitting = %s",submission.getProblem().getName(),user.getName());
        System.out.println();
        System.out.println();
        submissionService.addSubmissionForContest(user,submission,contest);
    }

    public void getAllSuccessSubmissions(){
        System.out.println("Fetching all successfull submissions");
        System.out.println();
        List<Submission> submissions;
        submissions = submissionService.getAllSuccessSubmission(user);
        submissionService.printSubmissions(submissions);
    }

    public void getProblemsDifficultyBased(DIFFICULTY difficulty){
        System.out.printf("Fetching all of %s difficulty",difficulty);
        System.out.println();
        System.out.println();
        List<Problem> problems;
        problems = problemService.getProblemOnDifficulty(difficulty);
        problemService.printProblems(problems);
    }

    public void registerContetst(Contest contest){
        System.out.printf("Registering user %s for the contest starting at %s",user.getName(),contest.getTime());
        System.out.println();
        System.out.println();
        contest.registerUser(user);
    }

    public void getAvgTimeToSolve(Problem problem){
        ProblemMetric problemMetric = probleMetricService.getMetric(problem);
        System.out.printf("Avg time to solve problem with name = %s is %d",problem.getName(),problemMetric.getAvgTimeToSolve()); 
        System.out.println();
        System.out.println();
    }

}
