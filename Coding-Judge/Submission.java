public class Submission {
    
    User user;
    Problem problem;
    SUBMISSIONSTATUS submissionstatus;
    int timeTaken;

    public Submission(User user, Problem problem, SUBMISSIONSTATUS submissionstatus,int timeTaken){
        this.user = user;
        this.problem = problem;
        this.submissionstatus = submissionstatus;
        this.timeTaken = timeTaken;
    }

    public User getUser(){
        return user;
    }

    public Problem getProblem(){
        return problem;
    }

    public SUBMISSIONSTATUS geSubmissionstatus(){
        return submissionstatus;
    }

    public int getTimeTakeToSolve(){
        return timeTaken;
    }

}
