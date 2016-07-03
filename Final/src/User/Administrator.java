package User;

import java.awt.Image;
import java.util.List;

import Background.Background;
import Product.Category;
import Product.Product;

public class Administrator extends User {

    public Administrator(Background background, String iD, String password) {
        super(background, iD, password);
    }

    /**
     * Adds an category.
     * @param description
     * @param categories
     * @param selectedProducts
     */
    public void addCategory(String description, List<Category> categories, List<Product> Products) {
        Category category = null;
        for (Category c: categories)
            if (c.getDescription() == description) {
                category = c; break;
            }
        if (category == null) {
            category = new Category(description);
            categories.add(category);
        }
        
        for (Product product: Products)
            product.addCategory(category);
    }
    
    /**
     * Generates a list of categories.
     * @param categories
     * @return
     */
    public List<Category> generateCategories(List<Category> categories) {
        return categories;
    }
    
    /**
     * Adds a product.
     * @param products
     * @param image
     * @param description
     * @param price
     * @param quantity
     */
    public void addProduct(List<Product> products, 
            Image image, String description, double price, int quantity) {
        products.add(new Product(image, description, price, quantity));
    }
    
    /**
     * Changes the image of products.
     * @param products
     * @param image
     */
    public void changeProductImage(List<Product> products, Image image) {
        for (Product p: products)
            p.setImage(image);
    }
    
    /**
     * Changes the description of products.
     * @param products
     * @param description
     */
    public void changeProductDiscription(List<Product> products, String description) {
        for (Product p: products)
            p.setDiscription(description);
    }
    
    /**
     * Changes the description of products.
     * @param products
     * @param price
     */
    public void changeProductPrice(List<Product> products, double price) {
        for (Product p: products)
            p.setPrice(price);
    }
    
}
