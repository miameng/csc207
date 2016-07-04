package merchandise;

import java.util.LinkedList;
import java.util.List;

public class Category implements Comparable<Category>, Merchandise {
    private static int number;
    private final int code;
    private String description;
    List<Product> products;
    
    public Category(String description) {
        this.code = number++;
        this.description = description;
        products = new LinkedList<Product>();
    }
    
    @Override
    public int compareTo(Category other) {
        return this.code - other.code;
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
