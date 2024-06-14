import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("begin");
        System.out.println();
        
        User user = new User(1,"vishal7785@gmail.com","vishal7785","1234");
        AuthenticationStrategy authStrategy = new ManualAuth(user.getName(),user.getPassword());
        Controller controller = new Controller(authStrategy, user);
        controller.login();
        Tag tag = Tag.BFS;
        Tag tag1 = Tag.GREEDY;
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        tags.add(tag1);

        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DP);
        tags2.add(Tag.GREEDY);
        Problem easyProblem = new Problem("Easy-BFS", "Kuch bhi likh do", DIFFICULTY.EASY, 2, tags);

        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.BIT);

        Problem hardProblem = new Problem("Hard-DP","Fir se kuch bhi likh do",DIFFICULTY.HARD,5,tags2);

        Problem mediumProblem = new Problem("Medium-Bit","Fir se kuch bhi likh do na",DIFFICULTY.MEDIUM,3,tags2);

        List<Problem> problems = new ArrayList<>();

        problems.add(easyProblem);
        problems.add(hardProblem);
        Contest contest = new Contest(1, "9 bje", "1 ghanta", problems);
        contest.startContest();

        controller.addProblem(mediumProblem);
        controller.addContest(contest);

        Submission submission = new Submission(user, mediumProblem, SUBMISSIONSTATUS.SUCCESS, 5);
        controller.makeSubmission(submission);

        Submission submission2 = new Submission(user, easyProblem, SUBMISSIONSTATUS.SUCCESS, 2);
        controller.makeSubmissionToContest(submission2,1);
        controller.getLeader(contest);

        controller.registerContetst(contest);

        User user2 = new User(2, "str", "vishal", "1234");
        Controller controller2 = new Controller(authStrategy, user2);
        controller2.registerContetst(contest);
        Submission submission3 = new Submission(user2, hardProblem, SUBMISSIONSTATUS.SUCCESS, 3); 
        controller2.makeSubmissionToContest(submission3,1);

        Submission submission4 = new Submission(user, hardProblem, SUBMISSIONSTATUS.SUCCESS, 9);

        controller.makeSubmissionToContest(submission4,1);

        
        controller.getLeader(contest);

        Submission submission5 = new Submission(user2, mediumProblem, SUBMISSIONSTATUS.SUCCESS, 20);
        controller.makeSubmission(submission5);

        controller.getAvgTimeToSolve(mediumProblem);

        controller.getAllSuccessSubmissions();

        System.out.println();

        contest.completeContest();
        controller.getProblemsDifficultyBased(DIFFICULTY.EASY);



    }
}