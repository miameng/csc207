package Background;

import java.util.List;

import Client.Client;
import Merchandise.Order;
import Merchandise.Shop;
import User.Shopper;
import User.User;

public class Background {
	
    User user;
    Client client;
	List<User> users;
	List<Shop> shops;
	
	public Background(Client client) {
	    this.client = client;
	    // read files for users and inventories
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
	        users.add(new Shopper(this, ID, password));
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
	 * Add the goods of quantity in shop to the cart.
     * Throws UserCategoryConfusionError if the current user is an administrator.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
	 * @param shop
	 * @param quantity
	 */
	public void addToCart(Shop shop, int quantity) {
        if (!(user instanceof Shopper))
            throw new UserCategoryConfusionError("Unable for an administrator to add goods to the cart.");
        else if (!shop.available(quantity))
	        throw new MerchandiseShortError();
        else
            ((Shopper) user).addToCart(new Order(shop, quantity));
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
	 * Gives an order to the shop.
     * Throws MerchandiseShortError if there is not enough goods available in the stock.
	 * @param order
	 */
	public void giveOrder(Order order) {
	    try {
	        order.getShop().ship(order.getQuantity());
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
}
