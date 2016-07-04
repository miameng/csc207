package merchandise;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import client.Item;

public class Category implements Item {
    private static int number;
    private final int code;
    private final String description;
    private int quantity;
    private List<Item> products;
    
    public Category(String description) {
        this.code = number++;
        this.description = description;
        products = new LinkedList<Item>();
    }
    
    @Override
    public Image image() { return null; }
    @Override
    public String description() { return description; }
    @Override
    public int mainData() { return quantity; }
    @Override
    public String extraData() { return ""; }
    @Override
    public List<Item> getTags() { return products; }

    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public List<Item> getProducts() {
        return products;
    }
    /**
     * Adds a product.
     * @param product
     */
    public void addProduct(Product product) {
        for (Item s: products)
            if ((Product) s == product) return;
        products.add(product);
        quantity++;
    }
}
