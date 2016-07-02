package User;

import java.util.LinkedList;
import java.util.List;

import Background.Background;
import Merchandise.Order;

public class Shopper extends User {

    List<Order> cart, purchased;

    public Shopper(Background background, String iD, String password) {
        super(background, iD, password);
        cart = new LinkedList<Order>();
        purchased = new LinkedList<Order>();
    }

    public void addToCart(Order order) {
        for (Order i : cart)
            if (i.getShop() == order.getShop()) {
                i.setQuantity(i.getQuantity() + order.getQuantity());
                return;
            }
        cart.add(order);
    }

    public void ship(Order order) {

    }

    public void giveOrder() {

    }

    public String invoice() {
        return cart.toString();
    }

    public String purchases() {
        String result = "";
        for (Order o : purchased)
            result += o;
        return result;
    }
}
