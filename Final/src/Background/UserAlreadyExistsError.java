package Background;

public class UserAlreadyExistsError extends Error {

    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsError() {}
    public UserAlreadyExistsError(String message) { super(message); }
}
