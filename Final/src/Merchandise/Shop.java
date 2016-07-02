package Merchandise;

import Background.MerchandiseShortError;

public class Shop extends Inventory {

    public Shop(Inventory inventory, int quantity) {
        super(inventory, quantity);
    }

    public Shop(Merchandise merchandise, int quantity) {
        super(merchandise, quantity);
        // TODO Auto-generated constructor stub
    }

    public void ship(int wanted) {
        if (wanted > this.quantity)
            throw new MerchandiseShortError();
        
    }
}
