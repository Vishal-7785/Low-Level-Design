public class Ball {

    public Ball(){
        System.out.println("Taking new ball fo the inning");
        System.out.println();
    }
    
    public BALLTYPE deliveringBall(){
        int rand =(int) (Math.random() * 7);

        switch(rand){
            case 0: 
                return BALLTYPE.WICKET;
            case 1:
                return BALLTYPE.SINGLE;
            case 2:
                return BALLTYPE.DOUBLE;
            case 3:
                return BALLTYPE.FOUR;
            case 4:
                return BALLTYPE.SIX;
            case 5: 
                return BALLTYPE.WIDE;
            case 6:
                return BALLTYPE.NO;
            default:
                return BALLTYPE.SINGLE;
        }
    }

}
