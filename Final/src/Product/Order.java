package Product;

import java.util.List;

public class Order {

    private final Product product;
    private int quantity;
    private List<Category> categories;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        // TODO Auto-generated constructor stub
    }

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
