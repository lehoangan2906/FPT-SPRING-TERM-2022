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
public class ShopManager {
    ArrayList<Fruit> fruits = new ArrayList<>(); //lưu tất cả loại hoa quả mà cửa hàng bán
    
    Hashtable<String, ArrayList<Fruit>> bills = new Hashtable<>();
    
    public ArrayList<Fruit> getFruites(){
        return fruits;
    }
    
    public Hashtable<String, ArrayList<Fruit>> getBills(){
        return bills;
    }
    
    public void addBill(String name,ArrayList<Fruit> bill){
        bills.put(name + "@" + bills.size(), bill);
    }
    
    public void addFruit(String id, String name, double price, int quantity, String origin) {
        fruits.add(new Fruit(id, name, price, quantity, origin));
    }
    // kiểm tra sự tồn tại của id, có thì return lại object fruit đó không thì return null
    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruits) {
            if (id.equals(fruit.getId())) {
                return fruit;
            }
        }
        return null;
    }

    // kiểm tra sự tồn tại của mặt hàng đó trên bill của người dùng chưa, có thì return lại order về mặt hàng đó không thì return null
   
}
