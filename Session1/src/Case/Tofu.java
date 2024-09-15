package Case;

public class Tofu {
	private String name;
	private int price;
	
	public Tofu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return name + "-" + price;
	}
	
}
