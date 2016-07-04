package merchandise;

import java.awt.Image;
import java.util.List;

import client.Item;

public class Order implements Item {

    private final Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Image image() { return product.image(); }
    @Override
    public String description() { return product.description(); }
    @Override
    public int mainData() { return product.mainData(); }
    @Override
    public String extraData() { return String.format("%.2f", product.getPrice()); }
    @Override
    public List<Item> getTags() { return product.getTags(); }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
