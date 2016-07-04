package user;

import java.util.LinkedList;
import java.util.List;

import client.Item;
import merchandise.Order;

public class Shopper extends User {

    List<Item> cart;
    List<List<Item>> purchases;

    public Shopper(String ID, String password) {
        super(ID, password);
        cart = new LinkedList<Item>();
        purchases = new LinkedList<List<Item>>();
    }
    
    /**
     * Adds an order to the cart.
     * @param order
     */
    public void addToCart(Order order) {
        for (Item i : cart) {
            Order o = (Order) i;
            if (o.getProduct() == order.getProduct()) {
                o.setQuantity(o.getQuantity() + order.getQuantity());
                return;
            }
        }
        cart.add(order);
    }

    /**
     * Gives orders to the background.
     * Report errors to the background if the current user is an administrator.
     */
    public void purchase() throws Error {
        for (Item o: cart)
            ((Order) o).getProduct().ship(((Order) o).getQuantity());
        
        purchases.add(cart);
        cart = new LinkedList<Item>();
    }
    
    /**
     * Shows a list of former purchases.
     * @return
     */
    public List<List<Item>> showPurchases() {
        return purchases;
    }
    
}
