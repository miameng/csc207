package merchandise;

import java.util.Comparator;

import client.Item;

public class CompByAvai implements Comparator<Item> {

    @Override
    public int compare(Item arg0, Item arg1) {
        return arg0.mainData() - arg1.mainData();
    }
}
