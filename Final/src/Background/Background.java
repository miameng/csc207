package Background;

import java.util.LinkedList;
import java.util.List;

import Client.Client;
import Product.Category;
import Product.Order;
import Product.Product;
import User.Administrator;
import User.Shopper;
import User.User;

public class Background {
	
    public User user;
    Client client;
	List<User> users;
	List<Product> products, selectedProducts;
	List<Category> categories, selectedCats;
	
	public Background(Client client) {
	    this.client = client;
	    // TODO
	    // read files for users and inventories
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
	        if (u.getID() == ID)
	            throw new UserAlreadyExistsError("User " + ID + " already exists.");
	    if (type == "Shopper")
	        users.add((new Shopper(this, ID, password)));
	    else if (type == "Administrator")
            users.add(new Shopper(this, ID, password));
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
	    for (User u: users)
	        if (u.getID() == ID) {
	            if (u.getPassword() != password)
	                throw new UserPasswordWrongError();
	            
	            user = u;
	            return;
	        }
	    throw new UserDoesNotExistError("No such user named " + ID + ".");
	}
	
	/**
	 * Logs out the current user.
	 */
	public void userLogout() {
	    user = null;
	}
	
	/**
	 * Adds a category to the selected products.
     * Throws UserCategoryConfusionError if the current user is an administrator.
     * @param discription
	 */
	public void addCategory(String discription) {
	    if (!(user instanceof Administrator))
	        throw new UserCategoryConfusionError("Unable for an shopper to maintain categories.");
	    
        Category category = null;
	    for (Category c: categories)
	        if (c.getDescription() == discription) {
	            category = c; break;
	        }
	    if (category == null) {
	        category = new Category(discription);
	        categories.add(category);
	    }
        
	    for (Product product: selectedProducts)
	        product.addCategory(category);
	}
	
	/**
	 * Returns the categories.
	 * @return
	 */
	public List<Category> getCategories() {
        return categories;
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
        if (user instanceof Shopper)
            ((Shopper) user).purchase();
        else
            throw new UserCategoryConfusionError("Unable for an administrator to give orders.");
	}
	
	/**
	 * Gives an order to the product.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
	 * @param order
	 */
	public void giveOrder(Order order) {
	    try {
	        order.getProduct().ship(order.getQuantity());
	    } catch (MerchandiseShortError e) {
	        throw e;
	    }
	}
	
	/**
	 * Ship an order to the shopper if an order is coming.
	 * Throws UserCategoryConfusionError if the current user is an administrator.
	 * @param order
	 */
	public void ship(Order order) {
	    if (user instanceof Shopper)
	        ((Shopper) user).ship(order);
	    else
	        throw new UserCategoryConfusionError("Unable to ship goods to an administrator.");
	}
	
	/**
	 * Shows the purchases of the current user.
	 * Throws UserCategoryConfusionError if the current user is an administrator.
	 */
	public List<Order> showPurchases() {
        if (user instanceof Shopper)
            return ((Shopper) user).getPurchases();
        else
            throw new UserCategoryConfusionError("Unable to show purchases of an administrator.");
	}
}
