public class Player {
    public Piece piece;
    public String name;
    public int id;
    public int numberOfMatches;
    public double winPercentage;

    public Player(Piece p, String name, int id, int numberOfMatches, double winPercentage){
        this.piece = p;
        this.name = name;
        this.id = id;
        this.numberOfMatches = numberOfMatches;
        this.winPercentage = winPercentage;
    }
    
}
