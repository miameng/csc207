package merchandise;

import java.awt.Image;
import java.util.List;

import client.Item;

public class Order implements Item {

    private final Product PRODUCT;
    private int quantity;

    public Order(Product product, int quantity) {
        this.PRODUCT = product;
        this.quantity = quantity;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Image image() { return PRODUCT.image(); }
    @Override
    public String description() { return PRODUCT.description(); }
    @Override
    public int mainData() { return PRODUCT.mainData(); }
    @Override
    public String extraData() { return String.format("%.2f", PRODUCT.getPrice()); }
    @Override
    public List<Item> getTags() { return PRODUCT.getTags(); }

    public Product getProduct() {
        return PRODUCT;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
