package User;

import java.util.LinkedList;
import java.util.List;

import Merchandise.Order;

class Invoice {
    private List<Order> list;

    public Invoice() {
        list = new LinkedList<Order>();
    }

    @Override
    public String toString() {
        return list.toString();
    }
    
    public void modify(Order order) {
        for (Order i: list)
            if (i.getMerchandise() == order.getMerchandise()) {
                i.setQuantity(i.getQuantity() + order.getQuantity());
                return;
            }
        list.add(order);
    } 
}
