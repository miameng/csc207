package Client;

import Background.Background;
import Background.UserAlreadyExistsError;
import Background.UserCategoryWrongError;
import Background.UserLoginFailureError;

public class Client {
	
	Background background;
	
	public Client(Background background) {
        this.background = background;
    }

    public void message(String message) {
        // TODO to try message something on the menu
    }
    
    void userRegistration() {
        String ID = null, password = null, type = null;
        // TODO 
        // read the ID, the password and the type
        try {
            background.userRegistration(ID, password, type);
        } catch (UserAlreadyExistsError e) {
            // TODO
        } catch (UserCategoryWrongError e) {
            // TODO
        }
	}
	
	void userLogin() {
	    String ID = null, password = null;
        // TODO 
        // read the ID and the password
        try {
            background.userLogin(ID, password);
        } catch (UserLoginFailureError e) {
            // TODO
        }
	}
	
	void userLogout() {
	    background.userLogout();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
