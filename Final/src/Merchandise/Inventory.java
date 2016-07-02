package Merchandise;

abstract class Inventory {
    private final Merchandise merchandise;
    protected int quantity;
    
    public Inventory(Merchandise merchandise, int quantity) {
        this.merchandise = merchandise;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }
    
}
