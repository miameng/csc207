package User;

import java.util.List;

import Merchandise.SalesOrder;

public class Shopper extends User {
	
	List<SalesOrder> cart, purchased;

	public void browse() {
		
	}
	
	public void registration() {
		
	}
	
	public void login() {
		
	}
	
	public void addOrder() {
		
	}
	
	public String invoiceOfCart() {
		String result = "";
		for (SalesOrder o: cart)
			result += o;
		return result;
	}
	
	public String purchases() {
		String result = "";
		for (SalesOrder o: purchased)
			result += o;
		return result;
	}
}
