package SystemDesign.SnakeAndLadder;

public class GameBoard {
    Cell cells[][];
    public GameBoard(){
        cells = new Cell[10][10];
        for(int i=0;i<10;i++){
            for(int j = 0;j<10;j++){
                cells[i][j] = new Cell(i,j);
             }
        }
        initializeSnakesAndLadders();
    }
    public void initializeSnakesAndLadders(){
        int i = 0;
        while(i<5){
            int src = (int)(Math.random()*100);
            int dst = (int)(Math.random()*100);
            if(src>dst){
                Cell to_put = getCell(src);
                to_put.src = src;
                to_put.dst = dst;
            }
            i++;
        }
        i = 0;
        while(i<5){
            int src = (int)(Math.random()*100);
            int dst = (int)(Math.random()*100);
            if(src<dst){
                Cell to_put = getCell(src);
                to_put.src = src;
                to_put.dst = dst;
            }
            i++;
        }
    }
    public Cell getCell(int i){
        int p = 0;
        int y = 0;
        int x = 0;
        if(i%10==0){
            y = 9;
            x = i/10;
            if(i!=0){
                x-=1;
            }
        }else{
            x = i/10-p;
            y = i%10-1;
        }
        return cells[x][y];
    }
}
