package merchandise;

import java.util.Comparator;
import java.util.Iterator;

import client.Item;

public class CompByCate implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        // TODO Auto-generated method stub
        Iterator<Item> i = o1.getTags().iterator();
        Iterator<Item> j = o2.getTags().iterator();
        
        for (; i.hasNext() || j.hasNext(); ) {
            if (!j.hasNext()) return 1;
            if (!i.hasNext()) return -1;
            int cmp = i.next().mainData() - j.next().mainData();
            if (cmp != 0) return cmp;
        }
        
        return 0;
    }

}
