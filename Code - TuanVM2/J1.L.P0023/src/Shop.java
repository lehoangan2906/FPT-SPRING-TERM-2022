
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class Shop {

    private List<Fruit> listFruits = new ArrayList<>();
    private Hashtable<String, List<Fruit>> orderHashtable = new Hashtable<>();

    public Shop() {
        listFruits.add(new Fruit(1, "Coconut", 2, 10, "Viet Nam"));
        listFruits.add(new Fruit(2, "Orange", 3, 15, "US"));
        listFruits.add(new Fruit(3, "Apple", 4, 6, "Thailand"));
        listFruits.add(new Fruit(4, "Grape", 6, 3, "France"));
    }

    public void createNewFruit() {
        int id = 1;
        while (true) {
            if (!listFruits.isEmpty()) {
                id = listFruits.get(listFruits.size() - 1).getId() + 1;
            }
            String name = Validation.getString("Enter name: ", "Name invalid", "[a-zA-Z ]+");
            double price = Validation.getDouble("Enter price: ", "Price invalid", 0, Double.MAX_VALUE);
            int quantity = Validation.getInt("Enter quantity", "Quantity invalid", 1, Integer.MAX_VALUE);
            String origin = Validation.getString("Enter origin: ", "Origin invalid", "[a-zA-Z ]+");
            listFruits.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Add fruit successful!");
            String choose = Validation.getString("Do you want to continue (Y/N)?", "Please enter y|n|Y|N", "^[yYnN]$");
            if (choose.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void viewOrders() {
        for (Map.Entry<String, List<Fruit>> entry : orderHashtable.entrySet()) {
            String customerName = entry.getKey();
            List<Fruit> order = entry.getValue();
            System.out.println("Customer: " + customerName);
            System.out.println("Product | Quantity | Price | Amount");
            double sum = 0;
            for (int i = 0; i < order.size(); i++) {
                Fruit fruit = order.get(i);
                double amount = fruit.getPrice() * fruit.getQuantity();
                sum += amount;
                System.out.println((i + 1) + "." + fruit.getName()
                        + "\t" + fruit.getQuantity() + "\t" + fruit.getPrice() + "\t" + amount);
            }
            System.out.println("Total: " + sum + "$");

        }
    }

    public void shopping() {
        List<Fruit> order = new ArrayList<>();
        while (true) {
            System.out.println("List of Fruit:");
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
            displayListFruits();
            int lastId = listFruits.get(listFruits.size() - 1).getId();
            int id = Validation.getInt("Enter your id: ", "Id[1- " + lastId + "]", 1, lastId);
            Fruit fruit = findFruitById(id);
            if (fruit == null) {
                System.out.println("Fruit not found");
                continue;
            }
            System.out.println("You selected: " + fruit.getName());
            int quantity = Validation.getInt("Please input quantity: ", "Quantity[1-" + fruit.getQuantity() + "]", 1, fruit.getQuantity());
            String choose = Validation.getString("Do you want to order now (Y/N)", "Please enter y|n|Y|N", "^[yYnN]$");

            //check id
            boolean isIdExisted = false;
            for (Fruit f : order) {
                if (f.getId() == id) {//fruit da co trong order roi, cap nhat lai quantity
                    f.setQuantity(f.getQuantity() + quantity);
                    isIdExisted = true;
                    fruit.setQuantity(fruit.getQuantity() - quantity);
                    break;
                }
            }
            if (!isIdExisted) {//fruit chua co trong order
                Fruit orderFruit = new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(), quantity, fruit.getOrigin());
                order.add(orderFruit);
                fruit.setQuantity(fruit.getQuantity() - quantity);
            }
            if (fruit.getQuantity() == 0) {//het hang
                listFruits.remove(fruit);
            }
            if (choose.equalsIgnoreCase("y")) {
                break;
            }
        }
        String name = Validation.getString("Input your name: ", "Name invalid", "[a-zA-Z ]+");
        if (orderHashtable.containsKey(name)) {
            name += "@" + orderHashtable.size();
        }
        orderHashtable.put(name, order);
        System.out.println("Order successful!");
    }

    private void displayListFruits() {
        for (Fruit fruit : listFruits) {
            System.out.println(fruit);
        }
    }

    private Fruit findFruitById(int id) {
        for (Fruit fruit : listFruits) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

}
