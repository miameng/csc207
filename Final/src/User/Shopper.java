package User;

import java.util.LinkedList;
import java.util.List;

import Background.Background;
import Product.Order;

public class Shopper extends User {

    List<Order> cart, purchases;

    public Shopper(Background background, String iD, String password) {
        super(background, iD, password);
        cart = new LinkedList<Order>();
        purchases = new LinkedList<Order>();
    }
    
    public List<Order> getPurchases() {
        return purchases;
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
     * Receives the shipped order.
     * @param order
     */
    public void ship(Order order) {
        this.purchases.add(order);
    }

    /**
     * Gives orders to the background.
     * Report errors to the background if the current user is an administrator.
     */
    public void purchase() {
        for (Order o: cart)
            background.giveOrder(o);
        
        cart.clear();
    }

    public String invoice() {
        String result = cart.toString();
        // TODO
        return result;
    }
}
