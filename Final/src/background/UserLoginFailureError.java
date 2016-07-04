package background;

public class UserLoginFailureError extends Error {

    private static final long serialVersionUID = 1L;

    public UserLoginFailureError() {}
    public UserLoginFailureError(String message) { super(message); }
}
