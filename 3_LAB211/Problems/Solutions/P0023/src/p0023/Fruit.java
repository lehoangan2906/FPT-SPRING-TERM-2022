
package p0023;

public class Fruit {
	private int fruitid;
	private String fruitname;
	private double price;
	private int quantity;
	private String origin;

	public Fruit(){}

	public Fruit(int fruitid, String fruitname, double price, int quantity, String origin){
		this.fruitid = fruitid;
		this.fruitname = fruitname;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
	}

	public int getFruitid() {
		return fruitid;
	}

	public void setFruitid(int fruitid) {
		this.fruitid = fruitid;
	}

	public String getFruitname() {
		return fruitname;
	}

	public void setFruitname(String fruitname) {
		this.fruitname = fruitname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

    @Override
    public String toString() {
        return "       " + fruitid + "           " + fruitname + "          " + price + "            " + quantity + "          " + origin;
    }

}
