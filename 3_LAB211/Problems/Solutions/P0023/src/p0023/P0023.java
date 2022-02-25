
package p0023;

import java.io.IOException;

public class P0023 {

    public static void main(String[] args) throws IOException {
        Shop shop = new Shop();
        
        while(true){
            System.out.println(" --------  Fruit Shop ---------");
            System.out.println(" ------ Ordering System -------");
            System.out.println("|------------------------------|");
            System.out.println("| 1.   Create Fruits           |");
            System.out.println("| 2.   View Orders             |");
            System.out.println("| 3.   Shopping (buyer)        |");
            System.out.println("| 4.   Exit                    |");
            System.out.println(" ------------------------------ ");
            
            int choose = Utilities.getInt("Enter your choice [1 - 4]: ", "Invalid choice, [1 - 4] only", 1, 4);
            
            switch (choose){
                
                case 1:
                    shop.CreateFruit();
                    break;
                case 2:
                    shop.viewOrders();
                    break;
                case 3:
                    shop.Shopping();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
	
}
