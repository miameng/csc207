package background;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import client.Item;
import merchandise.Order;
import merchandise.Product;
import user.Administrator;
import user.Shopper;
import user.User;

public class Background {
	
    private User user;
	private List<User> users;
	private List<Item> products, selectedProducts, categories;
	
	public Background() {
	    users = new LinkedList<User>();
	    products = new ArrayList<Item>(); // in ID order
        categories = new ArrayList<Item>(); // in ID order
	    // TODO
	    // read files for users, products and categories.
	    selectedProducts = new LinkedList<Item>();
	}
	
	/**
	 * Registers a user with ID, password and type.
	 * Throws UserAlreadyExistsError if the ID exists.
	 * Throws UserCategoryWrongError if the type is neither Shopper nor Administrator.
	 * @param ID
	 * @param password
	 * @param type
	 */
	public void userRegistration(String ID, String password, String type) {
	    for (User u: users)
	        if (u.ID == ID)
	            throw new UserAlreadyExistsError("User " + ID + " already exists.");
	    if (type == "Shopper")
	        users.add((new Shopper(ID, password)));
	    else if (type == "Administrator")
            users.add(new Shopper(ID, password));
	    else throw new UserCategoryWrongError("Unknown user category " + type + ".");
	}
	
	/**
	 * Logs in a user with ID and password.
	 * Throws UserLoginFailureError if the account does not exist. 
	 * @param ID
	 * @param password
	 */
	public void userLogin(String ID, String password) {
	    for (User u: users) {
	        try {
	            user.userCheck(ID, password, password);
	        } catch (UserLoginFailureError e) {
	            continue;
	        }
	        user = u; break;
	    }
	    throw new UserLoginFailureError();
	}
	
	/**
	 * Logs out the current user.
     * Throws UserCategoryConfusionError if no one logged in.
	 */
	public void userLogout() {
	    if (user == null)
	        throw new UserCategoryConfusionError("Not logged in.");
	}
	
	/**
	 * Changes the password for the current user.
     * Throws UserCategoryConfusionError if no one logged in.
     * Throws UserLoginFailureError if the prime password is incorrect.
	 * @param Epassword
	 * @param password
	 */
	public void changeUserPassword(String Epassword, String password) {
	    if (user == null)
            throw new UserCategoryConfusionError("Not logged in.");
	    try {
	        user.userCheck(user.ID, Epassword, password);
	    } catch (UserLoginFailureError e) {
	        throw new UserLoginFailureError("The input password is incorrect.");
	    }
	}
	
	/**
	 * Adds a category to the selected products.
     * Throws UserCategoryConfusionError if the current user is an Shopper.
     * @param description
	 */
	public void addCategory(String description) {
	    if (!(user instanceof Administrator))
	        throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
	    
	    ((Administrator) user).addCategory(description, categories, selectedProducts);
	}
	
	/**
	 * Generates a list of the categories.
     * Throws UserCategoryConfusionError if the current user is an Shopper.
	 * @return
	 */
	public List<Item> generateCategories() {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        return ((Administrator) user).generateCategories(categories);
    }
	
	/**
	 * Adds a new product with properties.
     * Throws UserCategoryConfusionError if the current user is an Shopper.
	 * @param image
	 * @param description
	 * @param price
	 * @param quantity
	 */
	public void addProduct(Image image, String description, double price, int quantity) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
	    
        ((Administrator) user).addProduct(products, image, description, price, quantity);
	}

    /**
     * Changes the image of selected products.
     * Throws UserCategoryConfusionError if the current user is an Shopper.
     * @param products
     * @param image
     */
    public void changeProductImage(Image image) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        ((Administrator) user).changeProductImage(selectedProducts, image);
    }
    
    /**
     * Changes the description of selected products.
     * Throws UserCategoryConfusionError if the current user is an Shopper.
     * @param products
     * @param description
     */
    public void changeProductDiscription(String description) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        ((Administrator) user).changeProductDiscription(selectedProducts, description);
    }
    
    /**
     * Changes the description of selected products.
     * Throws UserCategoryConfusionError if the current user is an Shopper.
     * @param products
     * @param price
     */
    public void changeProductPrice(double price) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        ((Administrator) user).changeProductPrice(selectedProducts, price);
    }
    
    /**
     * Returns a sorted version of all products by given order.
     * @param byAvai
     * @param inc
     * @return
     */
    public List<Item> sortProducts(boolean byAvai, boolean inc) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        return ((Administrator) user).sortProducts(new LinkedList<Item>(products), byAvai, inc);
    }
    
    /**
	 * Add the goods of quantity in product to the cart.
	 * Throws ProductDoesNotExistError if the product to add does not exist.
     * Throws UserCategoryConfusionError if the current user is an administrator.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
	 * @param product
	 * @param quantity
	 */
	public void addToCart(int ID, int quantity) {
        Product product;
	    try {
	        product = (Product) products.get(ID);
	    } catch (IndexOutOfBoundsException e) {
	        throw new ProductDoesNotExistError();
	    }
        if (!(user instanceof Shopper))
            throw new UserCategoryConfusionError("Unable for an administrator to add goods to the cart.");
        if (!product.available(quantity))
	        throw new MerchandiseShortError();
        
        ((Shopper) user).addToCart(new Order(product, quantity));
	} 
	
	/**
	 * Processes a purchase.
	 * Throws UserCategoryConfusionError if the current user is an administrator.
	 */
	public void purchase() {
        if (!(user instanceof Shopper))
            throw new UserCategoryConfusionError("Unable for an administrator to give orders.");
        
        ((Shopper) user).purchase();
	}
	
	/**
	 * Shows the purchases of the current user.
	 * Throws UserCategoryConfusionError if the current user is an administrator.
	 */
	public List<List<Item>> showPurchases() {
        if (!(user instanceof Shopper))
            throw new UserCategoryConfusionError("Unable to show purchases of an administrator.");
        
        return ((Shopper) user).showPurchases();
	}
}
