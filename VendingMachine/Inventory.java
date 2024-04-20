import java.util.HashMap;

public class Inventory {
    public Item items[][] = new Item[3][3];
    public Inventory(){
        initializeinventory();
    }
    HashMap<Integer,Item> itemMap = new HashMap<Integer,Item>();
    private void initializeinventory(){
        for(int i=0;i<3;i++){
            for(int j = 0;j<3;j++){
                switch(i){
                    case 0:
                        Item i0 = new Pepsi(100,100+j,"Pepsi",true);
                        items[i][j] = i0;
                        itemMap.put(100+j,i0);
                        break;
                    case 1:
                        Item i1 = new Coke(100,200+j,"Cokes",true);
                        itemMap.put(200+j,i1);
                        items[i][j] = i1;
                        break;
                    case 2:
                        Item i2 = new Biscuit(100,300+j,"Biscu",true);
                        itemMap.put(300+j,i2);
                        items[i][j] = i2;
                        break;
                    default:
                        break;
                }

            }
        }
    }
    public void showInventory(){
        System.out.println("   Welcome to Vending Machine");
        System.out.println();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print("    ");
                System.out.print(items[i][j].getName());
            }
            System.out.println();
            for(int j=0;j<3;j++){
                System.out.print("      ");
                System.out.print(items[i][j].getPrice());
                
            }
            System.out.println();
            for(int j = 0;j<3;j++){
                System.out.print("      ");
                System.out.print(items[i][j].getId());
                
            }
            System.out.println();
            for(int j = 0;j<3;j++){
                System.out.print("      ");
                System.out.print(items[i][j].getSoldout());
                
            }
            System.out.println();
            System.out.println();
        }
    }


    public Item getProduct(int id){
        if(itemMap.containsKey(id)){
            return itemMap.get(id);
        }
        return null;
    }

}
