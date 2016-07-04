package merchandise;

import java.util.Comparator;
import java.util.Iterator;

import client.Item;

public class CompByCate implements Comparator<Item> {

    @Override
    public int compare(Item i1, Item i2) {
        // TODO Auto-generated method stub
        Iterator<Item> i = ((Product) i1).getCategories().iterator();
        Iterator<Item> j = ((Product) i2).getCategories().iterator();
        
        for (; i.hasNext() || j.hasNext(); ) {
            if (!j.hasNext()) return 1;
            if (!i.hasNext()) return -1;
            int cmp = i.next().mainData() - j.next().mainData();
            if (cmp != 0) return cmp;
        }
        
        return 0;
    }

}
