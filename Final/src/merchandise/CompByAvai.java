package merchandise;

import java.util.Comparator;

public class CompByAvai implements Comparator<Product> {

    @Override
    public int compare(Product arg0, Product arg1) {
        return arg0.getQuantity() - arg1.getQuantity();
    }
}
