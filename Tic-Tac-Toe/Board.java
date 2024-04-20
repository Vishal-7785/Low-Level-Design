public class Board {
    public int board[][];
    int n;
    public Board(int n){
        this.n = n;
        board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 0;
            }
        }
    }
    public void show(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                switch(board[i][j]){
                    case 0:
                        System.out.print(" "+" | ");
                        break;
                    case 1:
                        System.out.print("X"+" | ");
                        break;
                    case -1:
                        System.out.print("O"+" | ");
                        break;
                    default:
                        break;

                }
                
            }
            System.out.println();
        }
        System.out.println();
    }
}
