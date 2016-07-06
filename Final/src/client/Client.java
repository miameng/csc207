/**
 * In package Client we implement all we need for GUI in this project, and run the main method.
 * 
 * All information of goods to display on the screen is in the form of class Item and class Listing. 
 * 
 * There are very few methods we can use, and very limited response to receive from package Background. 
 * 
 * Methods to use:
 * 
 * public Background() throws IOException
 * public void userRegistration(String ID, String password, String type) throws IOException
 * public void userLogin(String ID, String password)
 * public void userLogout()
 * public void changeUserPassword(String formerPassword, String password) throws IOException
 * public void addCategory(Item product, String description) throws IOException
 * public List<Item> generateCategories()
 * public void addProduct(String image, String description, double price, int quantity)
 * public void changeProductImage(Item product, String image) throws IOException
 * public void changeProductDiscription(Product product, String description) throws IOException
 * public void changeProductPrice(Product product, double price) throws IOException
 * public void addToCart(Item i, int quantity) throws IOException
 * public void purchase() throws IOException
 * public List<List<Item>> showPurchases()
 * 
 * Response to receive:
 * 
 * IOException (if it fails to make local changes)
 * List<Item>
 * List<List<Item>>
 * MerchandiseShortError
 * UserAlreadyExistsError
 * UserCategoryConfusionError
 * UserCategoryWrongError
 * UserLoginFailureError
 *
 */
package client;

import background.Background;

public class Client {
	
	Background background;
	
	public Client(Background background) {
        this.background = background;
    }

    public void message(String message) {
        // TODO to try message something on the menu
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
