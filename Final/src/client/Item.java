package client;

import java.awt.Image;
import java.util.List;

public interface Item {
    Image image();
    String description();
    int mainData();
    String extraData();
    List<Item> getTags();
}
