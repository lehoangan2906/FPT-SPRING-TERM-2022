
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
public class Main {

    public static void main(String[] args) {
       Main m =new Main();
       ShopManager shop= new ShopManager();
        while (true) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                   m.inputFruit(shop);
                    break;
                case 2:
                    m.DisplayAllBill(shop.getBills());
                    break;
                case 3:
                    m.shopping(shop);
                    break;
                case 4:
                    return;
            }
        }
    }

    static int displayMenu() {

        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputInt(1, 4);
        return choice;
    }
    
   public  void inputFruit(ShopManager shop) {

        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString().toUpperCase();
           
            Fruit f = shop.getFruitById(fruitId);
            if (f != null) {
                // nếu id tồn tại rồi thì hỏi người dùng có thay đổi quantity của fruit hay không
                System.out.println("Id already exists");
                System.out.println("Do you want to change quantity in stock (Y/N)?");
                if (!Validation.checkInputYN()) {
                    break;
                } else {
                    System.out.print("Enter quantity: ");
                    int quantity = Validation.checkInputInt(1, 1000);
                    f.setQuantity(quantity);
                    break;
                }
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputPrice();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt(1, 1000);
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            shop.addFruit(fruitId, fruitName, price, quantity, origin);
            System.out.println("Do you want to continue (Y/N)?");
            if (!Validation.checkInputYN()) {
                break;
            }
        }
        displayAllFruit(shop.getFruites());
    }
   
   
    static void DisplayAllBill(Hashtable<String, ArrayList<Fruit>> bills) {
        // in ra tất cả giao dịch từ trước đếna giờ
        for (String name : bills.keySet()) {
           
            System.out.println("Customer: " + name.split("@")[0]);   // chỉ lấy phần đằng trước của dấu @
            ArrayList<Fruit> bill = bills.get(name);
            displayBill(bill);
            System.out.println("");
        }
    }
      
    static void displayBill(ArrayList<Fruit> bill) {
        double total = 0;
        int z=1;
        System.out.println("Product | Quantity | Price | Amount");
        for (Fruit f : bill) {
            System.out.printf("%d.%-10s%-11d%-8s%-7s\n", 
                    z,
                    f.getName(),
                    f.getQuantity(), f.getPrice() + " $",
                    f.getPrice() * f.getQuantity() + " $");
            total += f.getPrice() * f.getQuantity();
            z++;
        }
        System.out.println("Total: " + total + " $");
    }
     
    static void displayAllFruit(ArrayList<Fruit> lf) {
        int count = 1;
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ | ");
        for (Fruit fruit : lf) {
            System.out.printf("%-15d%-19s%-15s%-12s\n", count++,
                    fruit.getName(), fruit.getOrigin(), Double.toString(fruit.getPrice()) + " $");

        }
    }

     public static  Fruit getFruitInBill( ArrayList<Fruit> fruits,String id) {
        for (Fruit f : fruits) {
            if (f.getId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }
    static void shopping(ShopManager shop) {
        
        ArrayList<Fruit> fruits= shop.getFruites();
        if (fruits.isEmpty()) {
            System.out.println("Shop dont have fruits.");
            return;
        }
        //lưu tất cả sản phẩm trong 1 lần order của người dùng
        ArrayList<Fruit> bill = new ArrayList<>();
        Main m =new Main();
     
        while (true) {
            m.displayAllFruit(fruits);
            System.out.print("Enter item: ");
            int item = Validation.checkInputInt(1, fruits.size()); //nhập số thứ tự của fruit có trong bảng
            Fruit fruit = fruits.get(item - 1);
            if (fruit.getQuantity() < 1) {
                System.out.println("This fruit is out of stock.");
                System.out.println("Do you want to continue to buy (Y/N)?");
                if (!Validation.checkInputYN()) {
                    break;
                } else {
                    continue;
                }

            }
            System.out.println("Please input quantity:");
            int quantity = Validation.checkInputInt(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            Fruit f = getFruitInBill(bill,fruit.getId()); //check trong 1 lần order người dùng đã mua loại fruit đấy hay chưa
//            Fruit f =shop.getFruitById(fruit.getId());
            if (f != null) {
    
                //nếu có rồi thì sẽ update lại quantity
                f.setQuantity(f.getQuantity() + quantity);
            } else {
                f= new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(),quantity, fruit.getOrigin());
                bill.add(f);
            }
            System.out.println("Do you want to order now (Y/N)");
            if (Validation.checkInputYN()) {
                break;
            }
        }
        // kiểm tra xem người dùng có mua bất kì loại hoa quả gì không
        // nếu mua ít nhất 1 loại thì mới cho người dùng thanh toán

        if (!bill.isEmpty()) {
            m.displayBill(bill);
            System.out.print("Enter name: ");
            String name = Validation.checkInputString();
            // thêm vào hashtable 1 cặp key-value
            // key là tên người dùng + @ + size của hashtable để tránh trùng với key trước
            // value là list item người ta mua
            shop.addBill(name, bill);
            System.out.println("Buy successfull");
        }

    }

 

 
    

}