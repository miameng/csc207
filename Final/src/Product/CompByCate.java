package Product;

import java.util.Comparator;
import java.util.Iterator;

public class CompByCate implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        // TODO Auto-generated method stub
        Iterator<Category> i = o1.getCategories().iterator();
        Iterator<Category> j = o2.getCategories().iterator();
        
        for (; i.hasNext() || j.hasNext(); ) {
            if (!j.hasNext()) return 1;
            if (!i.hasNext()) return -1;
            int cmp = i.next().compareTo(j.next());
            if (cmp != 0) return cmp;
        }
        
        return 0;
    }

}
