package Case;

public class Customer {
	private String username;
	private String password;
	private DiscountType discountType;

	public Customer(String username, String password, DiscountType discountType) {
		super();
		this.username = username;
		this.password = password;
		this.discountType = discountType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public double discountType(double price) {
		return discountType.applyDiscount(price);
	}
}
