package Case;

public class SilverDiscount implements DiscountType{

	@Override
	public double applyDiscount(double price) {
		// TODO Auto-generated method stub
		return price * 0.80;
	}

}
