package User;

import Background.Background;

public abstract class User {
    
    final Background background;
    public final String ID;
    private String password;

    public User(Background background, String iD, String password) {
        this.background = background;
        ID = iD;
        this.password = password;
    }

    /**
     * Logs in this if ID and password are correct.
     * @param ID
     * @param password
     * @return
     */
    public boolean login(String ID, String password) {
        if (this.ID == ID && this.password == password) {
            background.user = this;
            return true;
        }
        return false;
    }
    
    /**
     * Logs out this if the current user is this.
     */
    public void logout() {
        if (background.user == this)
            background.user = null;
    }
    
    public void Browse() {
        // TODO
    }

}
