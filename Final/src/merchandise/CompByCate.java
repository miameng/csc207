package merchandise;

import java.util.Comparator;
import java.util.Iterator;

import client.Item;

public class CompByCate implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        // TODO Auto-generated method stub
        Iterator<Item> i = o1.getCategories().iterator();
        Iterator<Item> j = o2.getCategories().iterator();
        
        for (; i.hasNext() || j.hasNext(); ) {
            if (!j.hasNext()) return 1;
            if (!i.hasNext()) return -1;
            int cmp = i.next().mainData() - j.next().mainData();
            if (cmp != 0) return cmp;
        }
        
        return 0;
    }

}
