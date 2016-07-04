package user;

import java.awt.Image;
import java.util.Collections;
import java.util.List;

import client.Item;
import merchandise.Category;
import merchandise.CompByAvai;
import merchandise.CompByCate;
import merchandise.Product;

public class Administrator extends User {

    public Administrator(String ID, String password) {
        super(ID, password);
    }

    /**
     * Adds an category.
     * @param description
     * @param categories
     * @param selectedProducts
     */
    public void addCategory(String description, List<Item> categories, List<Item> Products) {
        Category category = null;
        for (Item c: categories)
            if (((Category) c).getDescription() == description) {
                category = (Category) c; break;
            }
        if (category == null) {
            category = new Category(description);
            categories.add(category);
        }
        for (Item p: Products)
            ((Product) p).addCategory(category);
    }
    
    /**
     * Generates a list of categories.
     * @param categories
     * @return
     */
    public List<Item> generateCategories(List<Item> categories) {
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
    public void addProduct(List<Item> products, 
            Image image, String description, double price, int quantity) {
        products.add(new Product(image, description, price, quantity));
    }
    
    /**
     * Changes the image of products.
     * @param products
     * @param image
     */
    public void changeProductImage(List<Item> products, Image image) {
        for (Item p: products)
            ((Product) p).setImage(image);
    }
    
    /**
     * Changes the description of products.
     * @param products
     * @param description
     */
    public void changeProductDiscription(List<Item> products, String description) {
        for (Item p: products)
            ((Product) p).setDescription(description);
    }
    
    /**
     * Changes the description of products.
     * @param products
     * @param price
     */
    public void changeProductPrice(List<Item> products, double price) {
        for (Item p: products)
            ((Product) p).setPrice(price);
    }
    
    /**
     * Sorts the products by given order.
     * @param products
     * @param byAvai
     * @param inc
     */
    public List<Item> sortProducts(List<Item> products, boolean byAvai, boolean inc) {
        Collections.sort(products, byAvai ? new CompByAvai() : new CompByCate());
        if (!inc) Collections.reverse(products);
        return products;
    }
}
