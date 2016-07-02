package User;

import java.util.LinkedList;
import java.util.List;

import Background.Background;
import Merchandise.Order;

public class Shopper extends User {

    Invoice cart;
	List<Invoice> purchased;

	public Shopper(Background background, String iD, String password) {
        super(background, iD, password);
        cart = new Invoice();
        purchased = new LinkedList<Invoice>();
    }

	public void addToCart(Order order) {
		cart.modify(order);
	}
	
	public void order() {
	    
	}
	
	public String invoice() {
	    return cart.toString();
	}
	
	public String purchases() {
		String result = "";
		for (Invoice o: purchased)
			result += o;
		return result;
	}
}
