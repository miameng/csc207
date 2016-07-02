package Merchandise;

import Background.Background;
import Background.MerchandiseShortError;

public class Shop extends Inventory {
    private final Background background;

    public Shop(Background background, Merchandise merchandise, int quantity) {
        super(merchandise, quantity);
        // TODO Auto-generated constructor stub
        this.background = background;
    }

    /**
     * Ships goods and reports to background.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
     * @param wanted
     */
    public void ship(int wanted) {
        if (wanted > this.quantity)
            throw new MerchandiseShortError();
        
        background.ship(new Order(this, wanted));
    }
}
