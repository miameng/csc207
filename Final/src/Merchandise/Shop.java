package Merchandise;

import Background.Background;
import Background.MerchandiseShortError;

public class Shop extends Inventory {
    private final Background background;

    public Shop(Background background, Merchandise merchandise, int quantity) {
        super(merchandise, quantity);
        // TODO Auto-generated constructor stub
        this.background = background;
        merchandise.addShop(this);
    }
    
    public boolean available(int wanted) {
        return wanted <= this.quantity;
    }

    /**
     * Ships goods and reports to background.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
     * Throws UserCategoryConfusionError and cancel the shipping if there occurs any error. 
     * @param wanted
     */
    public void ship(int wanted) {
        if (!available(wanted))
            throw new MerchandiseShortError(); // not enough goods
        
        try {
            this.quantity -= wanted;
            background.ship(new Order(this, wanted));
        } catch (UserCategoryConfusionError e) { // goods not successfully sent
            this.quantity += wanted;
            throw e;
        }
    }
}
