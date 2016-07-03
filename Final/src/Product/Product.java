package Product;

import java.awt.Image;
import java.util.List;
import java.util.LinkedList;

import Background.Background;
import Background.MerchandiseShortError;
import Background.UserCategoryConfusionError;

public class Product {

    private final Background background;
    private static int number;
    private final int ID;
    private Image image;
    private String discription;
    private int quantity;
    List<Category> categories;

    public Product(Background background, Image image, String discription, int quantity) {
        this.background = background;
        ID = ++number;
        this.image = image;
        this.discription = discription;
        this.quantity = quantity;
        this.categories = new LinkedList<Category>();
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public int getID() {
        return ID;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void addCategory(Category category) {
        if (categories.contains(category)); // TODO what to do?
        else {
            categories.add(category);
            category.addProduct(this);
        }
    }

    /**
     * Shows if there are available quantity of wanted goods
     * @param wanted
     * @return
     */
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
