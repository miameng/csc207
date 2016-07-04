package user;

import background.UserLoginFailureError;

public abstract class User {
    
    public final String ID;
    private String password;

    public User(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    /**
     * Checks the user.
     * Throws UserLoginFailureError if the check fails.
     * @param expassword
     * @param password
     */
    public void userCheck(String ID, String expassword, String password) {
        if (!ID.equals(this.ID) || !expassword.equals(this.password))
            throw new UserLoginFailureError();
        
        this.password = password;
    }
}
