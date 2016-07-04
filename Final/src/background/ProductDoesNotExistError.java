package background;

public class ProductDoesNotExistError extends Error {

    private static final long serialVersionUID = 1L;

    public ProductDoesNotExistError() {}
    public ProductDoesNotExistError(String message) { super(message); }
}
