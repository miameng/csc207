/**
 * In package Client we implement all we need for GUI in this project.
 * 
 * 
 * 
 * There are very limited methods we can use. All of them are from package Background. 
 * 
 * public void userRegistration(String ID, String password, String type)
 * public void userLogin(String ID, String password)
 * public void userLogout()
 * public void addCategory(String description)
 * public List<Category> generateCategories()
 * public void addProduct(Image image, String description, double price, int quantity)
 * public void changeProductImage(Image image)
 * public void changeProductDiscription(List<Product> products, String description)
 * public void changeProductPrice(List<Product> products, double price)
 * public void sortProducts(boolean byAvai, boolean inc)
 * public void addToCart(Product product, int quantity)
 * public void purchase()
 * public List<List<Order>> showPurchases()
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
