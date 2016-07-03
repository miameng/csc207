package User;

import java.util.LinkedList;
import java.util.List;

import Background.Background;
import Background.MerchandiseShortError;
import Product.Order;

public class Shopper extends User {

    List<Order> cart;
    List<List<Order>> purchases;

    public Shopper(Background background, String iD, String password) {
        super(background, iD, password);
        cart = new LinkedList<Order>();
        purchases = new LinkedList<List<Order>>();
    }
    
    /**
     * Adds an order to the cart.
     * @param order
     */
    public void addToCart(Order order) {
        for (Order i : cart)
            if (i.getProduct() == order.getProduct()) {
                i.setQuantity(i.getQuantity() + order.getQuantity());
                return;
            }
        cart.add(order);
    }

    /**
     * Gives orders to the background.
     * Report errors to the background if the current user is an administrator.
     */
    public void purchase() throws MerchandiseShortError {
        for (Order o: cart)
            o.getProduct().ship(o.getQuantity());
        
        purchases.add(cart);
        cart = new LinkedList<Order>();
    }
    
    /**
     * Shows a list of former purchases.
     * @return
     */
    public List<List<Order>> showPurchases() {
        return purchases;
    }
    
}
