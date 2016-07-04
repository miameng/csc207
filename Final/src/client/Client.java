/**
 * In package Client we implement all we need for GUI in this project, and run the main method.
 * 
 * All information of goods to display on the screen is in the form of class Item and class Listing. 
 * 
 * There are very few methods we can use, and very limited response to receive from package Background. 
 * 
 * Methods to use:
 * 
 * public void userRegistration(String ID, String password, String type)
 * public void userLogin(String ID, String password)
 * public void userLogout()
 * public void changeUserPassword(String Epassword, String password)
 * public void addCategory(String description)
 * public List<Item> generateCategories()
 * public void addProduct(Image image, String description, double price, int quantity)
 * public void changeProductImage(Image image)
 * public void changeProductDiscription(String description)
 * public void changeProductPrice(double price)
 * public void sortProducts(boolean byAvai, boolean inc)
 * public void addToCart(int ID, int quantity)
 * public void purchase()
 * public List<List<Item>> showPurchases()
 * 
 * Response to receive:
 * 
 * List<Item>
 * List<List<Item>>
 * MerchandiseShortError
 * ProductDoesNotExistError
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
