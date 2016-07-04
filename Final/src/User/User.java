package User;

import Background.Background;

public abstract class User {
    
    final Background background;
    public final String ID;
    private String password;

    public User(Background background, String ID, String password) {
        this.background = background;
        this.ID = ID;
        this.password = password;
    }

    /**
     * Logs in this if ID and password are correct.
     * @param ID
     * @param password
     * @return
     */
    public User login(String ID, String password) {
        return this.ID == ID && this.password == password ? this : null;
    }
    
    /**
     * Logs out this if the current user is this.
     */
    public User logout() {
        return null;
    }
    
    public void Browse() {
        // TODO
    }

}
