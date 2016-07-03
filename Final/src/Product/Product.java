package Product;

import java.awt.Image;
import java.util.SortedSet;
import java.util.TreeSet;

import Background.MerchandiseShortError;

public class Product {

    private static int number;
    private final int ID;
    private Image image;
    private String description;
    private double price;
    private int quantity;
    SortedSet<Category> categories;

    public Product(Image image, String description, double price, int quantity) {
        ID = ++number;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categories = new TreeSet<Category>();
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public String getDiscription() {
        return description;
    }
    public void setDiscription(String description) {
        this.description = description;
    }
    public int getID() {
        return ID;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public SortedSet<Category> getCategories() {
        return categories;
    }
    /**
     * Adds a new category to this product.
     * @param category
     */
    public void addCategory(Category category) {
        categories.add(category);
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
     * @param wanted
     */
    public void ship(int wanted) {
        if (!available(wanted))
            throw new MerchandiseShortError(); // not enough goods
        
        this.quantity -= wanted;
    }
}
