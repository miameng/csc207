package User;

import Background.Background;

public abstract class User {
    
    final Background background;
    final String ID;
    String password;

    public User(Background background, String iD, String password) {
        super();
        this.background = background;
        ID = iD;
        this.password = password;
    }
    
    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
