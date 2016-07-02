package Merchandise;

public class Order {

    private final Shop shop;
    private int quantity;

    public Order(Shop shop, int quantity) {
        this.shop = shop;
        this.quantity = quantity;
        // TODO Auto-generated constructor stub
    }

    public Shop getShop() {
        return shop;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
