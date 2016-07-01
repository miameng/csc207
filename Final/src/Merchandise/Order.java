package Merchandise;

public abstract class Order {
	
	private Merchandise merchandise;
	int quantity;
	
	public Order(Merchandise merchandise, int quantity) {
		this.merchandise = merchandise;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order []";
	}

}
