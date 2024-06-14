public class User {
    int id;
    String name;
    String phone;
    String email;
    String password;
    int contestScore;
    int score;
    public User(int id,String email,String name,String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.score = 0;
        this.contestScore = 0;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setContestScore(int score){
        this.contestScore = score;
    }

    public int getContestScore(){
        return contestScore;
    }

    public String getPassword(){
        return password;
    }
}