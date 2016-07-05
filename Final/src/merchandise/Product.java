package merchandise;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import background.MerchandiseShortError;
import client.Item;

public class Product implements Item {

    private static int number;
    public final int ID;
    private static Map<String, Image> images;
    private String image;
    private String description;
    private double price;
    private int quantity;
    private List<Item> categories;

    public Product(String image, String description, double price, int quantity) {
        ID = ++number;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categories = new LinkedList<Item>();
    }
    
    @Override
    public Image image() {
        if (image == null)
            return null;
        if (!images.containsKey(image)) {
            File f = new File(image);
            if (f.exists() && !f.isDirectory() && image.length() < 5 && 
                    image.substring(image.length() - 3).equals("png"))
                try {
                    images.put(image, ImageIO.read(new File(image)));
                } catch (IOException e) {
                    images.put(image, null);
                }
            else 
                images.put(image, null);
        }
        return images.get(image);
    }
    @Override
    public String description() { return description; }
    @Override
    public int mainData() { return quantity; }
    @Override
    public String extraData() { return String.format("%.2l", price); }
    @Override
    public List<Item> getTags() { return categories; }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public List<Item> getCategories() {
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
     * Shows if there are available quantity of wanted goods.
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
