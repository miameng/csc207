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
	
	public void userLogout() {
	    user = null;
	}
	
	/**
	 * Ship an order to the shopper if an order is coming.
	 * Throws UserCategoryConfusionError if it is an administrator in control.
	 * @param order
	 */
	public void ship(Order order) {
	    if (user instanceof Shopper)
	        ((Shopper) user).ship(order);
	    else
	        throw new UserCategoryConfusionError("Unable to ship goods to an administrator.");
	}
}
