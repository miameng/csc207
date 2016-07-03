package Product;

import java.util.LinkedList;
import java.util.List;

public class Category {
    private static int number;
    private final int code;
    private String description;
    List<Product> products;
    
    public Category(String description) {
        this.code = number++;
        this.description = description;
        products = new LinkedList<Product>();
    }

    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        for (Product s: products)
            if (s == product) return;
        products.add(product);
    }
}
