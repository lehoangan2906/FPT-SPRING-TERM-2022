package p0023;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Shop {

    private ArrayList<Fruit> list = new ArrayList<>();
    private Hashtable<String, List<Fruit>> orderTable = new Hashtable<>();

    public Shop() {
        list.add(new Fruit(1, "Coconut", 2, 10, "VietNam"));
        list.add(new Fruit(2, "Orange", 3, 15, "VietNam"));
        list.add(new Fruit(3, "Apple", 9, 6, "VietNam"));
        list.add(new Fruit(4, "Banana", 4, 3, "VietNam"));

    }

    public void CreateFruit() throws IOException {
        int id = 1;

        while (true) {
            if (!list.isEmpty()) {
                // id cua moi phan tu moi bang id cua phan tu cuoi cung trong list + 1
                id = list.get(list.size() - 1).getFruitid() + 1;
            }

            String name = Utilities.getString("Enter name of the Product: ", "Invalid name", "[a-zA-Z ]+");
            double price = Utilities.getDouble("Enter price of the product ", "Invalid price", 0, Double.MAX_VALUE);
            int quantity = Utilities.getInt("Enter quantity of the product: ", "Invalid quantity", 0, Integer.MAX_VALUE);
            String origin = Utilities.getString("Enter the origin of the product: ", "Invalid Origin", "[a-zA-Z ]+");
            list.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Product Added");

            String choose = Utilities.getString("Do you want to continue adding (Y/N)?", "ReEnter your decision (Y/N)", "^[yYnN]$");
            if (choose.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void viewOrders() {
        if (orderTable.size() == 0) {
            System.out.println("\nThere's no order yet!\n");
        } else {
            for (Map.Entry<String, List<Fruit>> entry : orderTable.entrySet()) {
                String customerName = entry.getKey();
                List<Fruit> order = entry.getValue();
                System.out.println("\nCustomer: " + customerName);
                System.out.println("Product | Quantity | Price | Amount");

                double total = 0;
                for (int i = 0; i < order.size(); i++) {
                    Fruit fruit = order.get(i);
                    double bill = fruit.getPrice() * fruit.getQuantity();
                    total += bill;
                    System.out.println((i + 1) + ". " + fruit.getFruitname() + "    " + fruit.getQuantity() + "     " + fruit.getPrice() + "        " + fruit.getQuantity());
                }

                System.out.println("\nTotal: " + total + "$");
                System.out.println("\n");
            }
        }
    }

    public void display() {
        for (Fruit fruit : list) {
            System.out.println(fruit);
        }
    }

    public Fruit FindFruit(String name) {
        for (Fruit fruit : list) {
            if (fruit.getFruitname().equalsIgnoreCase(name)) {
                return fruit;
            }
        }
        return null;
    }

    public void Shopping() throws IOException {

        // tao mot arrayList chua cac san pham nguoi dung mua
        ArrayList<Fruit> order = new ArrayList<>();

        while (true) {
            System.out.println("List of fruit: ");
            System.out.println(" ------------------------------------------------------------------------- ");
            System.out.println("|    Item    |    FruitName    |    Price   |    Quantity   |   Origin    |");
            System.out.println(" ------------------------------------------------------------------------- ");
            display();
            System.out.println(" ------------------------------------------------------------------------- ");
            
            int lastID = list.get(list.size() - 1).getFruitid();

            // ask the user to choose fruit by name
            String name = Utilities.getString("\nEnter the Fruit you want to buy: ", "Invalid name", "[a-zA-Z ]+");
            Fruit fruit = FindFruit(name);
            if (fruit == null) {
                System.out.println("Fruit not found or maybe out of stock");
                continue;
            }

            System.out.println("You selected: " + fruit.getFruitname());

            // get the quantity of that fruit
            int quantity = Utilities.getInt("Input the quantity: ", "Invalid quantity [1 - " + fruit.getQuantity() + "]", 1, fruit.getQuantity());

            // check name
            boolean isIDExisted = false;
            for (Fruit fr : order) {
                if (fr.getFruitname().equals(name)) {
                    // fruit da co trong order, chi can tang quantity
                    fr.setQuantity(fr.getQuantity() + quantity);
                    isIDExisted = true;

                    // cap nhat so luong qua con lai trong kho
                    fruit.setQuantity(fruit.getQuantity() - quantity);
                }
            }

            // fruit chua co trong order
            if (!isIDExisted) {
                Fruit newFruit = new Fruit(fruit.getFruitid(), fruit.getFruitname(), fruit.getPrice(), fruit.getQuantity(), fruit.getOrigin());
                order.add(newFruit);

                // cap nhat lai so luong trong kho
                fruit.setQuantity(fruit.getQuantity() - quantity);
            }

            // het hang trong kho
            if (fruit.getQuantity() == 0) {
                list.remove(fruit);
            }

            String choose = Utilities.getString("Do you want to finish the order now (Y/N)?", "Please enter Y/N", "^[yYnN]$");

            if (choose.equalsIgnoreCase("y")) {
                break;
            }
        }

        String customerName = Utilities.getString("\nEnter your name: ", "Invalidate name", "[a-zA-Z ]+");

        // neu ten khach hang bi trung
        if (orderTable.containsKey(customerName)) {
            customerName += "#" + orderTable.size();
        }

        // tao mot entry moi trong ordertable chua hoa don cua nguoi dung vua mua
        orderTable.put(customerName, order);
        System.out.println("\nOrder successful!\n");
    }
}
