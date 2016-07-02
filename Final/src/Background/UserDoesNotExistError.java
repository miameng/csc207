package Background;

public class UserDoesNotExistError extends Error {

    private static final long serialVersionUID = 1L;

    public UserDoesNotExistError() {}
    public UserDoesNotExistError(String message) { super(message); }
}
