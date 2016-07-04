package background;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import merchandise.Category;
import merchandise.Order;
import merchandise.Product;
import user.Administrator;
import user.Shopper;
import user.User;

public class Background {
	
    private User user;
	private List<User> users;
	private List<Product> products, selectedProducts;
	private List<Category> categories;
	
	public Background() {
	    // TODO
	    // read files for users and products
	    selectedProducts = new LinkedList<Product>();
        categories = new LinkedList<Category>();
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
	 * Throws UserPasswordWrongError if the password does not match.
	 * Throws UserDoesNotExistError if the account does not exist. 
	 * @param ID
	 * @param password
	 */
	public void userLogin(String ID, String password) {
	    for (User u: users) {
	        user = u.login(ID, password);
	        if (user != null) return;
	    }
	    throw new UserLoginFailureError();
	}
	
	/**
	 * Logs out the current user.
	 */
	public void userLogout() {
	    user = user.logout();
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
	public List<Category> generateCategories() {
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
    public void changeProductDiscription(List<Product> products, String description) {
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
    public void changeProductPrice(List<Product> products, double price) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        ((Administrator) user).changeProductPrice(selectedProducts, price);
    }
    
    public void sortProducts(boolean byAvai, boolean inc) {
        if (!(user instanceof Administrator))
            throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
        
        ((Administrator) user).sortProducts(products, byAvai, inc);
    }
    
    /**
	 * Add the goods of quantity in product to the cart.
     * Throws UserCategoryConfusionError if the current user is an administrator.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
	 * @param product
	 * @param quantity
	 */
	public void addToCart(Product product, int quantity) {
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
	public List<List<Order>> showPurchases() {
        if (!(user instanceof Shopper))
            throw new UserCategoryConfusionError("Unable to show purchases of an administrator.");
        
        return ((Shopper) user).showPurchases();
	}
}